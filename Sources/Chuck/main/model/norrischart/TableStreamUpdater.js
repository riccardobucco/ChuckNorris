/*
 * Name: {TableStreamUpdater.js}
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
            if (!isEmpty(data)) {
                for(var i=0; i<updateData.length; i++) {
                    if (updateData[i].length==data.headers.length) {
                        data.datasets.push(updateData[i]);
                        if (data.datasets.length>chart.getSettings().maxRows) {
                            data.datasets[0]=null;
                            data.datasets== data.datasets.filter(function (e) {return e!=null;});
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
        }};
    };

    return TableStreamUpdater;

}]);