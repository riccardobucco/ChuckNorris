/*
 * Name: {TableStreamUpdater.js}
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

.factory('TableStreamUpdater', [function () {

    function TableStreamUpdater() {
        if(!(this instanceof TableStreamUpdater)) return new TableStreamUpdater();
    }

    TableStreamUpdater.prototype.instance=new TableStreamUpdater(); // static

    TableStreamUpdater.getInstance = function() { // static
        return TableStreamUpdater.prototype.instance;
    };

    TableStreamUpdater.prototype.update = function (chart, updateData) {
        var isEmpty=function(obj) {
            for(var prop in obj) {
                if(obj.hasOwnProperty(prop))
                    return false;
            }
            return true;
        };

        if (!isEmpty(updateData)) {
            var data=chart.getData();
            var newLinePosition=chart.getSettings().newLinePosition;
            if (!isEmpty(data)) {
                for(var i=0; i<updateData.length; i++) {
                    if (updateData[i].length==data.headers.length) {
                        if(newLinePosition=='bottom') {
                            data.datasets.push(updateData[i]);
                            if (data.datasets.length>chart.getSettings().maxRows) {
                                data.datasets.shift();
                            }
                        }
                        else {
                            data.datasets.unshift(updateData[i]); /* inserts in top */
                            if (data.datasets.length>chart.getSettings().maxRows) {
                                data.datasets.pop();
                            }
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

    return TableStreamUpdater;

}]);