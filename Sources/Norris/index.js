// norris test file

var http = require('http');
var express = require('express');
var norris = require('./main');

var app = express();
var server = http.createServer(app);
var nor = norris(server, '/');

server.listen(process.env.PORT || 9000);

var bc = nor.createChart('barchart', 'bc');
var lc = nor.createChart('linechart', 'lc');
var mc = nor.createChart('mapchart', 'mc');
var t = nor.createChart('table', 't');


var page = nor.createPage('page');
page.add(bc).add(lc).add(mc).add(t);

app.use('/', nor.getMiddleware());

bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
setInterval(barchart, 4000);

lc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
lc.setSettings({xLabel: 'xLabel', yLabel: 'yLabel', legendPosition: 'top'})
setInterval(linechart, 4000);

mc.setData([
    {name: 'pippo', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:0, y:1}, {x:0, y:2}, {x:0, y:3}, {x:0, y:4}]},
    {name: 'pluto', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:1, y:0}, {x:2, y:0}, {x:3, y:0}, {x:4, y:0}]}
]);
setInterval(mapchart, 4000);

t.setData({
    headers: ['pippo','pluto','paperino'],
    datasets: [
        [{color: '#000000', background: '#ffffff', value: 'foo'}, {color: '#ffffff', background: '#000000', value: 'bar'}, 
        {color: '#000000', background: '#ffffff', value: 'baz'}],
        [{color: '#000000', background: '#ffffff', value: 'foo'}, {color: '#ffffff', background: '#000000', value: 'bar'}, 
        {color: '#000000', background: '#ffffff', value: 'baz'}]
    ]
});
setInterval(table, 4000);



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

var ilc = 0;
function linechart() {
    if(Math.random() > 0.5) {
        var update = {inplace: [{
            position: {
                x: Math.floor(Math.random() * 3),
                y: Math.floor(Math.random() * 5)
            },
            data: Math.floor(Math.random() * 10)
        }]};
        lc.update('inplace', update);
    } else {
        var update = {stream: [{
            label: 'foo' + ilc++,
            data: [
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10)
            ]
        }]};
        lc.update('stream', update);
    }
};

function mapchart() {
    var update = {
        inplace: [],
        delete: [],
        stream: [
            {series: 0, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}},
            {series: 1, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}}
        ]
    };
    mc.update('movie', update);
};

var it = 0;
function table() {
    if(Math.random() > 0.5) {
        var update = {stream: [
            [{color: '#000000', background: '#aaaaaa', value: 'foo' + it++}, 
            {color: '#000000', background: '#aaaaaa', value: 'bar' + it++}, 
            {color: '#000000', background: '#aaaaaa', value: 'baz' + it++}]
        ]};
        t.update('stream', update);
    } else {
        var update = { inplace: [
            { position: {x:0, y:0}, data: {color: '#000000', background: '#aaaaaa', value:'1'} },
            { position: {x:0, y:1}, data: {color: '#aaaaaa', background: '#000000', value:'1'} }
        ] };
        t.update('inplace', update);
    }
};
