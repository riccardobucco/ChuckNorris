/*
 * Name: {ChartBridge.js}
 * Module: {InternalAPIManager}
 * Location: {Norris/Main/InternalAPIManager}
 * Date: {2015-05-17}
 * Version: {v0.01}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-17 Davide Dal Bianco {creation}
 * ================================================================================
 */

module.exports = ChartBridge;

function ChartBridge(chart) {
    if (!(this instanceof ChartBridge)) return new ChartBridge(chart);
    this.chart = chart;
}

ChartBridge.prototype.getChartModel = function () {
    return this.chart;
};

ChartBridge.prototype.getId = function () {
    return this.chart.getId();
};

ChartBridge.prototype.getType = function () {
    return this.chart.getType();
};

ChartBridge.prototype.setData = function (data) {
    this.chart.setData(data);
};

ChartBridge.prototype.getData = function () {
    return this.chart.getData();
};

ChartBridge.prototype.setSettings = function (settings) {
    this.chart.setSettings(settings);
};

ChartBridge.prototype.getSettings = function() {
    return this.chart.getSettings();
};

ChartBridge.prototype.update = function (updateType, updateData) {
    this.chart.update(updateType, updateData);
};