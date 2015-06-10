var http = require('http');
var express = require('express');
var norris = require('./main');

var app = express();
var server = http.createServer(app);
var nor = norris(server, '/endpoint', app);

var socketio = require('socket.io');
var sio = socketio(server);

server.listen(process.env.PORT || 9000);



var acc = nor.createChart('barchart', 'acc');
var gyro = nor.createChart('barchart', 'gyro');

var page = nor.createPage('sensor').add(acc).add(gyro);

app.use(nor.getMiddleware());


acc.setData({
    labels: ['x','y','z'],
    datasets: [
        {name: 'accelerometer', values: [0,0,0]}
    ]
})
acc.setSettings({
    legendPosition: 'none',
    style: {
        animationDuration: 0
    }
})

gyro.setData({
    labels: ['x','y','z'],
    datasets: [
        {name: 'gyro', values: [0,0,0]}
    ]
})
acc.setSettings({
    legendPosition: 'none',
    style: {
        animationDuration: 0
    }
})

sio.on('connection', function (socket) {
	socket.on('acc', function (data) {
		var values = JSON.parse(data);
		var updateData = {inplace: [
			{position: {x: 0, y: 0}, data: Math.round(values.x)},
			{position: {x: 0, y: 1}, data: Math.round(values.y)},
			{position: {x: 0, y: 2}, data: Math.round(values.z)}
		]};
		acc.update('inplace', updateData);
	})
    socket.on('acc', function (data) {
        var values = JSON.parse(data);
        var updateData = {inplace: [
            {position: {x: 0, y: 0}, data: Math.round(values.x)},
            {position: {x: 0, y: 1}, data: Math.round(values.y)},
            {position: {x: 0, y: 2}, data: Math.round(values.z)}
        ]};
        gyro.update('inplace', updateData);
    })
})