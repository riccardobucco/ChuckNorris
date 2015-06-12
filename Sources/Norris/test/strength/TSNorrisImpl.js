/*
 * Name: TSNorrisImpl.js
 * Module: 
 * Location: Norris/test/strength
 * Date: 2015-05-30
 * Version: v0.01
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.01 2015-05-30 Carlon Chiara Creation
 * ================================================================================
 */

var NorrisImpl = require('../../main/DataModel/NorrisImpl.js');
var assert = require("assert");

describe('NorrisImpl', function() {

    describe('NorrisImpl(endpoint)',function() {
        it('should throw an error if endpoint is not valid',function() {
        	var endpoint;

        	assert.throws(function () {(NorrisImpl(endpoint))});
        });
    });

    describe('createChart(chartType: String, chartId: String)', function() {
    	it('should throw an error if the chart has no id)', function() {
    		var endpoint = '';
    		var norrisImpl = new NorrisImpl(endpoint);

    		norrisImpl.createChart('mapchart', '01');

    		assert.throws(function () {(norrisImpl.createChart('mapchart', '01'))});

    	});
    });

    describe('createPage(pageId: String): PageImpl', function() {
    	it('should throw an error if the page has no id)', function() {
    		var endpoint = '';
    		var norrisImpl = new NorrisImpl(endpoint);

    		norrisImpl.createPage('01');

    		assert.throws(function () {(norrisImpl.createPage('01'))});
    	});
    });


});


