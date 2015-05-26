angular.module('chuck-requester', ['chuck-chart'])

.factory('ChartRequester', ['ChartImpl','$rootScope', '$timeout', '$q', 'BarChartImpl', 'LineChartImpl', 'MapChartImpl', 'TableImpl', function (ChartImpl, $rootScope, $timeout, $q) {
    return {
        bind: function (endpoint, id) {
            var deferred = $q.defer();

            var socket = io.connect('localhost:9000/bar');

            socket.on('chart', function (type, settings, data) {
                var chart = ChartImpl.createChart(type, id);
                chart.setSettings(settings);
                chart.setData(data);
                socket.on('update', function (updateType, updateData) {
                    $rootScope.$apply(function () {
                        chart.update(updateType, updateData);
                    });
                });
                deferred.resolve(chart);
            });

            $timeout(function () {
                deferred.reject('timeout');
            }, 3000);

            return deferred.promise;
        }
    };
}]);