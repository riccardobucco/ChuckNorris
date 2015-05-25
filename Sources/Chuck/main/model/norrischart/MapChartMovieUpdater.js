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

angular.module('norris-chartupdater')

.factory('MapChartMovieUpdater', [function () {

    function MapChartMovieUpdater() {
        if(!(this instanceof MapChartMovieUpdater)) return new MapChartMovieUpdater();
    }

    MapChartMovieUpdater.prototype.instance=new MapChartMovieUpdater(); // static

    MapChartMovieUpdater.getInstance = function() { // static
        return MapChartMovieUpdater.prototype.instance;
    };

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
                    data.push(updateData.stream[i]);
                }

                /* Delete: */
                for(var i=0; i<updateData.delete.length; i++) {
                    var series=updateData.delete[i].series;
                    var index=updateData.delete[i].index;
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