angular.module('chuck')

.factory('ChuckAuthenticator', ['$http', function ($http) {

    return {
        login: function (endpoint, username, password) {
            return $http.post(endpoint + '/auth/login', 'username=' + username '&password=' + password);
        },
        keepAlive: function (endpoint) {
            return $http.post(endpoint + '/auth/keepalive', '');
        },
        logout: function (endpoint) {
            return $http.post(endpoint + '/auth/logout', '');
        }
    };

}]);