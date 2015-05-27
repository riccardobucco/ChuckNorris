/*
 * Name: {LineChartInPlaceUpdater.js}
 * Module: {Model/NorrisChart}
 * Location: {Chuck/Main/Model/NorrisChart}
 * Date: {2015-04-10}
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
 * 0.02 2015-04-14 Carlon Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Pavanello Fabio Matteo   Creation
 * ================================================================================
 */

angular.module('norris-chartupdater')

.factory('LineChartInPlaceUpdater', [function () {

function LineChartInPlaceUpdater() {
    if(!(this instanceof LineChartInPlaceUpdater)) return new LineChartInPlaceUpdater();
}

LineChartInPlaceUpdater.prototype.instance=new LineChartInPlaceUpdater(); // static

    LineChartInPlaceUpdater.getInstance = function() { // static
        return LineChartInPlaceUpdater.prototype.instance;
    };

    /**
     * Updates a line chart with in place method. The line chart data should not be empty.
     * @param {LineChartImpl} chart - the line chart to update;
     * @param updateData - the updating.
     */
    LineChartInPlaceUpdater.prototype.update = function (chart, updateData) {
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
        }
    };

    return LineChartInPlaceUpdater;

}]);