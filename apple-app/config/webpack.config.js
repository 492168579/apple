var chalk = require("chalk");
var fs = require('fs');
var path = require('path');
var useDefaultConfig = require('@ionic/app-scripts/config/webpack.config.js');

var env = process.env.IONIC_ENV;

console.log("当前环境为："+env);

useDefaultConfig.prod.resolve.alias = {
  "@app/env": path.resolve(environmentPath('prod'))
};

useDefaultConfig.dev.resolve.alias = {
  "@app/env": path.resolve(environmentPath('dev'))
};

if (env !== 'prod' && env !== 'dev') {
  useDefaultConfig[env] = useDefaultConfig.dev;
  useDefaultConfig[env].resolve.alias = {
    "@app/env": path.resolve(environmentPath(env))
  };
}

function environmentPath(env) {
  var filePath = './src/environments/environment' + (env === 'dev' ? '' : '.' + env) + '.ts';
  if (!fs.existsSync(filePath)) {
    console.log(chalk.red('\n' + filePath + ' does not exist!'));
  } else {
    return filePath;
  }
}

module.exports = function () {
  return useDefaultConfig;
};