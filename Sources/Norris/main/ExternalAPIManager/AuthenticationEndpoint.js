/*
 * Name: {AuthenticationEndpoint.js}
 * Module: {ExternalAPIManager}
 * Location: {Norris/Main/ExternalAPIManager}
 * Date: {2015-05-24}
 * Version: {v0.04}
 *
 * History:
 *
 * Version Date Programmer Changes
 * ================================================================================
 * 0.04 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * 0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */

var ExternalAPIController = require('./ExternalAPIController.js');
var ExternalAPIConstructor = require('./ExternalAPIConstructor.js');

var express = require('express');
var cookieParser = require('cookie-parser');

/**
 * Creates an AuthenticationEndpoint.
 * @param {ExternalAPIController} controller
 * @returns {AuthenticationEndpoint}
 * @constructor
 */
function AuthenticationEndpoint(controller) {
    if (!(this instanceof AuthenticationEndpoint)) return new AuthenticationEndpoint(controller);
    if (controller instanceof ExternalAPIController) {
        this.controller=controller;
        this.app=express();
        this.app.use(cookieParser());
        this.controller.getServer().on('request', this.app);
        this.app.post(this.controller.getEndpoint() + '/auth/login', this.handleLogin);
        this.app.post(this.controller.getEndpoint() + '/auth/logout', this.handleLogout);
        this.app.post(this.controller.getEndpoint() + '/auth/keepalive', this.handleKeepAlive);
    }else {
        this.controller=null;
        this.app=null;
        console.log("ERROR: an ExternalAPIController is required.")
    }
}

/**
 * Manages an authentication request
 * @param {express::request} req
 * @param {express::response} res
 */
AuthenticationEndpoint.prototype.handleLogin = function(req, res) {
    var cookies = {
        get: req.cookies,
        getSigned: req.signedCookies,
        set: res.cookie,
        clear: res.clearCookie
    };
    var query = querystring.parse();
    if(!query.username || !query.password)
        res.sendStatus(400);
    else if(!this.controller.handleLogin(cookies, query.username, query.password))
        res.sendStatus(401);
    else
        res.sendStatus(200);
};

/**
 * Manages an end-session request
 * @param {express::request} req
 * @param {express::response} res
 */
AuthenticationEndpoint.prototype.handleLogout = function(req, res) {
    var cookies = {
        get: req.cookies,
        getSigned: req.signedCookies,
        set: res.cookie,
        clear: res.clearCookie
    };
    else if(!this.controller.handleLogout(cookies))
        res.sendStatus(401);
    else
        res.sendStatus(200);
};

/**
 * Manages a request in order to renew an activated session
 * @param {express::request} req
 * @param {express::response} res
 */
AuthenticationEndpoint.prototype.handleKeepAlive = function(req, res) {
    var cookies = {
        get: req.cookies,
        getSigned: req.signedCookies,
        set: res.cookie,
        clear: res.clearCookie
    };
    else if(!this.controller.handleKeepAlive(cookies))
        res.sendStatus(401);
    else
        res.sendStatus(200);
};



/* AuthenticationEndpointFactory ------------------------------------------------------- */

/**
 * Creates a new AuthenticationEndpointFactory.
 * @constructor
 */
function AuthenticationEndpointFactory() {
    if(!(this instanceof AuthenticationEndpointFactory)) {
        return new AuthenticationEndpointFactory();
    }
}

AuthenticationEndpointFactory.prototype.instance=new AuthenticationEndpointFactory(); // static

/**
 * Gets the AuthenticationEndpointFactory's instance.
 * @returns {AuthenticationEndpointFactory} the factory's instance.
 */
AuthenticationEndpointFactory.getInstance = function() { // static
    return AuthenticationEndpointFactory.prototype.instance;
};

/**
 * Creates a new AuthenticationEndpoint.
 * @param {ExternalAPIController} controller - ;
 * @returns {AuthenticationEndpoint} - the created endpoint.
 */
AuthenticationEndpointFactory.prototype.createEndpoint = function (controller) {
    return new AuthenticationEndpoint (controller);
};

// Dependency injection:
ExternalAPIConstructor.registerEndpoint(AuthenticationEndpointFactory.getInstance());