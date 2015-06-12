var http = require('http');
var express = require('express');
var norris = require('./main');

var app = express();
var server = http.createServer(app);
var nor = norris(server, '/', app);

server.listen(process.env.PORT || 9000);

var bc = nor.createChart('barchart', 'bc');
var lc = nor.createChart('linechart', 'lc');
var mc = nor.createChart('mapchart', 'mc');
var t = nor.createChart('table', 't');

var BC = nor.createChart('barchart', 'BC');
var LC = nor.createChart('linechart', 'LC');
var MC = nor.createChart('mapchart', 'MC');
var T = nor.createChart('table', 'T');


var page = nor.createPage('page');
page.setSettings({maxChartsRow: 4})
page.add(bc).add(lc).add(mc).add(t);
page.add(BC).add(LC).add(MC).add(T);

app.use('/', nor.getMiddleware());

nor.setSettings({
    login: function (cookies, username, password) {
        if(username === 'Kaizen' && password === 'Team') {
            cookies.setCookie('ssid', 'true');
            console.log(username)
            console.log(password)
            return true;
        } else {
            return false;
        }
    },
    isLogged: function (cookies) {
        if(cookies.getCookies.ssid && cookies.getCookies.ssid === 'true')
            return true;
        else
            return false;
    },
    logout: function (cookies) {
        cookies.clearCookie('ssid');
        return true;
    }
});

bc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
bc.setSettings({title:'Titolo', style: {barArea: '80%', showGrid: true, maxValue: 10, minValue: 0}})
setInterval(barchart, 2000);

lc.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
lc.setSettings({title:'Titolo',xLabel: 'xLabel', yLabel: 'yLabel', legendPosition: 'top', style: {showGrid: true, maxValue: 10, minValue: 0}})
setInterval(linechart, 2000);

mc.setData({ datasets: [
    {name: 'pippo', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:0, y:1}, {x:0, y:2}, {x:0, y:3}, {x:0, y:4}]},
    {name: 'pluto', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:1, y:0}, {x:2, y:0}, {x:3, y:0}, {x:4, y:0}]}
]});
mc.setSettings({allowFilter: true});
setInterval(mapchart, 2000);

t.setData({
    headers: ['pippo','pluto','paperino'],
    datasets: [
        { row: [
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo'}, {color: '#ffffff', background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar'}, 
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz'}
        ]},
        { row: [
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo'}, {color: '#ffffff', background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar'}, 
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz'}
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
























BC.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
BC.setSettings({title:'Titolo', style: {barArea: '80%', showGrid: true, maxValue: 10, minValue: 0}})
setInterval(BARCHART, 2000);

LC.setData({
    labels: ['1','2','3','4','5'],
    datasets: [
        {name: 'pippo', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]},
        {name: 'pluto', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,0,4,5]},
        {name: 'paperino', color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [1,2,3,4,5]}
    ]
});
LC.setSettings({title:'Titolo',xLabel: 'xLabel', yLabel: 'yLabel', legendPosition: 'top', style: {showGrid: true, maxValue: 10, minValue: 0}})
setInterval(LINECHART, 2000);

MC.setData({ datasets: [
    {name: 'pippo', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:0, y:1}, {x:0, y:2}, {x:0, y:3}, {x:0, y:4}]},
    {name: 'pluto', color : "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), values: [{x:1, y:0}, {x:2, y:0}, {x:3, y:0}, {x:4, y:0}]}
]});
MC.setSettings({allowFilter: true});
setInterval(MAPCHART, 2000);

T.setData({
    headers: ['pippo','pluto','paperino'],
    datasets: [
        { row: [
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo'}, {color: '#ffffff', background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar'}, 
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz'}
        ]},
        { row: [
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo'}, {color: '#ffffff', background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar'}, 
            {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz'}
        ]}
    ]
});
setInterval(TABLE, 2000);



function BARCHART() {
    var update = {inplace : 
        [{
            position: {
                x: Math.floor(Math.random() * 3),
                y: Math.floor(Math.random() * 5)
            },
            data: Math.floor(Math.random() * 10)
        }]
    };
    BC.update('inplace', update);
};

var iLC = 0;
function LINECHART() {
    if(Math.random() > 0.5) {
        var update = {inplace: [{
            position: {
                x: Math.floor(Math.random() * 3),
                y: Math.floor(Math.random() * 5)
            },
            data: Math.floor(Math.random() * 10)
        }]};
        LC.update('inplace', update);
    } else {
        var update = {stream: [{
            label: 'foo' + iLC++,
            data: [
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10),
                Math.floor(Math.random() * 10)
            ]
        }]};
        LC.update('stream', update);
    }
};

function MAPCHART() {
    if(Math.random() > 0.5) {
        var update = {
            inplace: [],
            delete: [/*{series:0, index:Math.floor(Math.random()*4)}*/],
            stream: [
                {series: 0, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}},
                {series: 1, data: {x: Math.floor(Math.random() * 180) - 90, y: Math.floor(Math.random() * 90) - 45}}
            ]
        };
        MC.update('movie', update);
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
        MC.update('inplace', update);
    }
};

var iT = 0;
function TABLE() {
    if(Math.random() > 0.5) {
        var update = {stream: [
            { row: [
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'foo' + iT++}, 
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'bar' + iT++}, 
                {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value: 'baz' + iT++}
            ]}
        ]};
        T.update('stream', update);
    } else {
        var update = { inplace: [
            { position: {x:0, y:0}, data: {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value:'1'} },
            { position: {x:0, y:1}, data: {color: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), background: "#"+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9)+""+Math.floor(Math.random()*9), value:'1'} }
        ] };
        T.update('inplace', update);
    }
};



