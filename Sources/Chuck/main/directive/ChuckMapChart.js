angular.module('chuck')


.directive('chuckMapchart', ['ChartRequester', function (ChartRequester) {
    return {
        restrict: 'E',
        templateUrl: 'main/view/MapChartView.html',
        link: function(scope, element, attrs) {

            var chartjs = null;

            /*ChartRequester.bind('foo','bar')
                .then(function (chart) {
                    scope.chart = chart;
                    init();
                    scope.$watch('chart', render, true);
                }, function (reason) {
                    console.error(reason);
                });*/

            function init() {
                var lat = 45.4119255;
                var lon = 11.8805467;
                var zoom = 15;

                map = new OpenLayers.Map('demoMap');
                map.addLayer(new OpenLayers.Layer.OSM('pippo'));
             
                var lonLat = new OpenLayers.LonLat(lon,lat)
                      .transform(
                        new OpenLayers.Projection('EPSG:4326'), // transform from WGS 1984
                        map.getProjectionObject() // to Spherical Mercator Projection
                      );



                var markers = new OpenLayers.Layer.Markers("Markers");
                map.addLayer(markers);
                markers.addMarker(new OpenLayers.Marker(lonLat));
             
                map.setCenter(lonLat, zoom);
            };

            init();

            function render(newValue, oldValue) {

            };
        }
    };
}]);