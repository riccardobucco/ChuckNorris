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
    this.model=model;
    this.server=server;
    this.endpoint=endpoint;
};

/**
 *
 * @param {} cookies
 * @param {String} username
 * @param {String} password
 * @return {boolean}
 */
ExternalAPIController.prototype.performLogin= function(cookies , username, password) {};

/**
*
* @param {} cookies
* @return {boolean}
*/
ExternalAPIController.prototype.performLogout= function(cookies) {};

/**
 *
 * @param {} cookies
 * @return {boolean}
 */
ExternalAPIController.prototype.performKeepAlive= function(cookies) {};

/**
 *
 * @param {} cookies
 * @return {boolean}
 */
ExternalAPIController.prototype.isLogged= function(cookies) {};


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