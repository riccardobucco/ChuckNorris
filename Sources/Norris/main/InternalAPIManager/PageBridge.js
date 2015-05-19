/*
 * Name: {PageBridge.js}
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

module.exports = PageBridge;

function PageBridge(page) {
    if (!(this instanceof PageBridge)) return new PageBridge(pageId);
    this.page = page;
}

PageBridge.prototype.add = function (chart) {
    var chart = chart.getChartModel();
    this.page.add(chart);
};

PageBridge.prototype.getId = function () {
    return this.page.getId();
};

PageBridge.prototype.setSettings = function (settings) {
    this.page.setSettings(setSettings);
};

PageBridge.prototype.getSettings = function() {
    return this.page.getSettings();
};