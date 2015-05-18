/*
 * Name: {BarChartInPlaceUpdater.js}
 * Module: {}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-05-15}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-15 Chiara Bigarella {creation}
 * ================================================================================
 */
module.exports=BarChartInPlaceUpdater;

function BarChartInPlaceUpdater() {
    if(!(this instanceof BarChartInPlaceUpdater)) return new BarChartInPlaceUpdater();
}

BarChartInPlaceUpdater.prototype.instance=new BarChartInPlaceUpdater(); // static

BarChartInPlaceUpdater.getInstance = function() { // static
    return BarChartInPlaceUpdater.prototype.instance;
};

BarChartInPlaceUpdater.prototype.update = function (chart, updateData) {
    chart.setData(updateData);
};