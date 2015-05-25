angular.module('chuck')


.directive('chuckMapchart', ['ChartRequester', function (ChartRequester) {
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
                
            };

            function render(newValue, oldValue) {
                
            };
        }
    };
}]);