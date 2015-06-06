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


.directive('chuckMapchart', ['ChartRequester', 'OpenLayers', function (ChartRequester, OpenLayers) {
    return {
        restrict: 'E',
        scope: {},
        templateUrl: '/bower_components/chuck-rtc/main/view/MapChartView.html',
        link: function(scope, element, attrs) {

            OpenLayers.then(function () {

                var map = null;
                var overlays = [];

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

                    map = new ol.Map({
                        controls: ol.control.defaults(),
                        layers: [
                            new ol.layer.Tile({
                                source: new ol.source.OSM()
                            })
                        ],
                        target: 'map',
                        view: new ol.View({
                            center: ol.proj.transform([lon, lat], 'EPSG:4326', 'EPSG:3857'),
                            zoom: zoom
                        })
                    });

                };

                function render(newValue, oldValue) {
                    var newData = newValue.getData();

                    overlays.forEach(function (overlay) {
                        map.removeOverlay(overlay);
                    });
                    overlays = [];

                    newData.forEach(function (dataset) {
                        dataset.values.forEach(function (value) {

                            var icon = document.createElement('object');
                            icon.type = 'image/svg+xml';
                            icon.data = '/marker.svg';
                            if(dataset.color) {
                                icon.addEventListener('load', function () {
                                    icon.contentDocument.getElementsByTagName('svg')[0].setAttribute('style','fill: ' + dataset.color);
                                });
                            }

                            var overlay = new ol.Overlay({
                                element: icon,
                                position: ol.proj.transform([value.x, value.y], 'EPSG:4326', 'EPSG:3857'),
                                positioning: 'bottom-center'
                            });
                            map.addOverlay(overlay);
                            overlays.push(overlay);
                        });
                    });
                    

                };

            });

        }
    };
}]);