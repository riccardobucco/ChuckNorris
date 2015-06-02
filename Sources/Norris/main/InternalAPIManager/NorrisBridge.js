/*
 * Name: {NorrisBridge.js}
 * Module: {InternalAPIManager}
 * Location: {Norris/Main/InternalAPIManager}
 * Date: {2015-04-12}
 * Version: {v0.6}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.06 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.05 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.04 2015-04-27 Bigarella Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Bucco Riccardo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */

var ChartBridge = require('./ChartBridge.js');
var PageBridge = require('./PageBridge.js');

module.exports = NorrisBridge;

/**
 * Creates an instance of NorrisBridge.
 * 
 * @constructor
 * @param {NorrisImpl} model - The model to which attach the bridge.
 */
function NorrisBridge(model) {
    if (!(this instanceof NorrisBridge)) return new NorrisBridge();
    
    /** @private */
    this.model = model;
}

/**
 * Sets the settings for the Norris instance.
 *
 * @param {NorrisSettings} settings - The settings to set to the Norris instance.
 */
NorrisBridge.prototype.setSettings = function (settings) {
    this.model.setSettings(settings);
};

/**
 * Gets the settings for the Norris instance.
 *
 * @return {NorrisSettings} The settings of the Norris instance.
 */
NorrisBridge.prototype.getSettings = function () {
    return this.model.getSettings();
};

/**
 * Creates a new chart.
 *
 * @param {String} chartType - The type of the chart to create.
 * @param {String} chartId - The id of the chart to create.
 * @return {ChartBridge} The created chart.
 */
NorrisBridge.prototype.createChart = function (chartType, chartId) {
    var chart = this.model.createChart(chartType, chartId);
    return new ChartBridge(chart);
};

/**
 * Retrieves a chart from the Norris instance.
 *
 * @param {String} chartId - The id of the chart to retrieve.
 * @return {ChartBridge} The retrieved chart.
 */
NorrisBridge.prototype.getChart = function (chartId) {
    var chart = this.model.getChart(chartId);
    return new ChartBridge(chart);
};

/**
 * Retrieves all charts from the Norris instance.
 *
 * @return {ChartBridge[]} The retrieved charts.
 */
NorrisBridge.prototype.getCharts = function () {
    var modelCharts = this.model.getCharts();
    var charts = [];
    modelCharts.forEach(function (chart) {
        charts.push(new ChartBridge(chart));
    });
    return charts;
};

/**
 * Creates a new page.
 *
 * @param {String} pageId - The id of the page to create.
 * @return {PageBridge} The created page.
 */
NorrisBridge.prototype.createPage = function (pageId) {
    var page = this.model.createPage(pageId);
    return new PageBridge(page);
};

/**
 * Retrieves a page from the Norris instance.
 *
 * @param {String} pageId - The id of the page to retrieve.
 * @return {PageBridge} The retrieved page.
 */
NorrisBridge.prototype.getPage = function (pageId) {
    var page = this.Bridge.getPage(pageId);
    return new PageBridge(page);
};

/**
 * Retrieves all pages from the Norris instance.
 *
 * @return {PageBridge[]} The retrieved pages.
 */
NorrisBridge.prototype.getPages = function () {
    var modelPages = this.model.getPages();
    var pages = [];
    modelPages.forEach(function (page) {
        pages.push(new PageBridge(page));
    });
    return pages;
};

NorrisBridge.prototype.getMiddleware = function (page) {
    var express=require('express');
    var app = express();
    app.set('views', __dirname+'/../../templates'); /* sets the directory which contains the template */
    app.set('view engine', 'ejs'); /* sets the default template engine */
    app.engine('html', require('ejs').renderFile);

    var settings=page.getSettings();
    var title= settings.title;
    var maxChartsRow=settings.maxChartsRow;
    var maxChartsCol=settings.maxChartsCol;
    var content=[];
    var charts=page.getCharts();

    for(var i in charts) {
        var chart=charts[i].getChartModel();
        var type=chart.getType();
        var id=chart.getId();
        content.push({html: "<chuck-"+type+" chart-endpoint='localhost:9000' chart-id="+id+"></chuck-"+type+">"});
    }
    console.log (content);

    app.get('/', function(req, res) {
        res.render('index.html', {title: title,
            maxChartsRow : maxChartsRow,
            maxChartsCol : maxChartsCol,
            body: content});
        });

    /* static middleware */
    app.use('/images', express.static(__dirname+'/../../images') );
    app.use('/bower_components', express.static(__dirname+'/../../bower_components') );
    app.use('/css', express.static(__dirname+'/../../css') );

    return app;
};
