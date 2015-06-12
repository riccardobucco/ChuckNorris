var http = require('http');
var express = require('express');
var norris = require('./main');

var app = express();
var server = http.createServer(app);
var nor = norris(server, '/endpoint', app);

var socketio = require('socket.io');
var sio = socketio(server);

server.listen(process.env.PORT || 9000);



var acc = nor.createChart('linechart', 'acc');
var gyro = nor.createChart('linechart', 'gyro');

var page = nor.createPage('sensor').add(acc).add(gyro);

app.use(nor.getMiddleware());


acc.setData({
    labels: ["0"],
    datasets: [
        {name: 'x', values: [0], color:"#ff0000"},
        {name: 'y', values: [0], color:"#00ff00"},
        {name: 'z', values: [0], color:"#0000ff"}
    ]
})
acc.setSettings({
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