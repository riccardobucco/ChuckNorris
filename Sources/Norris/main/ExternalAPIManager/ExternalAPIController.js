/*
 * Name: {ExternalAPIController.js}
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
var NorrisImpl=require('../DataModel/NorrisImpl.js');
var ChartRef=require('./ChartRef.js');
var http=require('http');
var events=require('events');


/**
 * Creates a new ExternalAPIController.
 * @constructor
 * @param {NorrisImpl} model -
 * @param {http} server -
 * @param {String} endpoint -
 */
function ExternalAPIController(model, server, endpoint) {
    if(!(this instanceof ExternalAPIController))
        return new ExternalAPIController(model, server, endpoint);
    events.EventEmitter.call(this); //ExternalAPIController inherits from events.EventEmitter
    this.model=model;
    this.server=server;
    this.endpoint=endpoint;
};

ExternalAPIController.prototype.__proto__=events.EventEmitter.prototype;


/**
 * Performs Norris' login.
 * @param {} cookies
 * @param {String} username
 * @param {String} password
 * @return {boolean}
 */
ExternalAPIController.prototype.performLogin= function(cookies , username, password) {
    var settings=this.model.getSettings();
    var login=settings.login(cookies, username, password);
    return login;
};

/**
* Performs Norris' logout.
* @param {} cookies
* @return {boolean}
*/
ExternalAPIController.prototype.performLogout= function(cookies) {
    var settings=this.model.getSettings();
    var logout=settings.logout(cookies);
    return logout;
};

/**
 * Performs Norris' keepAlive.
 * @param {} cookies
 * @return {boolean}
 */
ExternalAPIController.prototype.performKeepAlive= function(cookies) {
    var settings=this.model.getSettings();
    var keepAlive=settings.keepAlive(cookies);
    return keepAlive;
};

/**
 * Performs Norris' isLogged.
 * @param {} cookies
 * @return {boolean}
 */
ExternalAPIController.prototype.isLogged= function(cookies) {
    var settings=this.model.getSettings();
    var isLogged=settings.isLogged(cookies);
    return isLogged;
};


/**
 * @return {ChartRef[]}
 */
ExternalAPIController.prototype.getCharts= function() {
    var chartR=[];
    var charts=this.model.getCharts();
    for (var key in charts) {
        chartR.push(new ChartRef(charts[key]));
    }
    return chartR;
};

/**
 *
 * @param {String} chartId
 * @returns {ChartRef}
 */
ExternalAPIController.prototype.getChart = function(chartId) {
    var chart=this.model.getChart(chartId);
    var chartR=new ChartRef(chart);
    return chartR;
};

/**
 * Gets the server.
 * @returns {http}
 */
ExternalAPIController.prototype.getServer = function() {
    return this.server;
};

/**
 * Gets the endpoint.
 * @returns {String}
 */
ExternalAPIController.prototype.getEndpoint = function() {
    return this.endpoint;
};