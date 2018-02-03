var path = require('path');

module.exports = {
    entry: {
        app:[
            './src/main/resources/static/js/Projects.js',
            './src/main/resources/static/js/Users.js',
            './src/main/resources/static/js/App.js',
        ]
    },

    devtool: 'sourcemaps',
    cache: true,
    debug: true,

    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },

    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};