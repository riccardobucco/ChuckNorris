var DataModel = require('./DataModel');
var InternalAPIManager = require('./InternalAPIManager');
var ExternalAPIManager = require('./ExternalAPIManager');

module.exports = function (server, endpoint, app) {
    if (endpoint == '') {
       endpoint = '/';
    }
    var model = new DataModel(endpoint);
    var internalAPI = new InternalAPIManager(model);
    var externalAPI = ExternalAPIManager.getInstance().construct(model, server, app);
    return internalAPI;
}
