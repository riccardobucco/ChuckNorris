var DataModel = require('./DataModel');
var InternalAPIManager = require('./InternalAPIManager');
var ExternalAPIManager = require('./ExternalAPIManager');

module.exports = function (server, endpoint, app) {
    var model = new DataModel();
    var internalAPI = new InternalAPIManager(model);
    var externalAPI = ExternalAPIManager.getInstance().construct(model, server, endpoint, app);
    return internalAPI;
}
