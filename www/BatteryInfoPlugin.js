var exec = require("cordova/exec");

var PLUGIN_NAME = "BatteryInfoPlugin";

exports.getPercentage = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getPercentage ", []);
};

exports.getStatus = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getStatus", []);
};
