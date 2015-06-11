/*
 * Name: TUNorrisBridge.js
 * Module: 
 * Location: Norris/test/unit
 * Date: 2015-05-25
 * Version: v0.01
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.01 2015-05-25 Fabio Matteo Pavanello Creation
 * ================================================================================
 */
var NorrisImpl = require('../../main/DataModel/NorrisImpl.js');
var PageImpl = require('../../main/DataModel/NorrisPage/PageImpl.js');
var NorrisBridge = require('../../main/InternalAPIManager/NorrisBridge.js');
var ChartBridge = require('../../main/InternalAPIManager/ChartBridge.js');
var assert = require("assert");

describe('NorrisImpl', function(){

    describe('createPage(pageId: String): void',function(){
        it('should create a page with the indicated id',function(){
            var page = {'charts': [],'settings': {'maxChartsCol': 3,'maxChartsRow': 2,'title': "Norris's page"},'uid': '00'};
            var norrisImpl = new NorrisImpl();
            assert.deepEqual(page,norrisImpl.createPage('00'));
        });
    });
    
    describe('setSettings(settings NorrisImplSettings): void',function(){
        it('should set the charts of the page',function(){
            var settings = {
              'isLogged': function(){ console.log('isLogged function'); },
              'keepAlive': function(){ console.log('keepAlive function'); },
              'login': function(){ console.log('login function');},
              'logout': function(){ console.log('logout function');}
            };
            
            var norrisImpl = new NorrisImpl();
            norrisImpl.setSettings(settings);
            
            assert.deepEqual(settings, norrisImpl.settings);
        });
    });

    
    describe('getSettings(): NorrisSettings',function(){
        it('should return the settings of a NorrisBridge object', function(){
            var settings = {
              'isLogged': function(){ console.log('isLogged function'); },
              'keepAlive': function(){ console.log('keepAlive function'); },
              'login': function(){ console.log('login function');},
              'logout': function(){ console.log('logout function');}
            };
            
            var norrisImpl = new NorrisImpl();
            norrisImpl.setSettings(settings);
            
            assert.deepEqual(settings,norrisImpl.getSettings());
        });
    });

    
    describe('getChart(Id: String): ChartImpl',function(){
        it('should return a chart in the page', function(){
            var norrisImpl = new NorrisImpl();
            norrisImpl.createChart('mapchart','01');
            var chart = {
            _events: {},
            _maxListeners: 10,
            data: {},
            domain: null,
            settings: {
            area : {
                x: 0,
                y:0,
                zoom : 0
            },
            description: 'This is a map chart',
            legendPosition: 'top-right',
            maxItems: 5,
            title: ''
            },
            type: 'mapchart',
            uid: '01'
            };
        
            assert.deepEqual(chart,norrisImpl.getChart('01'));
        });
    });
    
});
