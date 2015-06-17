var http = require('http');
var express = require('express');
var norris = require('./main');

var socketio = require('socket.io');
var sio = socketio(server);


var app = express();
var server = http.createServer(app);

var nor = norris(server, app);

server.listen(9000);

process.on('uncaughtException', function (e) {
    console.error(e);
});
app.use('/', nor.getMiddleware());

// ------------- GRAFICI SINGOLI -------------
var bc = nor.createChart('barchart', 'bc');
var lc = nor.createChart('linechart', 'lc');
var mc = nor.createChart('mapchart', 'mc');
var t = nor.createChart('table', 't');


bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', values: [1,2,3,4,5]},
        {name: 'pluto', values: [1,2,0,4,5]},
        {name: 'paperino', values: [1,2,3,4,5]}
    ]
});
bc.setSettings({title:'My Barchart',description: 'Esempio di bar chart orizzontale', orientation : 'horizontal', style: {barArea: '80%', showGrid: true, maxValue: 10, minValue: 0}})
setInterval(barchart, 2000);

lc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', values: [1,2,3,4,5]},
        {name: 'pluto', values: [1,2,0,4,5]},
        {name: 'paperino', values: [1,2,3,4,5]}
    ]
});
lc.setSettings({title:'My Linechart',xLabel: 'xLabel', yLabel: 'yLabel', legendPosition: 'top', style: {showGrid: true, maxValue: 10, minValue: 0}})
setInterval(linechart, 2000);

mc.setData({ datasets: [
    {name: 'pippo', marker: 'standard', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:0, y:1}, {x:0, y:2}, {x:0, y:3}, {x:0, y:4}]},
    {name: 'pluto', marker: 'custom', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:1, y:0}, {x:2, y:0}, {x:3, y:0}, {x:4, y:0}]}
]});
mc.setSettings({allowFilter: true});
setInterval(mapchart, 2000);

t.setData({
    headers: ['pippo','pluto','paperino'],
    datasets: [
        { row: [
            {color: "#ffffff", background: "#000000", value: 'foo'}, {color: '#ffffff', background: "#000000", value: 'bar'}, 
            {color: "#ffffff", background: "#000000", value: 'baz'}
        ]},
        { row: [
             {color: "#eeeeee", background: "#000000", value: 'foo'}, {color: '#ffffff', background: "#000000", value: 'bar'}, 
            {color: "#eeeeee", background: "#000000", value: 'baz'}
        ]}
    ]
});
setInterval(table, 2000);



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
    if(Math.random() > 0.5) {
        var update = {
            inplace: [],
            delete: [/*{series:0, index:Math.floor(Math.random()*4)}*/],
            stream: [
                {series: 0, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}},
                {series: 1, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}}
            ]
        };
        mc.update('movie', update);
    }
    else{
        var update = {
            inplace: [{
                position:{
                    series:0,
                    index: Math.floor(Math.random()*4)
                },
                data: {
                    x: Math.floor(Math.random() * 180) - 90, 
                    y: Math.floor(Math.random() * 90) - 45
                }
            }]
        };
        mc.update('inplace', update);
    }
};

var it = 0;
function table() {
    if(Math.random() > 0.5) {
        var update = {stream: [
            { row: [
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo' + it++}, 
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar' + it++}, 
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz' + it++}
            ]}
        ]};
        t.update('stream', update);
    } else {
        var update = { inplace: [
            { position: {x:0, y:0}, data: {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value:'1'} },
            { position: {x:0, y:1}, data: {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value:'1'} }
        ] };
        t.update('inplace', update);
    }
};

