angular.module('chuck')


.directive('chuckBarchart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        templateUrl: 'main/view/BarChartView.html',
        link: function(scope, element, attrs) {

            var chartjs = null;

            ChartRequester.bind('foo','bar')
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

                var options = {}
                    
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