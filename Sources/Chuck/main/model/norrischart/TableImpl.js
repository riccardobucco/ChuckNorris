/*
 * Name: {TableImpl.js}
 * Module: {}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-05-04}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.1 2015-05-04 Chiara Bigarella {creation}
 * ================================================================================
 */

angular.module('chuck-chart')

.factory('TableImpl', ['ChartImpl', 'TableInPlaceUpdater', 'TableStreamUpdater', function (ChartImpl, TableInPlaceUpdater, TableStreamUpdater) {

    var defaults = {
        description : 'This is a table.',
        showLegend : true,
        legendPosition : 'top-right',
        maxPoints : 5
    };

    /**
     * Creates a new table.
     * @constructor
     * @param {String} id - the table's id.
     */
    function TableImpl (id) {
        if (!(this instanceof TableImpl)) return new TableImpl(uid);
        ChartImpl.call(this, 'table',id);
        for(var key in defaults) {
            this.settings[key] = defaults[key];
        }
    }

    TableImpl.prototype.__proto__ = ChartImpl.prototype;

    /* TableFactory ------------------------------------------------------- */

    /**
     * Creates a new table factory.
     * @constructor
     */
    function TableFactory() {
        if(!(this instanceof TableFactory)) return new TableFactory();
    }

    TableFactory.prototype.instance = new TableFactory(); // static

    /**
     * Gets the TableFactory's instance.
     * @returns {TableFactory} the factory's instance.
     */
    TableFactory.getInstance = function() { // static
        return TableFactory.prototype.instance;
    };

    /**
     * Creates a new table.
     * @param {String} id - the table's id;
     * @returns {BarChartImpl} - the created table.
     */
    TableFactory.prototype.createChart = function (id) {
        return new TableImpl(id);
    };

    ChartImpl.registerFactory('table' , TableFactory.getInstance());
    ChartImpl.registerUpdater('table:inplace', TableInPlaceUpdater.getInstance());
    ChartImpl.registerUpdater('table:stream', TableStreamUpdater.getInstance());

    return TableImpl;

}]);