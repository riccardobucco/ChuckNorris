/*
 * Name: {TableInPlaceUpdater.js}
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
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Chiara Bigarella   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Carlon Chiara   Creation
 * ================================================================================
 */
module.exports=TableInPlaceUpdater;

/**
 * Creates a new TableInPlaceUpdater.
 * @constructor
 */
function TableInPlaceUpdater() {
    if(!(this instanceof TableInPlaceUpdater)) return new TableInPlaceUpdater();
}

TableInPlaceUpdater.prototype.instance=new TableInPlaceUpdater(); // static

/**
 * Gets the TableInPlaceUpdater's instance.
 * @returns {MapChartInPlaceUpdater} the TableInPlaceUpdater's instance.
 */
TableInPlaceUpdater.getInstance = function() { // static
    return TableInPlaceUpdater.prototype.instance;
};

TableInPlaceUpdater.prototype.update = function (chart, updateData) {
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
                data.datasets[x][y].color=updateData[i].data.color;
                data.datasets[x][y].background=updateData[i].data.background;
                data.datasets[x][y].value=updateData[i].data.value;
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

 Table:
 data = {
    headers: ['anno','mese','giorno','ora'], // intestazioni colonne
    datasets: [
        [ {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'}
        ], // riga1
        [ {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'}
        ], // riga2
    ]
 }

 table:inplace:
 update = [
    { position: {x:0, y:0}, data: {color: {r: 255, g: 255, b: 255}, background: {r: 255, g: 255, b: 255}, value:'foo'} },
    { position: {x:0, y:1}, data: {color: {r: 255, g: 255, b: 255}, background: {r: 255, g: 255, b: 255}, value:'foo'} }
 ] // modifico 2 valori già esistenti

*/