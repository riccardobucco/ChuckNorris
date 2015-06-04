/*
 * Name: MapChartMovieUpdater.js
 * Module: DataModel/NorrisChart
 * Location: Norris/Main/DataModel
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
 * v0.03 2015-04-25 Chiara Bigarella   Edit
 * ================================================================================
 * v0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * v0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */
module.exports=MapChartMovieUpdater;

/**
 * Creates a new MapChartMovieUpdater.
 * @constructor
 */
function MapChartMovieUpdater() {
    if(!(this instanceof MapChartMovieUpdater)) return new MapChartMovieUpdater();
}

MapChartMovieUpdater.prototype.instance=new MapChartMovieUpdater(); // static

/**
 * Gets the MapChartMovieUpdater's instance.
 * @returns {MapChartMovieUpdater} the MapChartMovieUpdater's instance.
 */
MapChartMovieUpdater.getInstance = function() { // static
    return MapChartMovieUpdater.prototype.instance;
};

/**
 * Updates a map chart with movie method. The map chart data should not be empty.
 * @param {MapChartImpl} chart - the map chart to update;
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

/*

 MapChart:
 data = [
    {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie1
    {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie2
    {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]} // serie3
 ]

 mapchart:movie:
 update = {
    inplace : [
        { position: {series:0, index:0}, data: {x:1, y:1} },
        { position: {series:0, index:1}, data: {x:2, y:2} }
    ], // modifico 2 valori già esistenti
    stream: [
        {series : 1, data : {x: 1, y: 2} },
        {series : 3, data: {x: 1, y: 3} }
    ],
    delete: [
        {series:0, index:0},
        {series:0, index:1},
        {series:0, index:3}
    ] // elimino 3 punti
 }

 series : 1, data {x: 1, y: 2}

*/

