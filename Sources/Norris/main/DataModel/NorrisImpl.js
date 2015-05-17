/*
 * Name: {NorrisImpl.js}
 * Module: {}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-05-04}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.1 2015-05-04 Chiara Bigarella {creation}
 * ================================================================================
 */
var ChartImpl = require('./ChartImpl.js');
var PageImpl = require('./PageImpl.js');

module.exports = NorrisImpl;

var defaults = {
    login : '',
    logout: '',
    isLoged: function() {return true;}
};

function NorrisImpl () {
    if (!(this instanceof NorrisImpl)) return new NorrisImpl();
    this.settings = {};
    this.charts = {};
    this.pages = {};
    this.setSettings(defaults);
}

NorrisImpl.prototype.setSettings = function(settings) {
    if(typeof settings == 'object') {
        for(var key in settings) {
            if(settings.hasOwnProperty(key)) {
                this.settings[key] = settings[key];
            }
        }
    }
};

NorrisImpl.prototype.getSettings = function() {
    return this.settings;
};

NorrisImpl.prototype.createChart = function(chartType, chartId) {
    // controllo che chartType sia in ChartImpl.factories
    // controllo che l'id sia univoco
    var chart = ChartImpl.createChart(chartType, chartId);
    this.charts[chartId]=chart;
    console.log(JSON.stringify(this.charts)); // TOGLIERE
    return chart;
};

NorrisImpl.prototype.getChart = function(chartId) {
   return this.charts[chartId];
};

NorrisImpl.prototype.getCharts = function() {
    return this.charts;
};

NorrisImpl.prototype.createPage = function(pageId) {
    // controllo che l'id sia univoco
    var page=new PageImpl(pageId);
    this.pages[pageId]=page;
    console.log(JSON.stringify(this.pages)); // TOGLIERE
    return page;
};

NorrisImpl.prototype.getPage = function(pageId){
    return this.pages[pageId];
};

NorrisImpl.prototype.getPages = function(){
    return this.pages;
};
