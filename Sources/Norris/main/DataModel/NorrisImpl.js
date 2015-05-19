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
var events=require('events');
var NorrisChart = require('./NorrisChart');
var NorrisPage = require('./NorrisPage');

module.exports = NorrisImpl;

var defaults = {
    login : '',
    logout: '',
    isLoged: function() {return true;}
};

/**
 * NorrisImpl's constructor.
 */
function NorrisImpl () {
    if (!(this instanceof NorrisImpl)) return new NorrisImpl();
    events.EventEmitter.call(this); //NorrisImpl inherits from events.EventEmitter
    this.settings = {};
    this.charts = {};
    this.pages = {};
    this.setSettings(defaults);
}

NorrisImpl.prototype.__proto__=events.EventEmitter.prototype;

/**
 * NorrisImpl.prototype.setSettings allows you to set the Norris' settings. You're allowed to change value to
 * the default properties, but you cannot add new properties to Norris' settings.
 *
 * @param settings is a JSON object containing the Norris' settings you wish to add.
 */
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

/**
 * NorrisImpl.createChart allows you to create a new chart and adds it to the Norris instance's list of charts.
 * If the creation of a new chart ends successfully, this method emits the 'create' signal.
 *
 * @param chartType represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 * @param chartId the chart's ID;
 * @return 	a specific chart object.
 */
NorrisImpl.prototype.createChart = function(chartType, chartId) {
    // controllo che chartType sia in NorrisChart.factories -> lo fa già ChartImpl.createChart

    if (!this.charts.hasOwnProperty(chartId)) {     //the chart's ID should be unique
        var chart = NorrisChart.createChart(chartType, chartId);
        if (chart != null) {
            this.charts[chartId] = chart;
            this.emit('create', chart); // emits a 'creat' signal
            console.log("New chart added: "+chartId); // TOGLIERE
        }
        return chart;
    }
};

NorrisImpl.prototype.getChart = function(chartId) {
   return this.charts[chartId];
};

NorrisImpl.prototype.getCharts = function() {
    return this.charts;
};

NorrisImpl.prototype.createPage = function(pageId) {
    if (!this.pages.hasOwnProperty(pageId)) {     //the page's ID should be unique
        var page = new NorrisPage(pageId);
        this.pages[pageId] = page;
        console.log("New page added: "+pageId); // TOGLIERE
        return page;
    }
};

NorrisImpl.prototype.getPage = function(pageId){
    return this.pages[pageId];
};

NorrisImpl.prototype.getPages = function(){
    return this.pages;
};
