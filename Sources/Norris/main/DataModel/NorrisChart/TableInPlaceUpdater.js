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
 * 0.01 2015-05-15 Chiara Bigarella {creation}
 * ================================================================================
 */
module.exports=TableInPlaceUpdater;

function TableInPlaceUpdater() {
    if(!(this instanceof TableInPlaceUpdater)) return new TableInPlaceUpdater();
}

TableInPlaceUpdater.prototype.instance=new TableInPlaceUpdater(); // static

TableInPlaceUpdater.getInstance = function() { // static
    return TableInPlaceUpdater.prototype.instance;
};

TableInPlaceUpdater.prototype.update = function (chart, updateData) {
    // aggiornamento in place
    chart.setData(updateData);
};