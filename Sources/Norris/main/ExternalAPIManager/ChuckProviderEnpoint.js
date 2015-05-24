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
 * Version  Date        Author              Changes
 * ================================================================================
 * 0.01     2015-05-24  Chiara Bigarella    {creation}
 * ================================================================================
 */

var ExternalAPIController = require('./ExternalAPIController.js');

//- app : express

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
    }else {
        this.controller=null;
        console.log("ERROR: an ExternalAPIController is required.")
    }
}

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