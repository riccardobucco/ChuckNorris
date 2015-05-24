/**
 * An handle to manage a Norris model
 * @module {ExternalAPIConstructor} ExternalAPIManager/ExternalAPIConstructor
 * @author Davide Dal Bianco
 * @version 0.01
 */

/*
 * Changelog:
 *
 * =============================================================================================
 * Version   Date         Author               Description
 * =============================================================================================
 * 0.01      2015-05-17   Davide Dal Bianco    Creation
 * =============================================================================================
 */

var ExternalAPIController = require('./ExternalAPIController.js');
module.exports = ExternalAPIConstructor;


function ExternalAPIConstructor() {
    if(!(this instanceof ExternalAPIConstructor)) return new ExternalAPIConstructor();
};

ExternalAPIConstructor.prototype.instance=new ExternalAPIConstructor(); // static

ExternalAPIConstructor.prototype.endpoints = []; // endpoits is a static variable

/**
 * Gets the ExternalAPIConstructor's instance.
 * @returns {ExternalAPIConstructor} the factory's instance.
 */
ExternalAPIConstructor.getInstance = function() { // static
    return ExternalAPIConstructor.prototype.instance;
};

/**
 * A static method which registers the endpoints' factories.
 *
 * @param {EndpointFactory} endpoint - the endponint's factory instance.
 */
ExternalAPIConstructor.registerEndpoint = function(endpoint) {
    ExternalAPIConstructor.prototype.endpoints.push(endpoint) /* EXPLICITLY assign to prototype property,
     otherwise it won't act as a static variable */
};

/**
 *
 *
 * @param {NorrisImpl} model -
 * @param {http} server -
 * @param {String} endpoint -
 */
ExternalAPIConstructor.prototype.construct = function (model, server, endpoint) {
    var controller = new ExternalAPIController();
    for (var i=0; i<ExternalAPIConstructor.prototype.endpoints.length; i++) {
        ExternalAPIConstructor.prototype.endpoints[i].createEndpoint(controller);
    }

};