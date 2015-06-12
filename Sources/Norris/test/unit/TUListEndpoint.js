/*
 * Name: TUListEndpoint.js
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
 * v0.01 2015-05-25 Pavanello Fabio Matteo Creation
 * ================================================================================
 */

var ListEndpoint = require('../../main/ExternalAPIManager/ListEndpoint.js');
var ExternalAPIController = require('../../main/ExternalAPIManager/ExternalAPIController.js');
var ExternalAPIConstructor = require('../../main/ExternalAPIManager/ExternalAPIConstructor.js');
var express=require('express');
var http = require('http');


var assert = require("assert");

describe('ListEndpoint', function(){
	
	describe('ListEndpoint(controller: ExternalAPIController)', function(){
		it('should create a new ListEndpoint object',function(){
			var app = express();
			var endpoint = 'randomString';
			var model = {
				randomKey1: 'randomValue1'
			};
			model.endpoint = endpoint;
			model.getEndpoint = function(){
			    return this.endpoint;
			};
						
			var server = {
				randomKey2: 'randomValue2'
			};
			
			
			function ListEndpointFactory() {
				if(!(this instanceof ListEndpointFactory)) {
					return new ListEndpointFactory();
				}
			}
			ListEndpointFactory.prototype.instance=new ListEndpointFactory(); // static
			ListEndpointFactory.getInstance = function() { // static
				return ListEndpointFactory.prototype.instance;
			};
			ListEndpointFactory.prototype.createEndpoint = function (controller) {
				return new ListEndpoint(controller);
			};
			ExternalAPIConstructor.registerEndpoint(ListEndpointFactory.getInstance());

			var listEndFac = new ListEndpointFactory();
			
			var controller = new ExternalAPIController(model, server, app);
			
			var listEnd = ListEndpointFactory.getInstance().createEndpoint(controller);
			assert.deepEqual(controller, listEnd.controller);
		});
		
	});
	
	describe('handleRequest(req: express, res: express)', function(){
		it('should manage a request to get a chart list',function(){
			var app = express();
			var endpoint = 'randomString';
			var model = { 
				randomKey1: 'randomValue1', 
				settings: {
					isLogged: function(cookies){
						return true;
					}
				}
			};
			model.endpoint = endpoint;
			model.getEndpoint = function(){
			    return this.endpoint;
			};
			model.getSettings = function(){
				return this.settings;
			}
			model.getCharts = function(){
				return null;
			}
						
			var server = {	randomKey2: 'randomValue2' };
			
			var controller = new ExternalAPIController(model, server, app);
			
			function ListEndpointFactory() {
				if(!(this instanceof ListEndpointFactory)) {
					return new ListEndpointFactory();
				}
			}
			ListEndpointFactory.prototype.instance=new ListEndpointFactory(); // static
			ListEndpointFactory.getInstance = function() { // static
				return ListEndpointFactory.prototype.instance;
			};
			ListEndpointFactory.prototype.createEndpoint = function (controller) {
				return new ListEndpoint(controller);
			};
			ExternalAPIConstructor.registerEndpoint(ListEndpointFactory.getInstance());
			
			var req = {
				cookies: 'cookiesValue',
	            signedCookies: 'signedCookiesValue',
				body: {
					 username: 'usr' ,
	                 password: 'pwd' 
				}
			};
			
			var res = {
				statusNumber: {},
				list: {},
				cookie: {
					apply: function(res, argumentss){}
				},
				clearCookie: {
					apply: function(res, arguments){}
				},
				sendStatus: function(statusNumber){ 
					this.statusNumber = statusNumber;
				},
				json: function(list){ this.list = list}
			}
			
			var listEnd = ListEndpointFactory.getInstance().createEndpoint(controller);
			listEnd.handleRequest(req, res);
			assert.deepEqual([], res.list);
		});
		
	});
});
