var DataModel = require('./DataModel');
var InternalAPIManager = require('./InternalAPIManager');
//var ExternalAPIManager = require('./ExternalAPIManager');

module.exports = function (server, endpoint) {
    var model = new DataModel();
    var internalAPI = new InternalAPIManager(model);
    //var externalAPI = ExternalAPIManager.getInstance().construct(model, server, endpoint);
    return internalAPI;
}