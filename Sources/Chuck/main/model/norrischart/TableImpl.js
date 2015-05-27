/*
 * Name: {TableImpl.js}
 * Module: {Model/NorrisChart}
 * Location: {Chuck/Main/Model/NorrisChart}
 * Date: {2015-04-12}
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
 * 0.03 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */

angular.module('chuck-chart')

.factory('TableImpl', ['ChartImpl', 'TableInPlaceUpdater', 'TableStreamUpdater', function (ChartImpl, TableInPlaceUpdater, TableStreamUpdater) {

    var defaults = {
        description : 'This is a table.',
        maxRows : 10 ,
	    showTableGrid : true ,
	    newLinePosition : 'bottom'
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
