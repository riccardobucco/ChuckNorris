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

angular.module('norris-chartupdater')

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
                    data.labels.push(updateData[i].label);
                    if (updateData[i].data.length==data.datasets.length) {
                        for(var k=0; k<data.datasets.length; k++) {
                            data.datasets[k].values.push(updateData[i].data[k]);
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