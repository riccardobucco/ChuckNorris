/*
 * Name: TUAuthenticationEndpoint.js
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

var AuthenticationEndpoint = require('../../main/ExternalAPIManager/AuthenticationEndpoint.js');
var ExternalAPIController = require('../../main/ExternalAPIManager/ExternalAPIController.js');
var ExternalAPIConstructor = require('../../main/ExternalAPIManager/ExternalAPIConstructor.js');
var express=require('express');
var http = require('http');


var assert = require("assert");

describe('AuthenticationEndpoint', function(){
	
	describe('AuthenticationEndpoint(controller: ExternalAPIController)', function(){
		it('should create a new AuthenticationEndpoint object',function(){
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
			
			var controller = new ExternalAPIController(model, server, app);
			
						
			function AuthenticationEndpointFactory() {
                if(!(this instanceof AuthenticationEndpointFactory)) {
                return new AuthenticationEndpointFactory();
                }
            }
            AuthenticationEndpointFactory.prototype.instance=new AuthenticationEndpointFactory(); // static
            AuthenticationEndpointFactory.getInstance = function() { // static
                return AuthenticationEndpointFactory.prototype.instance;
            };
            AuthenticationEndpointFactory.prototype.createEndpoint = function (controller) {
                return new AuthenticationEndpoint (controller);
            };
			ExternalAPIConstructor.registerEndpoint(AuthenticationEndpointFactory.getInstance());

			var authEndFac = new AuthenticationEndpointFactory();

			var authEnd = AuthenticationEndpointFactory.getInstance().createEndpoint(controller);
			assert.deepEqual(controller, authEnd.controller);
		});
		
	});
	
	describe('handleLogin(req: express, res: express)', function(){
		it('should manage an authentication request',function(){
			var app = express();
			var endpoint = 'randomString';
			var model = { 
				randomKey1: 'randomValue1', 
				settings: {
					login: function(cookies, username, password){
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
						
			var server = {	randomKey2: 'randomValue2' };
			
			var controller = new ExternalAPIController(model, server, app);
			
						
			function AuthenticationEndpointFactory() {
                if(!(this instanceof AuthenticationEndpointFactory)) {
                return new AuthenticationEndpointFactory();
                }
            }
            AuthenticationEndpointFactory.prototype.instance=new AuthenticationEndpointFactory(); // static
            AuthenticationEndpointFactory.getInstance = function() { // static
                return AuthenticationEndpointFactory.prototype.instance;
            };
            AuthenticationEndpointFactory.prototype.createEndpoint = function (controller) {
                return new AuthenticationEndpoint (controller);
            };
			ExternalAPIConstructor.registerEndpoint(AuthenticationEndpointFactory.getInstance());
			var authEndFac = new AuthenticationEndpointFactory();

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
				cookie: {
					apply: function(res, argumentss){}
				},
				clearCookie: {
					apply: function(res, arguments){}
				},
				sendStatus: function(statusNumber){ 
					this.statusNumber = statusNumber;
				}
			}
			
			var authEnd = AuthenticationEndpointFactory.getInstance().createEndpoint(controller);
			authEnd.handleLogin(req, res);
			assert.equal(200, res.statusNumber);
		});
		
	});
	
	describe('handleLogout(req: express, res: express)', function(){
		it('should manage an end-session request',function(){
			var app = express();
			var endpoint = 'randomString';
			var model = { 
				randomKey1: 'randomValue1', 
				settings: {
					logout: function(cookies, username, password){
						return false;
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
						
			var server = {	randomKey2: 'randomValue2' };
			
			var controller = new ExternalAPIController(model, server, app);
			
						
			function AuthenticationEndpointFactory() {
                if(!(this instanceof AuthenticationEndpointFactory)) {
                return new AuthenticationEndpointFactory();
                }
            }
            AuthenticationEndpointFactory.prototype.instance=new AuthenticationEndpointFactory(); // static
            AuthenticationEndpointFactory.getInstance = function() { // static
                return AuthenticationEndpointFactory.prototype.instance;
            };
            AuthenticationEndpointFactory.prototype.createEndpoint = function (controller) {
                return new AuthenticationEndpoint (controller);
            };
			ExternalAPIConstructor.registerEndpoint(AuthenticationEndpointFactory.getInstance());
			var authEndFac = new AuthenticationEndpointFactory();

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
				cookie: {
					apply: function(res, argumentss){}
				},
				clearCookie: {
					apply: function(res, arguments){}
				},
				sendStatus: function(statusNumber){ 
					this.statusNumber = statusNumber;
				}
			}
			
			var authEnd = AuthenticationEndpointFactory.getInstance().createEndpoint(controller);
			authEnd.handleLogout(req, res);
			assert.equal(401, res.statusNumber);
		});
		
		describe('handleKeepAlive(req: express, res: express)', function(){
		it('should manage an authentication request',function(){
			var app = express();
			var endpoint = 'randomString';
			var model = { 
				randomKey1: 'randomValue1', 
				settings: {
					keepAlive: function(cookies){
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
						
			var server = {	randomKey2: 'randomValue2' };
			
			var controller = new ExternalAPIController(model, server, app);
			
						
			function AuthenticationEndpointFactory() {
                if(!(this instanceof AuthenticationEndpointFactory)) {
                return new AuthenticationEndpointFactory();
                }
            }
            AuthenticationEndpointFactory.prototype.instance=new AuthenticationEndpointFactory(); // static
            AuthenticationEndpointFactory.getInstance = function() { // static
                return AuthenticationEndpointFactory.prototype.instance;
            };
            AuthenticationEndpointFactory.prototype.createEndpoint = function (controller) {
                return new AuthenticationEndpoint (controller);
            };
			ExternalAPIConstructor.registerEndpoint(AuthenticationEndpointFactory.getInstance());
			var authEndFac = new AuthenticationEndpointFactory();

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
				cookie: {
					apply: function(res, argumentss){}
				},
				clearCookie: {
					apply: function(res, arguments){}
				},
				sendStatus: function(statusNumber){ 
					this.statusNumber = statusNumber;
				}
			}
			
			var authEnd = AuthenticationEndpointFactory.getInstance().createEndpoint(controller);
			authEnd.handleKeepAlive(req, res);
			assert.equal(200, res.statusNumber);
		});
		
	})
		
	});
});
