/*
 * Name: ListEndpoint.js
 * Module: ExternalAPIManager
 * Location: Norris/Main/ExternalAPIManager
 * Date: 2015-04-12
 * Version: v0.04
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.04 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * v0.03 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * v0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * v0.01 2015-04-12 Moretto Alessandro   Creation
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
        this.app=controller.getApp();
        this.handleRequest();
    } else {
        console.log("ERROR: an ExternalAPIController is required.");
        throw("ListEndpoint:requiredExternalAPIController");
    }
}

/**
 * Manages a request to get the chart list
 * @param req
 * @param res
 */
ListEndpoint.prototype.handleRequest = function() {
    var endpoint=this.controller.getEndpoint();
    if (endpoint=='/') {
        endpoint = endpoint + 'list';
    }
    else {
        endpoint = endpoint + '/list';
    }
    var charts = this.controller.getCharts();
    var list=[];
    var i=0;
    for (chart in charts) {
        var id=chart.getId();
        var type=chart.getType();
        var settings=chart.getSettings();
        var title=settings.title;
        var description= settings.description;
        var object={id : '', type : '', title: '', description: ''};
        object.id=id;
        object.type=type;
        object.title=title;
        object.description=description;
        list[i].push(object);
    }
    this.app.get(endpoint, function (req, res) {
        res.json(list);
    });
};


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
