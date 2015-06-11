var q = require('q');
var http = require('http');
var express = require('express');
var norris = require('norris-rtc');

var app = express();
var server = http.createServer(app);
var rtc = norris(server, '/', app);

server.listen(9000);


// norris init
var map = rtc.createChart('mapchart', 'map');
var dashboard = rtc.createPage('dashboard').add(map);

app.use(rtc.getMiddleware());


var lines = ['01','03','05','06','07','09','10','11','12','13','15','16','18','22','24','41','42','43','CC','DC','SIR1'];

/*lines.forEach(function (line) {
    setTimeout(function () {updateLine(line)});
});*/

map.setData({
    datasets: [
        {name: 'pippo', values: []}
    ]
})
updateLine('22');


function updateLine(line) {
    getLineFromAPS(line)
        .then(function (result) {
            console.log('do something')
        }, function () {
            console.log('error')
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

































