// create an http server.
var http = require('http');

// Code HTTP server to respond.
var server = http.createServer(function (request, response) {
  response.writeHead(200, {"Content-Type": "text/plain"});
  response.end("Hello World! Node. js is a platform built on JavaScript, built for a fast network applications. url https://howtonode.org/hello-node\n");
});

// Listen on port 8000, IP defaults to 127.0.0.1
server.listen(8000);

// message on the terminal
console.log("Server running at http://127.0.0.1:8000/");
