var q = require('q');
var http = require('http');
var express = require('express');
var norris = require('./main');

var socketio = require('socket.io');
var sio = socketio(server);


var app = express();
var server = http.createServer(app);

var settings = {
    login: function (cookie, username, password) {
        if (username === 'Kaizen' && password === 'Team') {
            cookie.setCookie('ssid', 'true');
            return true;
        }
        cookie.clearCookie('ssid');
        return false;
    },
    isLogged: function (cookie) {
        return cookie.getCookies.ssid === 'true';
    },
    keepAlive: function (cookie) {
        return cookie.getCookies.ssid === 'true';
    },
    logout: function (cookie) {
        cookie.clearCookie('ssid');
        return true;
    }
}

var rtc = norris(server, app, settings);

server.listen(9000);

process.on('uncaughtException', function (e) {
    console.error(e);
});


// ------------- GRAFICO SINGOLO -------------
var bc = rtc.createChart('barchart', 'bc');

bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', values: [1,2,3,4,5]},
        {name: 'pluto', values: [1,2,0,4,5]},
        {name: 'paperino', values: [1,2,3,4,5]}
    ]
});
bc.setSettings({title:'My Chart',description: 'Esempio di bar chart orizzontale', orientation : 'horizontal', style: {barArea: '80%', showGrid: true, maxValue: 10, minValue: 0}})
setInterval(barchart, 2000);

function barchart() {
    var update = {inplace : 
        [{
            position: {
                x: Math.floor(Math.random() * 3),
                y: Math.floor(Math.random() * 5)
            },
            data: Math.floor(Math.random() * 10)
        }]
    };
    bc.update('inplace', update);
};




// ------------- DASHBOARD -------------
var lines = ['01','03','05','06','07','09','10','11','12','13','15','16','18','22','24','41','42','43','CC','DC','SIR1'];


// norris init
var map = rtc.createChart('mapchart', 'map');
var table = rtc.createChart('table', 'table');
var dashboard = rtc.createPage('dashboard').add(map).add(table);
dashboard.setSettings({title: 'Dashboard APS'});

app.use(rtc.getMiddleware());

// settings
dashboard.setSettings({
    maxChartsCol: 1
});
map.setSettings({
    title: 'Mappa autobus',
    description: 'Posizione degli autobus dell\'APS',
    allowFilter: true,
    maxItems: 40,
    area: {
        y: 45.4043344,
        x: 11.8830057,
        zoom: 12
    }
});

table.setSettings({
    title: 'Autobus attivi',
    description: 'Numero di autobus dell\'APS attivi per linea',
    pageSize: 8,
    allowFilter: true,
    allowSort: true
});

// data
var mapData = {
    datasets: []
}
var tableData = {
    headers: ['Linea', 'Autobus'],
    datasets: []
}
lines.forEach(function (line) {
    mapData.datasets.push({
        name: line,
        color: '#ff0000',
        marker: 'bus',
        values: []
    });
    tableData.datasets.push({
        row: [
            {value: line},
            {value: '0'}
        ]
    });
});
map.setData(mapData);
table.setData(tableData);

lines.forEach(function (line) {
    updateLine(line);
});

function updateLine(line) {
    getLineFromAPS(line)
        .then(function (result) {
            if(result.length > 0) {

                // map

                var updateData = {};
                updateData.delete = [];
                updateData.stream = [];

                var chartData = map.getData().datasets;
                var series;
                for (var i in chartData) {
                    if (chartData[i].name === line) {
                        series = i;
                    }
                }

                // elimina tutti i punti
                for(var i in chartData[series].values) {
                    updateData.delete.push({
                        series: parseInt(series),
                        index: parseInt(i)
                    });
                }

                // riaggiunge tutti i punti
                for(var i in result) {
                    updateData.stream.push({
                        series: parseInt(series),
                        data: {
                            x: result[i].WGS84La,
                            y: result[i].WGS84Fi
                        }
                    });
                }

                map.update('movie', updateData);


                // table

                var updateData = {};
                updateData.inplace = [];

                var chartData = table.getData().datasets;
                var series;
                for (var i in chartData) {
                    if (chartData[i].row[0].value === line) {
                        series = i;
                    }
                }

                updateData.inplace.push({
                    position: {
                        x: parseInt(series),
                        y: 1
                    },
                    data: {
                        value: result.length.toString()
                    }
                });
                
                table.update('inplace', updateData);

            }
        }, function () {
            console.error('Error during the request');
        })
        .finally(function () {
            setTimeout(function () {updateLine(line)});
        });
}


function getLineFromAPS(line) {
    var deferred = q.defer();
    var data = 'l=' + line;
    var options = {
        hostname: 'www.apsholding.it',
        port: 80,
        path: '/index.php/informazioni/dov-e-il-mezzo-pubblico-in-tempo-reale?option=com_mappeaps&view=posmezzi&format=raw',
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Content-Length': data.length 
        }
    };

    var body = '';
    var req = http.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            body += chunk;
        })
        res.on('end', function () {
            var info = JSON.parse(body);
            deferred.resolve(info);
        })
        res.on('error', function () {
            deferred.reject();
        })
    });

    req.write(data, 'utf8');
    req.end();
    return deferred.promise;
};


// ------------- SENSOR -------------
var acc = rtc.createChart('linechart', 'acc');
var gyro = rtc.createChart('linechart', 'gyro');

var page = rtc.createPage('sensor').add(acc).add(gyro);
page.setSettings({title: 'Sensor'});



acc.setData({
    labels: ["0"],
    datasets: [
        {name: 'x', values: [0], color:"#ff0000"},
        {name: 'y', values: [0], color:"#00ff00"},
        {name: 'z', values: [0], color:"#0000ff"}
    ]
})
acc.setSettings({
    title:'Accelerometro',
    description: 'Questo grafico mostra i dati provenienti da un accelerometro.',
    legendPosition: 'left',
    style: {
        animationDuration: 0,
        maxValue: 100,
        minValue: -100
    }
})

gyro.setData({
    labels: ["0"],
    datasets: [
        {name: 'x', values: [0], color:"#ff0000"},
        {name: 'y', values: [0], color:"#00ff00"},
        {name: 'z', values: [0], color:"#0000ff"}
    ]
})
gyro.setSettings({
    title:'Giroscopio',
    description: 'Questo grafico mostra i dati provenienti da un giroscopio.',
    legendPosition: 'left',
    style: {
        animationDuration: 0,
        maxValue: 100,
        minValue: -100
    }
})

sio.on('connection', function (socket) {
    socket.on('acc', function (data) {
        var values = JSON.parse(data);
        var updateData = {stream: [
            {label:"", data: [Math.round(values.x),Math.round(values.y),Math.round(values.z)]}
        ]};
        acc.update('stream', updateData);
    })
    socket.on('gyro', function (data) {
        var values = JSON.parse(data);
        var updateData = {stream: [
            {label:"", data: [Math.round(values.x),Math.round(values.y),Math.round(values.z)]}
        ]};
        gyro.update('stream', updateData);
    })
})































