angular.module('chuck-libs')
    .factory('OpenLayers', function ($q) {
        var deferred = $q.defer();

        $.ajax({
            url: 'http://openlayers.org/en/v3.5.0/build/ol.js',
            dataType: 'script',
            cache: true,
            success: deferred.resolve
        });

        return deferred.promise;
    });