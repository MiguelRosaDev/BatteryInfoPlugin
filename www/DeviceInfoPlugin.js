var exec = require("cordova/exec");

var PLUGIN_NAME = "Idfa";

exports.getInfo = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getInfo ", []);
};

exports.requestPermission = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "requestPermission", []);
};
