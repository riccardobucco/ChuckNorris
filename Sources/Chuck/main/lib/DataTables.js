angular.module('chuck-libs')
    .factory('DataTables', function ($q) {
        var deferred = $q.defer();

        $.ajax({
            url: '/bower_components/datatables/media/js/jquery.dataTables.min.js',
            dataType: 'script',
            cache: true,
            success: deferred.resolve
        });

        return deferred.promise;
    });