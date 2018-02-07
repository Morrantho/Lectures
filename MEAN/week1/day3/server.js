var http = require('http');
var fs   = require('fs');

var server = http.createServer(function(request,response){
    if(request.url === '/') {
        fs.readFile('index.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});
            response.write(contents);
            response.end();
        });
    }else{
        response.writeHead(404);
        response.end('File not found!!!');
    }
});

server.listen(8000);
