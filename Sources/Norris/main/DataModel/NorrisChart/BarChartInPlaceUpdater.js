/*
 * Name: {BarChartInPlaceUpdater.js}
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
module.exports=BarChartInPlaceUpdater;

function BarChartInPlaceUpdater() {
    if(!(this instanceof BarChartInPlaceUpdater)) return new BarChartInPlaceUpdater();
}

BarChartInPlaceUpdater.prototype.instance=new BarChartInPlaceUpdater(); // static

BarChartInPlaceUpdater.getInstance = function() { // static
    return BarChartInPlaceUpdater.prototype.instance;
};

/**
 * Updates a bar chart with in place method. The bar chart data should not be empty.
 * @param {ChartImpl} chart - the bar chart to update;
 * @param updateData - the updating.
 */


BarChartInPlaceUpdater.prototype.update = function (chart, updateData) {
    if (updateData != null) {
        var data=chart.getData();
        console.log(JSON.stringify(data));
        var isEmpty=function(obj) {
            for(var prop in obj) {
                if(obj.hasOwnProperty(prop))
                    return false;
            }
            return true;
        }
        if (!isEmpty(data)) {
            for(var i=0; i<updateData.length; i++) {
                var x=updateData[i].position.x;
                var y=updateData[i].position.y;
                data.datasets[x].values[y]=updateData[i].data.value;
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
    { position: {x:0, y:0}, data: {value='foo'} },
    { position: {x:0, y:1}, data: {value='foo'} }
 ] // modifico 2 valori già esistenti
*/