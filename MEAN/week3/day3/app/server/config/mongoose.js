let mongoose = require('mongoose');
let fs = require('fs');
let path = require('path');
let models = path.join(__dirname, '../models');
mongoose.connect('mongodb://localhost/products_categories');

fs.readdirSync(models).forEach(function(file) {
	if(file.indexOf('.js') >= 0) {
		require(models + '/' + file);
	}
});
