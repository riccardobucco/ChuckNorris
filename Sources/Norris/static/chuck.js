(function () {
    var scripts = document.getElementsByTagName('script');
    var path = scripts[scripts.length-1].src.split('?')[0];
    var chuckdir = path.split('/').slice(0, -1).join('/')+'/';

    var SCRIPTS = [
        chuckdir + 'bower_components/angular/angular.min.js',

        chuckdir + 'bower_components/socket.io-client/socket.io.js',
        'https://www.google.com/jsapi',
        /*'<script type="text/javascript">
            google.load('visualization', '1.0', {'packages':['corechart']});
            google.setOnLoadCallback(function () {angular.bootstrap(document.body, ['chuck'])});
        </script>'*/
        chuckdir + 'bower_components/openlayers/lib/OpenLayers.js',
        chuckdir + 'bower_components/jquery/dist/jquery.min.js',
        chuckdir + 'bower_components/datatables/media/js/jquery.dataTables.min.js',
        chuckdir + 'bower_components/bootstrap/dist/js/bootstrap.min.js',

        chuckdir + 'main/app.js',

        chuckdir + 'main/model/services/ChartRequester.js',
        chuckdir + 'main/model/services/ChuckAuthenticator.js',

        chuckdir + 'main/directive/ChuckBarChart.js',
        chuckdir + 'main/directive/ChuckLineChart.js',
        chuckdir + 'main/directive/ChuckMapChart.js',
        chuckdir + 'main/directive/ChuckTable.js',

        chuckdir + 'main/model/norrischart/ChartImpl.js',
        chuckdir + 'main/model/norrischart/BarChartImpl.js',
        chuckdir + 'main/model/norrischart/LineChartImpl.js',
        chuckdir + 'main/model/norrischart/MapChartImpl.js',
        chuckdir + 'main/model/norrischart/TableImpl.js',

        chuckdir + 'main/model/norrischart/BarChartInPlaceUpdater.js',
        chuckdir + 'main/model/norrischart/LineChartInPlaceUpdater.js',
        chuckdir + 'main/model/norrischart/LineChartStreamUpdater.js',
        chuckdir + 'main/model/norrischart/MapChartInPlaceUpdater.js',
        chuckdir + 'main/model/norrischart/MapChartMovieUpdater.js',
        chuckdir + 'main/model/norrischart/TableInPlaceUpdater.js',
        chuckdir + 'main/model/norrischart/TableStreamUpdater.js'
    ]

    SCRIPTS.forEach(function (path) {
        document.write('<script type="text/javascript" src="' + path + '"></script>');
    });
})()