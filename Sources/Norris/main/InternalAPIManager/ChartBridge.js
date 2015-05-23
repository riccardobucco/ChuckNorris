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

module.exports = ChartBridge;

/**
 * Creates an instance of ChartBridge.
 * 
 * @constructor
 * @param {ChartImpl} chart - The model to which attach the bridge.
 */
function ChartBridge(chart) {
    if (!(this instanceof ChartBridge)) return new ChartBridge(chart);

    /** @private */
    this.chart = chart;
}

/**
 * Returns the instance of the represented chart.
 *
 * @return {ChartImpl} The represented chart.
 */
ChartBridge.prototype.getChartModel = function () {
    return this.chart;
};

/**
 * Return the chart's id.
 *
 * @return {String} The chart's id.
 */
ChartBridge.prototype.getId = function () {
    return this.chart.getId();
};

/**
 * Return the chart's type.
 *
 * @return {String} The chart's type.
 */
ChartBridge.prototype.getType = function () {
    return this.chart.getType();
};

/**
 * Sets the chart's data.
 *
 * @param {ChartData} data - The chart's data.
 */
ChartBridge.prototype.setData = function (data) {
    this.chart.setData(data);
};

/**
 * Gets the chart's data.
 *
 * @return {ChartData} The chart's data.
 */
ChartBridge.prototype.getData = function () {
    return this.chart.getData();
};

/**
 * Sets the chart's settings.
 *
 * @param {ChartSettings} settings - The chart's settings.
 */
ChartBridge.prototype.setSettings = function (settings) {
    this.chart.setSettings(settings);
};

/**
 * Gets the chart's settings.
 *
 * @return {ChartSettings} The chart's settings.
 */
ChartBridge.prototype.getSettings = function() {
    return this.chart.getSettings();
};

/**
 * Updates the chart.
 *
 * @param {String} updateType - The update's name.
 * @param {ChartUpdate} updateData - The update's data.
 */
ChartBridge.prototype.update = function (updateType, updateData) {
    this.chart.update(updateType, updateData);
};