/*
 * Name: TUExternalAPIController.js
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

var assert = require("assert");
var ExternalAPIController = require('../../main/ExternalAPIManager/ExternalAPIController.js');

describe('ExternalAPIController',function(){
	describe('ExternalAPIController(model: NorrisImpl, server: http, endpoint: String)',function(){
		it('should properly construct an ExternalAPIController object',function(){
			model = {
				randomKey1: 'randomValue1'
			};
			server = {
				randomKey2: 'randomValue2'
			};
			endpoint = 'randomString';

			var extAPIContr = new ExternalAPIController(model, server, endpoint);

			assert.deepEqual(model, extAPIContr.model);
			assert.deepEqual(server, extAPIContr.server);
			assert.deepEqual(endpoint, extAPIContr.endpoint);
		});
	});
	describe('performLogin(cookies: express::cookie, username: String, password: String): boolean',function(){
		it('should start a new session for the user',function(){
			var model = {
				settings: {
					cookies: {randomKey: 'randomValue'},
					username: 'randomUser',
					password: 'randomPassword'
				}
			};
			model.getSettings = function() {return this.settings;};
			model.settings.login = function(cookies, username, password) {return (this.username==username)&&(this.password==password);}
			var extAPIContr = new ExternalAPIController(model, {}, '');
			assert.equal(true, extAPIContr.performLogin({randomKey: 'randomValue'},'randomUser','randomPassword'));
		});
	});
	describe('performLogout(cookies: express::cookie): boolean',function(){
		it('should stop the session for the user',function(){
			var model = {
				settings: {
					cookies: {randomKey: 'randomValue'},
					username: 'randomUser',
					password: 'randomPassword'
				}
			};
			model.getSettings = function() {return this.settings;};
			model.settings.logout = function(cookies) {return true;};
			var extAPIContr = new ExternalAPIController(model, {}, '');
			assert.equal(true, extAPIContr.performLogout({randomKey: 'randomValue'}));
		});
	});
	describe('isLogged(cookies: express::cookies): boolean',function(){
		it('should verify if a user is authenticated',function(){
			var model = {
				settings: {
					cookies: {randomKey: 'randomValue'},
					username: 'randomUser',
					password: 'randomPassword'
				}
			};
			model.getSettings = function() {return this.settings;};
			model.settings.isLogged = function(cookies) {return true;};
			var extAPIContr = new ExternalAPIController(model, {}, '');
			assert.equal(true, extAPIContr.isLogged({randomKey: 'randomValue'}));
		});
	});
	describe('getServer: http',function(){
		it('should get the server',function(){
			var extAPIContr = new ExternalAPIController({}, {randomKey: 'randomValue'}, '');
			assert.deepEqual(extAPIContr.server,extAPIContr.getServer());
		});
	});
	describe('getEndpoint: String',function(){
		it('should get the endpoint',function(){
			var extAPIContr = new ExternalAPIController({}, {}, 'randomString');
			assert.deepEqual(extAPIContr.endpoint,extAPIContr.getEndpoint());
		});
	});
});