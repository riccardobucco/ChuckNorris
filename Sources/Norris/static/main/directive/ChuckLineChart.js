/*
 * Name: {ChuckLineChart.js}
 * Module: {Directive}
 * Location: {Chuck/Main/Directive}
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
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */
angular.module('chuck')


.directive('chuckLinechart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        scope: {},
        templateUrl: '/main/view/linechartView.html',
        link: function(scope, element, attrs) {

            var linechart = null;
            var options = {};

            ChartRequester.bind(attrs.chartEndpoint,attrs.chartId)
                .then(function (chart) {
                    scope.chart = chart;
                    init();
                    scope.$watch('chart', render, true);
                }, function (reason) {
                    console.error(reason);
                });

            function init() {
                var chartData = scope.chart.getData();
                var chartSettings = scope.chart.getSettings();

                options.animation = {
                    duration: chartSettings.style.animationDuration,
                    easing: 'inAndOut',
                    startup: true
                };

                options.hAxis = {
                    title: chartSettings.xLabel
                };

                options.vAxis = {
                    title: chartSettings.yLabel
                };

                options.legend = {
                    position: chartSettings.legendPosition
                };

                options.series = {};
                for (var i = 0; i < chartData.datasets.length; i++) {
                    if(chartData.datasets[i].color) {
                        options.series[i.toString()] = {
                            color: '#' + 
                            ('0' + chartData.datasets[i].color.r.toString(16)).slice(-2) +
                            ('0' + chartData.datasets[i].color.g.toString(16)).slice(-2) +
                            ('0' + chartData.datasets[i].color.b.toString(16)).slice(-2)
                        }
                    }
                }

                if(chartSettings.showGrid) {
                    options.hAxis.gridlines = {
                        count: -1
                    };
                    options.vAxis.gridlines = {
                        count: -1
                    }
                } else {
                    options.hAxis.gridlines = {
                        count: 2
                    };
                    options.vAxis.gridlines = {
                        count: 2
                    }
                }

                options.pointSize = chartSettings.style.pointDotSize;

                if(chartSettings.style.bezierCurve) {
                    options.curveType = 'function';
                }

                linechart = new google.visualization.LineChart(element.contents()[0]);
            };

            function render(newValue, oldValue) {
                var newData = newValue.getData();

                var data = new google.visualization.DataTable();

                data.addColumn('string', 'headers');
                newData.datasets.forEach(function (dataset) {
                    data.addColumn('number', dataset.name || 'unknow');
                });

                for(var i = 0; i < newData.labels.length; i++) {
                    var row = [];
                    row.push(newData.labels[i]);
                    newData.datasets.forEach(function (dataset) {
                        row.push(dataset.values[i]);
                    });
                    data.addRow(row);
                }

                linechart.draw(data, options);
            };
        }
    };
}]);