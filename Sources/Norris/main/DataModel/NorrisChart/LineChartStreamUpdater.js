/*
 * Name: LineChartStreamUpdater.js
 * Module: DataModel/NorrisChart
 * Location: Norris/Main/DataModel/NorrisChart
 * Date: 2015-04-10
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
 * v0.02 2015-04-14 Carlon Chiara   Verify
 * ================================================================================
 * v0.01 2015-04-10 Pavanello Fabio Matteo   Creation
 * ===============================================================================
 */
module.exports=LineChartStreamUpdater;

/**
 * Creates a new LineChartStreamUpdater.
 * @constructor
 */
function LineChartStreamUpdater() {
    if(!(this instanceof LineChartStreamUpdater)) return new LineChartStreamUpdater();
}

LineChartStreamUpdater.prototype.instance=new LineChartStreamUpdater(); // static

/**
 * Gets the LineChartStreamUpdater's instance.
 * @returns {LineChartStreamUpdater} the LineChartStreamUpdater's instance.
 */
LineChartStreamUpdater.getInstance = function() { // static
    return LineChartStreamUpdater.prototype.instance;
};

/**
 * Updates a line chart with stream method. The line chart data should not be empty.
 * @param {LineChartImpl} chart - the line chart to update;
 * @param updateData - the updating.
 */
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
                        if (data.datasets[k].values.length>chart.getSettings().maxValues) {
                            data.datasets[k].values.shift();
                        }
                    }
                    data.labels.push(updateData[i].label);
                    if (data.labels.length>chart.getSettings().maxValues) {
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

/*
 data = {
    labels: ['2010','2011','2012','2013'], // asse indipendente
    datasets: [
        {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea1
        {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea2
        {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea3
    ]
 }

 linechart:stream
 update = {
    stream: [
        {label: 'foo', data: [1,2,3,4,5]},
        {label: 'bar', data: [1,2,3,4,5]}
    ] // aggiungo 2 valori indipendenti con i rispettivi valori dipendenti per ogni linea
 }
*/
