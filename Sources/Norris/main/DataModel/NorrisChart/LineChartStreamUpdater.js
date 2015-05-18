/*
 * Name: {LineChartStreamUpdater.js}
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
module.exports=LineChartStreamUpdater;

function LineChartStreamUpdater() {
    if(!(this instanceof LineChartStreamUpdater)) return new LineChartStreamUpdater();
}

LineChartStreamUpdater.prototype.instance=new LineChartStreamUpdater(); // static

LineChartStreamUpdater.getInstance = function() { // static
    return LineChartStreamUpdater.prototype.instance;
};

LineChartStreamUpdater.prototype.update = function (chart, updateData) {
    //aggiornamento stream
    chart.setData(updateData);
};