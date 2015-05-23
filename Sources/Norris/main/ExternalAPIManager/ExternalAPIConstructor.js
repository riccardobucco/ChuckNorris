/**
 * An handle to manage a Norris model
 * @module {ExternalAPIConstructor} ExternalAPIManager/ExternalAPIConstructor
 * @author Davide Dal Bianco
 * @version 0.01
 */

/*
 * Changelog:
 *
 * =============================================================================================
 * Version   Date         Author               Description
 * =============================================================================================
 * 0.01      2015-05-17   Davide Dal Bianco    Creation
 * =============================================================================================
 */

module.exports = ExternalAPIConstructor;


function ExternalAPIConstructor() {
    if(!(this instanceof ExternalAPIConstructor)) return new ExternalAPIConstructor();
};

ExternalAPIConstructor.prototype.construct = function (model, server, endpoint) {

};