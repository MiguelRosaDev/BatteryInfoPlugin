var exec = require("cordova/exec");

var PLUGIN_NAME = "DeviceInfoPlugin";

exports.Helloworld = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "Helloworld ", []);
};

exports.Getbatterypercent = function (resolve, reject) {
  exec(resolve, reject, PLUGIN_NAME, "Getbatterypercent", []);
};
