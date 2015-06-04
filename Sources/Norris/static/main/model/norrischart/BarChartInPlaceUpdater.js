/*
 * Name: {BarChartInPlaceUpdater.js}
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
 * 0.06 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.05 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.04 2015-04-27 Bigarella Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */

angular.module('norris-chartupdater')

.factory('BarChartInPlaceUpdater', [function () {
	/**
	 * Creates an instance of a new BarChartInPlaceUpdater, or returns the existing instance, if it already exits.
	 * @constructor
	 */
    function BarChartInPlaceUpdater() {
        if(!(this instanceof BarChartInPlaceUpdater)) return new BarChartInPlaceUpdater();
    }

    BarChartInPlaceUpdater.prototype.instance=new BarChartInPlaceUpdater(); // static
	
	/**
     * Returns the unique existing instance of the BarChartInPlaceUpdater
     * @return {BarChartInPlaceUpdater} - the unique existing instance of the class
     */
    BarChartInPlaceUpdater.getInstance = function() { // static
        return BarChartInPlaceUpdater.prototype.instance;
    };

    /**
     * Updates a bar chart with in place method. The bar chart data should not be empty.
     * @param {ChartImpl} chart - the bar chart to update;
     * @param updateData - the updating.
     */
    BarChartInPlaceUpdater.prototype.update = function (chart, updateData) {
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
                    var x=updateData[i].position.x;
                    var y=updateData[i].position.y;
                    data.datasets[x].values[y]=updateData[i].value;
                }
                chart.setData(data);
            }
            else {
                console.log("ERROR: the chart has no data to update.");
                throw ("emptyChart");
            }
        };
    };

    return BarChartInPlaceUpdater;

}]);