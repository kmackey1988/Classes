var http = require('http');
var url = require('url');
var fs = require('fs');

http.createServer(function (req, res) {
    var q = url.parse(req.url, true);
    var path = q.pathname;

    fs.readFile('module11.json', function(err, data) {
        if (err) {
        res.writeHead(404, {'Content-Type': 'text/html'});
        return res.end("404 Not Found");
        } 
        
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write("<ul><li><a href='/1'>Book Number</a></li>");
        res.write("<li><a href='/2'>Book Name</a></li>");
        res.write("<li><a href='/3'>Author</a></li></ul>");
        res.write("<li><a href='/4'>Summary</a></li></ul>");
            
        var myObj, x, y; 
        var myObj = JSON.parse(data);

        if (path == '/1') {
            path = 'Book Number';
            key = 0;
        }

        if (path == '/2') {
            path = 'Book Name';
            key = 1;
        }

        if (path == '/3') {
            path = 'Author';
            key = 2;
        }

        if (path == '/4') {
            path = 'Summary';
            key = 3
        }

        if (path != "/") {
            mybooks = "<table border=1><thead><tr><td>Book Number</td><td>Type</td><td>Book Name</td>" +
                    "<td>Author</td><td>Recovery</td><td>Summary</td></tr></thead>";

            for (x in myObj[path]) {
                mybooks += "<tr>";

            for (y in myObj[x]){
                    mybooks += "<td>" + myObj[x][y] + "</td>";
                 }   
                 mybooks += "</tr>";
               }

        }
        res.write(txt);
        return res.end();
    });
}).listen(8888);