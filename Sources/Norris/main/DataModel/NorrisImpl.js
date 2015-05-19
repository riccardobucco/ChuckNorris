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
    login : function(){},
    logout: function(){},
    isLogged: function() {return true;}
};

/**
 * Creates a Norris instance.
 * @constructor
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
 * Sets the Norris' settings. You're allowed to change value to the default properties, but you cannot add
 * new properties to Norris' settings.
 *
 * @param settings - a JSON object containing the Norris' settings you wish to add.
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

/**
 * NorrisImpl.prototype.getSettings allows you to get the Norris' settings.
 *
 * @return the Norris' settings.
 */
NorrisImpl.prototype.getSettings = function() {
    return this.settings;
};

/**
 * Creates a new chart and adds it to the Norris instance's list of charts.
 * If the creation of a new chart ends successfully, this method emits the 'create' signal. Otherwise it shows
 * an error message and return null.
 *
 * @param {String} chartType - represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 * @param {String} chartId - the chart's ID;
 * @return {ChartImpl} the created chart.
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
    else {
        console.log("ERROR: this ID is already used.");
        return null;
    }
};

/**
 * Gets a Norris' chart.
 *
 * @param {String} chartId - the value of a chart's ID;
 * @return 	{ChartImpl} the Norris' chart with the ID==chartId.
 */
NorrisImpl.prototype.getChart = function(chartId) {
   return this.charts[chartId];
};

/**
 * Gets all Norris' charts.
 *
 * @return 	a list of the Norris' charts.
 */
NorrisImpl.prototype.getCharts = function() {
    return this.charts;
};

/**
 * Creates a new page and adds it to the Norris instance's list of pages.
 * If the creation of a new page ends successfully, this method return the created page. Otherwise it shows
 * an error message and return null.
 *
 * @param {String} pageId - the page's ID;
 * @return  {PageImpl} the created page.
 */
NorrisImpl.prototype.createPage = function(pageId) {
    if (!this.pages.hasOwnProperty(pageId)) {     //the page's ID should be unique
        var page = new NorrisPage(pageId);
        this.pages[pageId] = page;
        console.log("New page added: "+pageId); // TOGLIERE
        return page;
    }
    else {
        console.log("ERROR: this ID is already used.");
        return null;
    }
};

/**
 * Gets a Norris' page.
 *
 * @param {String} pageId - contains the value of a page's ID;
 * @return 	{PageImpl} the Norris' page with the ID==chartId.
 */
NorrisImpl.prototype.getPage = function(pageId){
    return this.pages[pageId];
};

/**
 *Gets all Norris' pages.
 *
 * @return 	a list of the Norris' pages.
 */
NorrisImpl.prototype.getPages = function(){
    return this.pages;
};
