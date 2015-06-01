/*
 * Name: {ChuckTable.js}
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
 * 0.04 2015-04-27 Bigarella Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */
angular.module('chuck')


.directive('chuckTable', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        scope: {},
        templateUrl: 'main/view/TableView.html',
        link: function(scope, element, attrs) {

            var table = null;

            ChartRequester.bind(attrs.chartEndpoint,attrs.chartId)
                .then(function (chart) {
                    scope.chart = chart;
                    init();
                    scope.$watch('chart', render, true);
                }, function (reason) {
                    console.error(reason);
                });

            function init() {
                var data = scope.chart.getData();
                var info = {};

                info.columns = [];
                data.headers.forEach(function (header) {
                    info.columns.push({title: header});
                });

                info.data = [];

                table = $(element.contents()[0]).DataTable(info);
            };

            function render(newValue, oldValue) {
                var newData = newValue.getData();

                table.rows().remove();
                newData.datasets.forEach(function (dataset) {
                    var row = [];
                    dataset.forEach(function (item) {
                        row.push(item.value);
                    });
                    table.row.add(row);
                });


                table.draw();
            };
        }
    };
}]);