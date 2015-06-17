var http = require('http');
var express = require('express');
var norris = require('./main');

var socketio = require('socket.io');
var sio = socketio(server);


var app = express();
var server = http.createServer(app);

var rtc = norris(server, app);

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

