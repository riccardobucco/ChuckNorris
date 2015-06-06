angular.module('chuck-libs')
    .factory('GoogleCharts', function ($q) {
        var deferred = $q.defer();

        $.ajax({
            url: 'https://www.google.com/jsapi',
            dataType: 'script',
            cache: true,
            success: function() {
                google.load('visualization', '1', {
                    'packages': ['corechart'],
                    'callback': deferred.resolve
                });
            }
        });

        return deferred.promise;
    });