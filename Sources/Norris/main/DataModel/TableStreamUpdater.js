/*
 * Name: {TableStreamUpdater.js}
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
module.exports=TableStreamUpdater;

function TableStreamUpdater() {
    if(!(this instanceof TableStreamUpdater)) return new TableStreamUpdater();
}

TableStreamUpdater.prototype.instance=new TableStreamUpdater(); // static

TableStreamUpdater.getInstance = function() { // static
    return TableStreamUpdater.prototype.instance;
};

TableStreamUpdater.prototype.update = function (chart, updateData) {
    chart.setData(updateData);
};