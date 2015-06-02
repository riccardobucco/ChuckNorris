/*
 * Name: {LineChartImpl.js}
 * Module: {DataModel}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-04-12}
 * Version: {v0.6}
 *
 * History:
 *
 * ================================================================================
 * 0.06 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.05 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.04 2015-04-27 Bigarella Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Bucco Riccardo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */

var ChartImpl = require('./ChartImpl.js');
var LineChartInPlaceUpdater = require('./LineChartInPlaceUpdater.js');
var LineChartStreamUpdater = require('./LineChartStreamUpdater.js');

module.exports = LineChartImpl;

var defaults = {
        description : 'This is a line chart.',
        xLabel : '',
        yLabel : '',
        legendPosition : 'right',
        maxValues : 10,
        style : {
            pointDotSize : 0 , // Number - Size of each point dot in pixels
            bezierCurve : true, // Boolean - Whether the line is curved between points
            showGrid : false,
            animationDuration : 1000
        }
    };

/**
 * Creates a new line chart.
 * @constructor
 * @param {String} id - the line chart's id.
 */
function LineChartImpl (id) {
	if (!(this instanceof LineChartImpl)) return new LineChartImpl(id);
	ChartImpl.call(this, 'linechart', id);
	for(var key in defaults) {
		this.settings[key] = defaults[key];
	}
}

LineChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* LineChartFactory ------------------------------------------------------- */

/**
 * Creates a new line chart factory.
 * @constructor
 */
function LineChartFactory() {
	if(!(this instanceof LineChartFactory)) return new LineChartFactory();
}

LineChartFactory.prototype.instance=new LineChartFactory(); // static

/**
 * Gets the LineChartFactory's instance.
 * @returns {LineChartFactory} the factory's instance.
 */
LineChartFactory.getInstance = function() { // static
	return LineChartFactory.prototype.instance;
};

/**
 * Creates a new line chart.
 * @param {String} id - the line chart's id;
 * @returns {LineChartImpl} - the created line chart.
 */
LineChartFactory.prototype.createChart = function (id) {
	return new LineChartImpl(id);
};

// Dependency injection:
ChartImpl.registerFactory('linechart' , LineChartFactory.getInstance());
ChartImpl.registerUpdater('linechart:inplace', LineChartInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('linechart:stream', LineChartStreamUpdater.getInstance() );


