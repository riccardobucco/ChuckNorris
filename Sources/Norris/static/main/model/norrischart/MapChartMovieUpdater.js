/*
 * Name: MapChartMovieUpdater.js
 * Module: Model/NorrisChart
 * Location: Chuck/Main/DataModel/NorrisChart
 * Date: 2015-04-12
 * Version: v0.06
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * v0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * v0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * v0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * v0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * v0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */

angular.module('norris-chartupdater')

.factory('MapChartMovieUpdater', [function () {
	
	/**
	 * Creates an instance of a new MapChartMovieUpdater, or returns the existing instance, if it already exits.
	 * @constructor
	 */
    function MapChartMovieUpdater() {
        if(!(this instanceof MapChartMovieUpdater)) return new MapChartMovieUpdater();
    }

    MapChartMovieUpdater.prototype.instance=new MapChartMovieUpdater(); // static

	/**
     * Returns the unique existing instance of the MapChartMovieUpdater
     * @return {MapChartMovieUpdater} - the unique existing instance of the class
     */
    MapChartMovieUpdater.getInstance = function() { // static
        return MapChartMovieUpdater.prototype.instance;
    };

	/**
     * Updates a map chart with in place method. The map chart data should not be empty.
     * @param {ChartImpl} chart - the map chart to update;
     * @param updateData - the updating.
     */
    MapChartMovieUpdater.prototype.update = function (chart, updateData) {
        var isEmpty=function(obj) {
            for(var prop in obj) {
                if(obj.hasOwnProperty(prop))
                    return false;
            }
            return true;
        };

        if (!isEmpty(updateData)) {
            var data=chart.getData();
            if (!isEmpty(data)) {
            /* In place: */
                for(var i=0; i<updateData.inplace.length; i++) {
                    var series=updateData.inplace[i].position.series;
                    var index=updateData.inplace[i].position.index;
                    data[series].values[index].x=updateData.inplace[i].data.x;
                    data[series].values[index].y=updateData.inplace[i].data.y;
                }

                /* Stream: */
                for(var i=0; i<updateData.stream.length; i++) {
                    var series=updateData.stream[i].series;
                    var val=updateData.stream[i].data;
                    data[series].values.push(val);
                    if (data[series].values.length > chart.getSettings().maxValues) {
                        data[series].values.shift();
                    }
                }

                /* Delete: */
                for(var i=0; i<updateData.delete.length; i++) {
                    var series=updateData.delete[i].series;
                    var index=updateData.delete[i].index;
                    for (var k=i; k<updateData.delete; k++) {
                        if ( series== updateData.delete[k].series ){
                            updateData.delete[k].index--;
                        }
                    }
                    data[series].values[index]=null;
                    data[series].values = data[series].values.filter(function (e) {return e!=null;});
                }

                chart.setData(data);
            }
            else {
                console.log("ERROR: the chart has no data to update.");
                throw ("emptyChart");
            }
        }
    };

    return MapChartMovieUpdater;

}]);