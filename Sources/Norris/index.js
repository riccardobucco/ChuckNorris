// norris test file

var http = require('http');
var express = require('express');
var norris = require('./main');

var app = express();
var server = http.createServer(app);
var nor = norris(server, '/');

server.listen(9000);

var bc = nor.createChart('barchart', 'bc');
var lc = nor.createChart('linechart', 'lc');
var mc = nor.createChart('mapchart', 'mp');
var t = nor.createChart('table', 't');


var page = nor.createPage('page');
page.add(bc).add(lc).add(mc).add(t);


bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {color: {r: 255, g: 0, b: 0}, values: [1,2,3,4,5]},
        {color: {r: 0, g: 255, b: 0}, values: [1,2,0,4,5]},
        {color: {r: 0, g: 0, b: 255}, values: [1,2,3,4,5]}
    ]
});
setInterval(barchart, 4000);

lc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {color: {r: 255, g: 0, b: 0}, values: [1,2,3,4,5]},
        {color: {r: 0, g: 255, b: 0}, values: [1,2,3,4,5]},
        {color: {r: 0, g: 0, b: 255}, values: [1,2,3,4,5]}
    ]
});
setInterval(linechart, 4000);

mc.setData({});
//setInterval(mapchart, 4000);

t.setData({});
//setInterval(table, 4000);



function barchart() {
    var update = [{
        position: {
            x: Math.floor(Math.random() * 3),
            y: Math.floor(Math.random() * 5)
        },
        value: Math.floor(Math.random() * 10)
    }];
    bc.update('inplace', update);
};

function linechart() {
    var i = 0;
    if(Math.random() > 0.5) {
        var update = [{
            position: {
                x: Math.floor(Math.random() * 3),
                y: Math.floor(Math.random() * 5)
            },
            value: Math.floor(Math.random() * 10)
        }];
        lc.update('inplace', update);
    } else {
        var update = [{
            label: 'foo',
            data: [
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10)
            ]
        }];
        lc.update('stream', update);
    }
};

function mapchart() {};

function table() {};