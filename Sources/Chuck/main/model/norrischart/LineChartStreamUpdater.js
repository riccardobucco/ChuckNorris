/*
 * Name: {LineChartStreamUpdater.js}
 * Module: {Model/NorrisChart}
 * Location: {Norris/Main/DataModel/NorrisChart}
 * Date: {2015-04-10}
 * Version: {v0.6}
 *
 * History:
 *
 * ================================================================================
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Carlon Chiara   Creation
 * ================================================================================
 */

angular.module('norris-chartupdater')


/**
 * Creates a new LineChartStreamUpdater using the inversion of control.
 * @param {String} className
 * @param settings
 * @constructor
 */
.factory('LineChartStreamUpdater', [function () {

    function LineChartStreamUpdater() {
        if(!(this instanceof LineChartStreamUpdater)) return new LineChartStreamUpdater();
    }

    LineChartStreamUpdater.prototype.instance=new LineChartStreamUpdater(); // static

    LineChartStreamUpdater.getInstance = function() { // static
        return LineChartStreamUpdater.prototype.instance;
    };

    LineChartStreamUpdater.prototype.update = function (chart, updateData) {
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
                    if (updateData[i].data.length==data.datasets.length) {
                        for(var k=0; k<data.datasets.length; k++) {
                            data.datasets[k].values.push(updateData[i].data[k]);
                            if (data.datasets[k].values.length>chart.getSettings().maxPoints) {
                                data.datasets[k].values.shift();
                            }
                        }
                        data.labels.push(updateData[i].label);
                        if (data.labels.length>chart.getSettings().maxPoints) {
                            data.labels.shift();
                        }

                    }
                    else {
                        throw ("wrongUpdateData");
                    }
                }
                chart.setData(data);
            }
            else {
                console.log("ERROR: the chart has no data to update.");
                throw ("emptyChart");
            }
        }
    };

    return LineChartStreamUpdater;

}]);