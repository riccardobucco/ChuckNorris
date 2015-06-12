/*
 * Name: TUPageBridge.js
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
 * v0.01 2015-05-25 Bucco Riccardo Creation
 * ================================================================================
 */
var NorrisImpl = require('../../main/DataModel/NorrisImpl.js');
var PageImpl = require('../../main/DataModel/NorrisPage/PageImpl.js');
var NorrisBridge = require('../../main/InternalAPIManager/NorrisBridge.js');
var ChartBridge = require('../../main/InternalAPIManager/ChartBridge.js');
var assert = require("assert");

describe('NorrisBridge', function(){

	describe('createPage(pageId: String): void',function(){
		it('should create a page with the indicated id',function(){
		  	var page = {'page':{'charts': [],'settings': {'maxChartsCol': 3,'maxChartsRow': 2,'title': "Norris's page"},'uid': '00'}};
;
			
			var norrisImpl = new NorrisImpl();
			var norrisBridge = new NorrisBridge(norrisImpl);
			
			assert.deepEqual(page,norrisBridge.createPage('00'));
		});
	});
	
	describe('setSettings(settings NorrisBridgeSettings): void',function(){
		it('should set the charts of the page',function(){
			var settings = {
			  'isLogged': function(){ console.log('isLogged function'); },
			  'keepAlive': function(){ console.log('keepAlive function'); },
			  'login': function(){ console.log('login function');},
			  'logout': function(){ console.log('logout function');}
			};
			
			var norris = new NorrisImpl();
			var norrisBridge = new NorrisBridge(norris);
			norrisBridge.setSettings(settings);
			
			assert.deepEqual(settings,norrisBridge.model.settings);
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
			
			var norris = new NorrisImpl();
			var norrisBridge = new NorrisBridge(norris);
			norrisBridge.setSettings(settings);
			
			assert.deepEqual(settings,norrisBridge.getSettings());
		});
	});

	
	describe('getChart(Id: String): ChartBridge',function(){
		it('should return a chart in the instance', function(){
		    var norris = new NorrisImpl();
			var norrisBridge = new NorrisBridge(norris);
			norrisBridge.createChart('mapchart','01');
			
			var chart = {chart: {
				_events: {},
				_maxListeners: 10,
				data: {},
				domain: null,
				settings: {
					zoomPosition: 'topleft',
                    legendPosition: 'topright',
                    scalePosition: 'bottomleft',
                    allowFilter: false,
                    maxItems : 5,
                    area: {
                        x: 0,
                        y: 0,
                        zoom: 1
                    },
					description: 'This is a map chart',
              	    title: ''
				  },
				type: 'mapchart',
				uid: '01',
			}};
			
		  	assert.deepEqual(chart,norrisBridge.getChart('01'));
		});
	});
	
});
