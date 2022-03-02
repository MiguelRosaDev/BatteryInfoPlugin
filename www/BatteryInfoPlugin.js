var exec = require("cordova/exec");

var PLUGIN_NAME = "BatteryInfoPlugin";

exports.getCapacity = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getCapacity ", []);
};

exports.getStatus = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "getStatus", []);
};
