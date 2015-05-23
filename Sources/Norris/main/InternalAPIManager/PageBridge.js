/**
 * An handle to manage a Norris chart
 * @module {ChartBridge} InternalAPIManager/ChartBridge
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

module.exports = PageBridge;

/**
 * Creates an instance of PageBridge.
 * 
 * @constructor
 * @param {PageImpl} model - The model to which attach the bridge.
 */
function PageBridge(page) {
    if (!(this instanceof PageBridge)) return new PageBridge(pageId);

    /** @private */
    this.page = page;
}

/**
 * Adds a new chart to this page.
 *
 * @param {ChartBridge} chart - The chart to add.
 * @return {PageBridge} The instance of this PageBridge.
 */
PageBridge.prototype.add = function (chart) {
    var chart = chart.getChartModel();
    this.page.add(chart);
    return this;
};

/**
 * Gets the page's id.
 *
 * @return {String} The page's id.
 */
PageBridge.prototype.getId = function () {
    return this.page.getId();
};

/**
 * Sets the page's settings.
 *
 * @param {PageSettings} settings - The page's settings.
 */
PageBridge.prototype.setSettings = function (settings) {
    this.page.setSettings(setSettings);
};

/**
 * Gets the page's settings.
 *
 * @return {PageSettings} The page's settings.
 */
PageBridge.prototype.getSettings = function () {
    return this.page.getSettings();
};

/**
 * Sets the charts of the page.
 *
 * @param {ChartBridge[]} charts - The charts to set.
 */
PageBridge.prototype.setCharts = function (charts) {
    this.page.clearCharts();
    charts.forEach(function (chart) {
        this.page.add(chart.getChartModel());
    });
};

/**
 * Gets the page's charts.
 *
 * @return {ChartBridge[]} The page's charts.
 */
PageBridge.prototype.getCharts = function () {
    var modelCharts = this.page.getCharts();
    var charts = [];
    modelCharts.forEach(function (chart) {
        charts.push(new ChartBridge(chart));
    });
    return charts;
};