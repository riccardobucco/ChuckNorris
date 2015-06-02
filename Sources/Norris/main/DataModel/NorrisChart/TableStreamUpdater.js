/*
 * Name: {TableStreamUpdater.js}
 * Module: {DataModel/NorrisChart}
 * Location: {Norris/Main/DataModel/NorrisChart}
 * Date: {2015-04-10}
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
 * 0.03 2015-04-25 Bucco Riccardo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Carlon Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Pavanello Fabio Matteo   Creation
 * ================================================================================
 */
module.exports=TableStreamUpdater;

/**
 * Creates a new TableStreamUpdater.
 * @constructor
 */
function TableStreamUpdater() {
    if(!(this instanceof TableStreamUpdater)) return new TableStreamUpdater();
}

TableStreamUpdater.prototype.instance=new TableStreamUpdater(); // static

/**
 * Gets the TableStreamUpdater's instance.
 * @returns {TableStreamUpdater} the TableStreamUpdater's instance.
 */
TableStreamUpdater.getInstance = function() { // static
    return TableStreamUpdater.prototype.instance;
};

/**
 * Updates a table with stream method. The table data should not be empty.
 * @param {TableImpl} chart - the table to update;
 * @param updateData - the updating.
 */
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

 Table:
 data = {
    headers: ['anno','mese','giorno'], // intestazioni colonne
    datasets: [
        [ {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'}
        ], // riga1
        [ {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'},
            {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '1'}
        ] // riga2
    ]
 }

table:stream:
    update= [
        [{color: 'blue', background: 'white', value: '1'}, {color: 'blue', background: 'white', value: '1'}, {color: 'blue', background: 'white', value: '1'}], // riga 1
        [{color: 'blue', background: 'white', value: '1'}, {color: 'blue', background: 'white', value: '1'}, {color: 'blue', background: 'white', value: '1'}] // riga 2
    ] // aggiungo 2 righe nella posizione indicata nelle impostazioni (in testa o in coda)
*/
