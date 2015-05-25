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

angular.module('norris-chartupdater', [])

.factory('BarChartInPlaceUpdater',function () {

    function BarChartInPlaceUpdater() {
        if(!(this instanceof BarChartInPlaceUpdater)) return new BarChartInPlaceUpdater();
    }

    BarChartInPlaceUpdater.prototype.instance=new BarChartInPlaceUpdater(); // static

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

});