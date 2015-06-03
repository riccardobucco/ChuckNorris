/*
 * Name: {MapChartInPlaceUpdater.js}
 * Module: {Model/NorrisChart}
 * Location: {Chuck/Main/Model/NorrisChart}
 * Date: {2015-04-12}
 * Version: {v0.6}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */

angular.module('norris-chartupdater')

.factory('MapChartInPlaceUpdater', [function () {
	/**
	 * Creates an instance of a new MapChartInPlaceUpdater, or returns the existing instance, if it already exits.
	 * @constructor
	 */
    function MapChartInPlaceUpdater() {
        if(!(this instanceof MapChartInPlaceUpdater)) return new MapChartInPlaceUpdater();
    }

    MapChartInPlaceUpdater.prototype.instance=new MapChartInPlaceUpdater(); // static
	
	/**
     * Returns the unique existing instance of the MapChartInPlaceUpdater
     * @return {MapChartInPlaceUpdater} - the unique existing instance of the class
     */
    MapChartInPlaceUpdater.getInstance = function() { // static
        return MapChartInPlaceUpdater.prototype.instance;
    };

    /**
     * Updates a map chart with in place method. The map chart data should not be empty.
     * @param {MapChartImpl} chart - the map chart to update;
     * @param updateData - the updating.
     */
    MapChartInPlaceUpdater.prototype.update = function (chart, updateData) {
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
                for(var i=0; i<updateData.length; i++) {
                    var series=updateData[i].position.series;
                    var index=updateData[i].position.index;
                    data[series].values[index].x=updateData[i].data.x;
                    data[series].values[index].y=updateData[i].data.y;
                }
                chart.setData(data);
            }
            else {
                console.log("ERROR: the chart has no data to update.");
                throw ("emptyChart");
            }
        }
    };

    return MapChartInPlaceUpdater;

}]);