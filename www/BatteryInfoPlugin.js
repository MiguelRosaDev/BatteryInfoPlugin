var exec = require("cordova/exec");

var PLUGIN_NAME = "BatteryInfoPlugin";

exports.getPercentage = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getPercentage", []);
};

exports.getChargindStatus = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getChargindStatus", []);
};

exports.gethealthStatus = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "gethealthStatus", []);
};
