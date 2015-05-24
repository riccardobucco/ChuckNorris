/*
 * Name: {ChartEndpointFactory.js}
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
var socketio = require('socket.io');

/**
 * Creates a ChartEndpoint.
 * @param {ExternalAPIController} controller
 * @returns {ChartEndpoint}
 * @constructor
 */
function ChartEndpoint(controller) {
    if (!(this instanceof ChartEndpoint)) return new ChartEndpoint(controller);
    if (controller instanceof ExternalAPIController) {
        this.controller=controller;
        this.socketio=soketio(controller.getServer());
    }else {
        this.controller=null;
        this.socketio=null;
        console.log("ERROR: an ExternalAPIController is required.")
    }
}

/**
 *
 * @param socket
 */
ChartEndpoint.prototype.handleConnection = function(socket) {};


/* ChartEndpointFactory ------------------------------------------------------- */

/**
 * Creates a new ChartEndpointFactory.
 * @constructor
 */
function ChartEndpointFactory() {
    if(!(this instanceof ChartEndpointFactory)) {
        return new ChartEndpointFactory();
    }
}

ChartEndpointFactory.prototype.instance=new ChartEndpointFactory(); // static

/**
 * Gets the ChartEndpointFactory's instance.
 * @returns {ChartEndpointFactory} the factory's instance.
 */
ChartEndpointFactory.getInstance = function() { // static
    return ChartEndpointFactory.prototype.instance;
};

/**
 * Creates a new ChartEndpoint.
 * @param {ExternalAPIController} controller - ;
 * @returns {ChartEndpoint} - the created endpoint.
 */
ChartEndpointFactory.prototype.createEndpoint = function (controller) {
    return new ChartEndpoint (controller);
};