/**
 * Name: {ExternalAPIConstructor.js}
 * Package: {ExternalAPIConstructor} 
 * Location{Norris/Main/ExternalAPIConstructor}
 * Date: {2015-04-12}
 * Version: {0.04}
 *
 *
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.04 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
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
    var controller = new ExternalAPIController(model, server, endpoint);
    for (var i=0; i<ExternalAPIConstructor.prototype.endpoints.length; i++) {
        ExternalAPIConstructor.prototype.endpoints[i].createEndpoint(controller);
    }

};

//Dependency injection:
var ChartEndpoint=require('./ChartEndpoint.js');
//var ChuckProviderEndpoint=require('./ChuckProviderEndpoint.js');