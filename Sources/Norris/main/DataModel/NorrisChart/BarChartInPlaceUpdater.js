/*
 * Name: {BarChartInPlaceUpdater.js}
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
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.04 2015-04-27 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.03 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Carlon Chiara   Creation
 * ================================================================================
 */
module.exports=BarChartInPlaceUpdater;

/**
 * Creates a new BarChartInPlaceUpdater.
 * @constructor
 */
function BarChartInPlaceUpdater() {
    if(!(this instanceof BarChartInPlaceUpdater)) return new BarChartInPlaceUpdater();
}

BarChartInPlaceUpdater.prototype.instance=new BarChartInPlaceUpdater(); // static

/**
 * Gets the BarChartInPlaceUpdater's instance.
 * @returns {BarChartInPlaceUpdater} the BarChartInPlaceUpdater's instance.
 */
BarChartInPlaceUpdater.getInstance = function() { // static
    return BarChartInPlaceUpdater.prototype.instance;
};

/**
 * Updates a bar chart with in place method. The bar chart data should not be empty.
 * @param {BarChartImpl} chart - the bar chart to update;
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
    }
};

/*
 BarChart:
 data = {
    labels: ['2010','2011','2012','2013'], // asse indipendente
    datasets: [
        {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // serie1
        {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // serie2
        {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // serie3
    ]
 }

 barchart:inplace:
 update = [
    { position: {x:0, y:0}, value='foo' },
    { position: {x:0, y:1}, value='foo' }
 ] // modifico 2 valori già esistenti
*/