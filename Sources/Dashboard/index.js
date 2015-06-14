var q = require('q');
var http = require('http');
var express = require('express');
var norris = require('norris-rtc');

var app = express();
var server = http.createServer(app);
var rtc = norris(server, app);

server.listen(9000);

var lines = ['01','03','05','06','07','09','10','11','12','13','15','16','18','22','24','41','42','43','CC','DC','SIR1'];
//var lines = ['22'];


// norris init
var map = rtc.createChart('mapchart', 'map');
var table = rtc.createChart('table', 'table');
var dashboard = rtc.createPage('dashboard').add(map).add(table);
dashboard.setSettings({title: 'Dashboard APS'});

app.use(rtc.getMiddleware());

// settings
map.setSettings({
    title: 'Mappa autobus',
    legendPosition: 'none',
    maxItems: 40,
    area: {
        y: 45.4043344,
        x: 11.8830057,
        zoom: 12
    }
});

table.setSettings({
    title: 'Autobus attivi',
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

































