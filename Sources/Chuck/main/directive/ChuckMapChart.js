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
            var layers = null;

            ChartRequester.bind('foo','bar')
                .then(function (chart) {
                    scope.chart = chart;
                    init();
                    scope.$watch('chart', render, true);
                }, function (reason) {
                    console.error(reason);
                });

            function init() {
                var settings = scope.chart.getSettings();

                var lon = settings.centerCoordinates.x;
                var lat = settings.centerCoordinates.y;
                var zoom = settings.area;

                map = new OpenLayers.Map('demoMap');
                map.addLayer(new OpenLayers.Layer.OSM('OSM'));
             
                var lonLat = new OpenLayers.LonLat(lon,lat)
                    .transform(
                        new OpenLayers.Projection('EPSG:4326'), // transform from WGS 1984
                        map.getProjectionObject() // to Spherical Mercator Projection
                    );
             
                map.setCenter(lonLat, zoom);
            };

            init();

            function render(newValue, oldValue) {
                if(map) {
                    var newData = newValue.getData();

                    if(layers) {
                        layers.forEach(function (layer) {
                            map.removeLayer(layer);
                        });
                    }

                    layers = [];

                    newData.forEach(function (dataset) {
                        var markers = new OpenLayers.Layer.Markers( "Markers" );

                        dataset.values.forEach(function (value) {
                            var lonLat = new OpenLayers.LonLat( 11.72 ,44.35 )
                                .transform(
                                    new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
                                    map.getProjectionObject() // to Spherical Mercator Projection
                                );
                            markers.addMarker(new OpenLayers.Marker(lonLat));
                        });

                        map.addLayer(markers);
                    });
                }

            };



            markers.addMarker(new OpenLayers.Marker(markerslonLat));
        }
    };
}]);