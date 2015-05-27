/*
 * Name: {ChuckAuthenticator.js}
 * Module: {Model/Services}
 * Location: {Chuck/Main/Model/Services}
 * Date: {2015-04-12}
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
 * ================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */
angular.module('chuck')

.factory('ChuckAuthenticator', ['$http', function ($http) {

    return {
        /*login: function (endpoint, username, password) {
            return $http.post(endpoint + '/auth/login', 'username=' + username '&password=' + password);
        },
        keepAlive: function (endpoint) {
            return $http.post(endpoint + '/auth/keepalive', '');
        },
        logout: function (endpoint) {
            return $http.post(endpoint + '/auth/logout', '');
        }*/
    };

}]);