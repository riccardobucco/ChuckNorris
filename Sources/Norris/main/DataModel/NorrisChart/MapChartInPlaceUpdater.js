/*
 * Name: {MapChartInPlaceUpdater.js}
 * Module: {}
 * Location: {Norris/Main/DataModel/NorrisChart}
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
module.exports=MapChartInPlaceUpdater;

/**
 * Creates a new MapChartInPlaceUpdater.
 * @constructor
 */
function MapChartInPlaceUpdater() {
    if(!(this instanceof MapChartInPlaceUpdater)) return new MapChartInPlaceUpdater();
}

MapChartInPlaceUpdater.prototype.instance=new MapChartInPlaceUpdater(); // static

/**
 * Gets the MapChartInPlaceUpdater's instance.
 * @returns {MapChartInPlaceUpdater} the MapChartInPlaceUpdater's instance.
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

/*

 MapChart:
 data = [
    {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie1
    {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie2
    {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie3
 ]

 mapchart:inplace:
 update = [
    { position: {series:0, index:0}, data: {x:1, y:1} },
    { position: {series:0, index:1}, data: {x:1, y:1} }
 ] // modifico 2 valori già esistenti
 */