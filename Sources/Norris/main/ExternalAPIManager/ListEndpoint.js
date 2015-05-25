/*
 * Name: {ListEndpoint.js}
 * Module: {ExternalAPIManager}
 * Location: {Norris/Main/ExternalAPIManager}
 * Date: {2015-05-24}
 * Version: {v0.01}
 *
 * History:
 *
 * ================================================================================
 * Version  Date        Author              Changes
 * ================================================================================
 * 0.01     2015-05-24  Chiara Bigarella    {creation}
 * ================================================================================
 */

var ExternalAPIController = require('./ExternalAPIController.js');
var ExternalAPIConstructor = require('./ExternalAPIConstructor.js');

var express = require('express');

/**
 * Creates a ListEndpoint.
 * @param {ExternalAPIController} controller
 * @returns {ListEndpoint}
 * @constructor
 */
function ListEndpoint(controller) {
    if (!(this instanceof ListEndpoint)) return new ListEndpoint(controller);
    if (controller instanceof ExternalAPIController) {
        this.controller=controller;
        this.app=express();
    }else {
        this.controller=null;
        this.app=null;
        console.log("ERROR: an ExternalAPIController is required.")
    }
}

/**
 *
 * @param req
 * @param res
 */
ListEndpoint.prototype.handleRequest = function(req, res) {};


/* ListEndpointFactory ------------------------------------------------------- */

/**
 * Creates a new ListEndpointFactory.
 * @constructor
 */
function ListEndpointFactory() {
    if(!(this instanceof ListEndpointFactory)) {
        return new ListEndpointFactory();
    }
}

ListEndpointFactory.prototype.instance=new ListEndpointFactory(); // static

/**
 * Gets the ListEndpointFactory's instance.
 * @returns {ListEndpointFactory} the factory's instance.
 */
ListEndpointFactory.getInstance = function() { // static
    return ListEndpointFactory.prototype.instance;
};

/**
 * Creates a new ListEndpoint.
 * @param {ExternalAPIController} controller - ;
 * @returns {ListEndpoint} - the created endpoint.
 */
ListEndpointFactory.prototype.createEndpoint = function (controller) {
    return new ListEndpoint (controller);
};

// Dependency injection:
ExternalAPIConstructor.registerEndpoint(ListEndpointFactory.getInstance());