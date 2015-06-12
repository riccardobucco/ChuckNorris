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


var assert = require("assert");

describe('AuthenticationEndpoint', function(){
	describe('AuthenticationEndpoint(controller: ExternalAPIController)', function(){
		it('should create a new AuthenticationEndpoint object',function(){
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
			
			var controller = new ExternalAPIController(model, server, endpoint);
						
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

			var authEnd = authEndFac.createEndpoint(controller);
			assert.deepEqual(controller, authEnd.controller);
		});
		
	})
});
