var q = require('q');
var http = require('http');
var express = require('express');
var norris = require('norris-rtc');

var app = express();
var server = http.createServer(app);
var rtc = norris(server, app);

server.listen(9000);


// norris init
var map = rtc.createChart('mapchart', 'map');
var dashboard = rtc.createPage('dashboard').add(map);
dashboard.setSettings({title: 'Dashboard APS'});

app.use(rtc.getMiddleware());

// settings
map.setSettings({
    legendPosition: 'none',
    area: {
        y: 45.4043344,
        x: 11.8830057,
        zoom: 13
    }
});


var lines = ['01','03','05','06','07','09','10','11','12','13','15','16','18','22','24','41','42','43','CC','DC','SIR1'];

var mapData = {
    datasets: []
}
lines.forEach(function (line) {
    mapData.datasets.push({
        name: line,
        color: '#ff0000',
        values: []
    });
});
map.setData(mapData);

lines.forEach(function (line) {
    setTimeout(function () {updateLine(line)});
});


function updateLine(line) {
    getLineFromAPS(line)
        .then(function (result) {
            if(result.length > 0) {
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
                        series: series,
                        index: i
                    })
                }

                // riaggiunge tutti i punti
                for(var i in result) {
                    updateData.stream.push({
                        series: series,
                        data: {
                            x: result[i].WGS84La,
                            y: result[i].WGS84Fi
                        }
                    })
                }

                map.update('movie',updateData);
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

































