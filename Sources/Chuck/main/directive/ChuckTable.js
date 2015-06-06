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


.directive('chuckTable', ['ChartRequester', 'DataTables', function (ChartRequester, DataTables) {
    return {
        restrict: 'E',
        scope: {},
        templateUrl: '/bower_components/chuck-rtc/main/view/TableView.html',
        link: function(scope, element, attrs) {

            DataTables.then(function () {
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
                    var settings = scope.chart.getSettings();
                    var data = scope.chart.getData();
                    var info = {};

                    info.columns = [];
                    info.columns.push({title: '_ordering'})
                    data.headers.forEach(function (header) {
                        info.columns.push({title: header});
                    });

                    info.data = [];
                    info.bFilter = settings.allowFilter;
                    info.bSort = settings.allowSort;
                    info.bPaginate = settings.allowPaginate;

                    var tableElement = $(element.contents()[0]);
                    if(settings.showTableGrid) {
                        tableElement.addClass('table');
                        tableElement.addClass('table-striped');
                    } else {
                        tableElement.addClass('nowrap');
                    }
                    table = tableElement.DataTable(info);


                    table.column(0).visible(false);
                };

                function render(newValue, oldValue) {
                    var newData = newValue.getData();

                    table.rows().remove();

                    for (var i = 0; i < newData.datasets.length; i++) {
                        var row = [];
                        row.push(i);
                        newData.datasets[i].forEach(function (item) {
                            row.push(item.value);
                        });
                        table.row.add(row);
                    }

                    table.cells().every(function () {
                        var row = this.index().row;
                        var column = this.index().column - 1;
                        if(column >= 0) {
                            if(newData.datasets[row][column].color)
                                $(this.node()).css('color', newData.datasets[row][column].color);
                            if(newData.datasets[row][column].background)
                                $(this.node()).css('background-color', newData.datasets[row][column].background);
                        }
                    });

                    table.draw();
                };
            });
        }
    };
}]);