/*
 * Name: {LineChartInPlaceUpdater.js}
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
module.exports=LineChartInPlaceUpdater;

function LineChartInPlaceUpdater() {
    if(!(this instanceof LineChartInPlaceUpdater)) return new LineChartInPlaceUpdater();
}

LineChartInPlaceUpdater.prototype.instance=new LineChartInPlaceUpdater(); // static

LineChartInPlaceUpdater.getInstance = function() { // static
    return LineChartInPlaceUpdater.prototype.instance;
};

LineChartInPlaceUpdater.prototype.update = function (chart, updateData) {
    chart.setData(updateData);
};