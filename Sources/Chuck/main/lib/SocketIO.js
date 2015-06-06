angular.module('chuck-libs')
    .factory('SocketIO', function ($q) {
        var deferred = $q.defer();

        $.ajax({
            url: '/bower_components/socket.io-client/socket.io.js',
            dataType: 'script',
            cache: true,
            success: deferred.resolve
        });

        return deferred.promise;
    });