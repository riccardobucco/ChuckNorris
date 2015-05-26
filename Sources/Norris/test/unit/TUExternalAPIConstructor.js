/*
 * Name: {TUExternalAPIConstructor.js}
 * Module: {}
 * Location: {Norris/test/unit}
 * Date: {2015-05-25}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-25 Riccardo Bucco {creation}
 * ================================================================================
 */

var assert = require("assert");
var ExternalAPIConstructor = require('../../main/ExternalAPIManager/ExternalAPIConstructor.js');

describe('ExternalAPIConstructor',function(){
	describe('registerEndpoint(endpoint: EndpointFactory): void',function(){
		it('should register endpoints factories',function(){
			endpointfactory = {
				randomKey: 'randomValue'
			}
			var extAPiConstr = new ExternalAPIConstructor();
			ExternalAPIConstructor.registerEndpoint(endpointfactory);
			assert.deepEqual(endpointfactory, extAPiConstr.endpoints[1]);
		});
	});
	describe('getInstance(): ExternalAPIConstructor',function(){
		it('should return the instance of the factory', function(){
			var extAPiConstr = new ExternalAPIConstructor();
			assert.deepEqual(extAPiConstr.instance, ExternalAPIConstructor.getInstance());
		});
	});
});