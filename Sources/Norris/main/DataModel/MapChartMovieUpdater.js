/*
 * Name: {MapChartMovieUpdater.js}
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
module.exports=MapChartMovieUpdater;

function MapChartMovieUpdater() {
    if(!(this instanceof MapChartMovieUpdater)) return new MapChartMovieUpdater();
}

MapChartMovieUpdater.prototype.instance=new MapChartMovieUpdater(); // static

MapChartMovieUpdater.getInstance = function() { // static
    return MapChartMovieUpdater.prototype.instance;
};

MapChartMovieUpdater.prototype.update = function (chart, updateData) {
    // aggiornamento movie
    chart.setData(updateData);
};