/*
 * Name: {ChuckProviderEndpoint.js}
 * Module: {ExternalAPIManager}
 * Location: {Norris/Main/ExternalAPIManager}
 * Date: {2015-05-24}
 * Version: {v0.01}
 *
 * History:
 *
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */

var ExternalAPIController = require('./ExternalAPIController.js');
var ExternalAPIConstructor = require('./ExternalAPIConstructor.js');

var express = require('express');

/**
 * Creates a ChuckProviderEndpoint.
 * @param {ExternalAPIController} controller
 * @returns {ListEndpoint}
 * @constructor
 */
function ChuckProviderEndpoint(controller) {
    if (!(this instanceof ChuckProviderEndpoint)) return new ChuckProviderEndpoint(controller);
    if (controller instanceof ExternalAPIController) {
        this.controller=controller;
        var app = this.app = express();
        this.controller.getServer().on('request', app);
        this.app.get(this.controller.getEndpoint() + '/chuck', this.handleRequest);
    }else {
        this.controller=null;
        this.app=null;
        console.log("ERROR: an ExternalAPIController is required.")
    }
}

ChuckProviderEndpoint.prototype.handleRequest = function (req, res) {
    res.sendFile(__dirname + '../../resources/Chuck.min.js');
};



/* ChuckProviderEndpointFactory ------------------------------------------------------- */

/**
 * Creates a new ChuckProviderEndpointFactory.
 * @constructor
 */
function ChuckProviderEndpointFactory() {
    if(!(this instanceof ChuckProviderEndpointFactory)) {
        return new ChuckProviderEndpointFactory();
    }
}

ChuckProviderEndpointFactory.prototype.instance=new ChuckProviderEndpointFactory(); // static

/**
 * Gets the ChuckProviderEndpointFactory's instance.
 * @returns {ChuckProviderEndpointFactory} the factory's instance.
 */
ChuckProviderEndpointFactory.getInstance = function() { // static
    return ChuckProviderEndpointFactory.prototype.instance;
};

/**
 * Creates a new ChuckProviderEndpoint.
 * @param {ExternalAPIController} controller - ;
 * @returns {ChuckProviderEndpoint} - the created endpoint.
 */
ChuckProviderEndpointFactory.prototype.createEndpoint = function (controller) {
    return new ChuckProviderEndpoint (controller);
};

// Dependency injection:
ExternalAPIConstructor.registerEndpoint(ChuckProviderEndpointFactory.getInstance());