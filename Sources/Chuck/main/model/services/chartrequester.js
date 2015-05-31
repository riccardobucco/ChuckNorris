/*
 * Name: {ChartRequester.js}
 * Module: {Model/Services}
 * Location: {Norris/Main/Model/Services}
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
 * 0.03 2015-04-25 Chiara Bigarella   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
 * ================================================================================
 */
angular.module('chuck-requester', ['chuck-chart'])

.factory('ChartRequester', ['ChartImpl','$rootScope', '$timeout', '$q', 'BarChartImpl', 'LineChartImpl', 'MapChartImpl', 'TableImpl', function (ChartImpl, $rootScope, $timeout, $q) {
    return {
        bind: function (endpoint, id) {
            var deferred = $q.defer();

            var hostRegExp = new RegExp(/[\w\.]*(:\d*)?/);
            var host = endpoint.match(hostRegExp)[0];

            var pathRegExp = new RegExp(/\/.*/);
            var path = (endpoint.match(pathRegExp) || ['/'])[0];

            if(path.substr(-1) !== '/') {
                path += '/';
            }

            var socket = io(host + '/' + id, {path: path + 'socket.io'});

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