/*
 * Name: {MapChartInPlaceUpdater.js}
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
module.exports=MapChartInPlaceUpdater;

function MapChartInPlaceUpdater() {
    if(!(this instanceof MapChartInPlaceUpdater)) return new MapChartInPlaceUpdater();
}

MapChartInPlaceUpdater.prototype.instance=new MapChartInPlaceUpdater(); // static

MapChartInPlaceUpdater.getInstance = function() { // static
    return MapChartInPlaceUpdater.prototype.instance;
};

MapChartInPlaceUpdater.prototype.update = function (chart, updateData) {
    // aggiornamento in place
    chart.setData(updateData);
};