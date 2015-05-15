/*
 * Name: {ChartFactory.js}
 * Module: {DataModel}
 * Location: {Norris/Main/DataModel}
 * Date: {05-05-2015}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.1 05-05-2015 Chiara Bigarella {creation}
 * ================================================================================
 */
module.exports = ChartFactory;

function ChartFactory(uid) {
    if (!(this instanceof ChartFactory)) return new ChartFactory(uid);
    this.uid=uid;
    this.dependencies = {
        barchart : require('./BarChartImpl.js'),
        linechart : require('./LineChartImpl.js'),
        mapchart : require('./MapChartImpl.js'),
        table : require('./TableImpl.js')
    };
}

ChartFactory.prototype.register = function(key, value) {
    this.dependencies[key] = value;
};

ChartFactory.prototype.resolve = function(deps) {
    return new (this.dependencies[deps])(this.uid);
};

