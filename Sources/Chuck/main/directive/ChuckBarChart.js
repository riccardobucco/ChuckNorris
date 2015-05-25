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
                    console.log(reason);
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

            setTimeout(function () {
                chartjs.scale.xLabels.push('pippo');
                chartjs.scale.xLabels.shift();
            }, 8000)

            function render() {


                chartjs.update();
            };
        }
    };
}]);