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
var mc = nor.createChart('mapchart', 'mc');
var t = nor.createChart('table', 't');


var page = nor.createPage('page');
page.add(bc).add(lc).add(mc).add(t);


bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: {r: 255, g: 0, b: 0}, values: [1,2,3,4,5]},
        {name: 'pluto', color: {r: 0, g: 255, b: 0}, values: [1,2,0,4,5]},
        {name: 'paperino', color: {r: 0, g: 0, b: 255}, values: [1,2,3,4,5]}
    ]
});
setInterval(barchart, 4000);

lc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: {r: 255, g: 0, b: 0}, values: [1,2,3,4,5]},
        {name: 'pluto', color: {r: 0, g: 255, b: 0}, values: [1,2,3,4,5]},
        {name: 'paperino', color: {r: 0, g: 0, b: 255}, values: [1,2,3,4,5]}
    ]
});
lc.setSettings({xLabel: 'xLabel', yLabel: 'yLabel'})
setInterval(linechart, 4000);

mc.setData([
    {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [{x:0, y:1}, {x:0, y:2}, {x:0, y:3}, {x:0, y:4}]},
    {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:0}, {x:2, y:0}, {x:3, y:0}, {x:4, y:0}]}
]);
setInterval(mapchart, 4000);

t.setData({
    headers: ['pippo','pluto','paperino'],
    datasets: [
        [{value: 'foo'}, {value: 'bar'}, {value: 'baz'}]
    ]
});
setInterval(table, 4000);



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

var ilc = 0;
function linechart() {
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
            label: 'foo' + ilc++,
            data: [
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10)
            ]
        }];
        lc.update('stream', update);
    }
};

function mapchart() {
    var update = {
        inplace: [],
        delete: [],
        stream: [
            {series: 0, data: {x: Math.floor(Math.random() * 360) - 180, y: Math.floor(Math.random() * 180) - 90} },
            {series: 1, data: {x: Math.floor(Math.random() * 360) - 180, y: Math.floor(Math.random() * 180) - 90} }
        ]
    };
    mc.update('movie', update);
};

var it = 0;
function table() {
    var update = [
        [{value: 'foo' + it++}, {value: 'bar' + it++}, {value: 'baz' + it++}]
    ];
    t.update('stream', update);
};