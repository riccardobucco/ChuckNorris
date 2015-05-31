/*
 * Name: {ChuckBarChart.js}
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
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
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


.directive('chuckBarchart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        templateUrl: 'main/view/BarChartView.html',
        link: function(scope, element, attrs) {

            var chartjs = null;
            
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

                var data = {};
                data.labels = chartData.labels;
                data.datasets = [];
                chartData.datasets.forEach(function (dataset) {
                    var obj = {};
                    obj.data = dataset.values;
                    obj.label = dataset.name;
                    obj.fillColor = 'rgb(' + dataset.color.r + ',' + dataset.color.g + ',' + dataset.color.b + ')';
                    data.datasets.push(obj);
                });

                var options = {};
                    
                var ctx = element.contents()[0].getContext('2d');
                chartjs = new Chart(ctx).Bar(data, options);
            };

            function render(newValue, oldValue) {
                var newData = newValue.getData();
                for(var i = 0; i < newData.datasets.length; i++)
                    for(var j = 0; j < newData.datasets[i].values.length; j++)
                        chartjs.datasets[i].bars[j].value = newData.datasets[i].values[j];

                chartjs.update();
            };
        }
    };
}]);