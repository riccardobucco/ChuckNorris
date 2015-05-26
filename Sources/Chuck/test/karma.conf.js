module.exports = function(config){
  config.set({

    basePath : '../',

    files : [
      'bower_components/angular/angular.js',
      'bower_components/angular-mocks/angular-mocks.js',
      'bower_components/socket.io-client/socket.io.js',
      'bower_components/chartjs/Chart.min.js',
      'bower_components/openlayers/lib/OpenLayers.js',
      'bower_components/jquery/dist/jquery.min.js',
      'bower_components/datatables/media/js/jquery.dataTables.min.js',
      'main/app.js',
      'main/model/norrischart/ChartImpl.js',
      'main/**/*.js',
      'test/unit/*.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome'],

    plugins : [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

  });
};