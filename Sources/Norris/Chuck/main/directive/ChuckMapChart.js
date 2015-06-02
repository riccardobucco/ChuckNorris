/*
 * Name: {ChuckMapChart.js}
 * Module: {Directive}
 * Location: {Chuck/Main/Directive}
 * Date: {2015-04-10}
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
 * =================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Carlon Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Chiara Bigarella   Creation
 * ================================================================================
 */
 angular.module('chuck')


.directive('chuckMapchart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        scope: {},
        templateUrl: 'main/view/MapChartView.html',
        link: function(scope, element, attrs) {

            var map = null;
            var layers = [];

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

                var lon = settings.area.x;
                var lat = settings.area.y;
                var zoom = settings.area.zoom;

                map = new OpenLayers.Map(element.contents()[0]);

                map.addLayer(new OpenLayers.Layer.OSM('OSM'));

                var lonLat = new OpenLayers.LonLat(lon,lat)
                    .transform(
                        new OpenLayers.Projection('EPSG:4326'),
                        map.getProjectionObject()
                    );

                map.setCenter(lonLat, zoom);
            };

            function render(newValue, oldValue) {
                if(map) {
                    var newData = newValue.getData();

                    layers.forEach(function (layer) {
                        map.removeLayer(layer);
                    });

                    layers = [];

                    newData.forEach(function (dataset) {
                        var markers = new OpenLayers.Layer.Markers('Markers');

                        dataset.values.forEach(function (value) {
                            var lonLat = new OpenLayers.LonLat(value.x, value.y)
                                .transform(
                                    new OpenLayers.Projection("EPSG:4326"),
                                    map.getProjectionObject()
                                );
                            console.log(lonLat);
                            markers.addMarker(new OpenLayers.Marker(lonLat));
                        });

                        map.addLayer(markers);
                        layers.push(markers);
                    });
                }
            };

        }
    };
}]);