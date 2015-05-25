/*
 * Name: {LineChartInPlaceUpdater.js}
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
module.exports=LineChartInPlaceUpdater;

/**
 * Creates a new LineChartInPlaceUpdater.
 * @constructor
 */
function LineChartInPlaceUpdater() {
    if(!(this instanceof LineChartInPlaceUpdater)) return new LineChartInPlaceUpdater();
}

LineChartInPlaceUpdater.prototype.instance=new LineChartInPlaceUpdater(); // static

/**
 * Gets the LineChartInPlaceUpdater's instance.
 * @returns {LineChartInPlaceUpdater} the LineChartInPlaceUpdater's instance.
 */
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

/*
 data = {
    labels: ['2010','2011','2012','2013'], // asse indipendente
    datasets: [
        {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea1
        {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea2
        {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea3
    ]
 }

 linechart:inplace:
    update = [
        { position: {x:0, y:0}, value='foo' },
        { position: {x:0, y:1}, value='foo' }
    ] // modifico 2 valori già esistenti
*/