angular.module('chuck')


.directive('chuckLinechart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        templateUrl: 'main/view/LineChartView.html',
        link: function(scope, element, attrs) {

            var chartjs = null;
            var ctx = element.contents()[0].getContext('2d');

            ChartRequester.bind('foo','bar')
                .then(function (chart) {
                    scope.chart = chart;
                    init();
                    scope.$watch('chart', render, true);
                }, function (reason) {
                    console.error(reason);
                });

            function init() {};

            function render(newValue, oldValue) {
                var chartData = scope.chart.getData();
                var chartSettings = scope.chart.getSettings();

                var data = {};
                data.labels = chartData.labels;
                data.datasets = [];
                chartData.datasets.forEach(function (dataset) {
                    var obj = {};
                    obj.data = dataset.values;
                    obj.label = dataset.name;
                    obj.strokeColor = 'rgb(' + dataset.color.r + ',' + dataset.color.g + ',' + dataset.color.b + ')';
                    obj.pointColor = 'rgb(' + dataset.color.r + ',' + dataset.color.g + ',' + dataset.color.b + ')';
                    data.datasets.push(obj);
                });

                var options = {
                    datasetFill: false
                }

                if(chartjs) chartjs.destroy();
                chartjs = new Chart(ctx).Line(data, options);
            };
        }
    };
}]);