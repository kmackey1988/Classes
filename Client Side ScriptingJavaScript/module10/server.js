//In a file named server.js, define a Server object with the following properties and methods:
//hostname
//ip address
//operating system
//list of running services such as mail, web, database, etc (use an array/list)
//whether or not the server is up
//a Constructor method
//a method called "infoTable" that returns a small, two column HTML table displaying this server's information
//In the same server.js file, create three instances of the Server object with different information
//In a .html file, add the following:
//include the server.js file
//Create a option/select (dropdownbox) or radio buttons that will allow you to select one of the three servers
//create a section element with an id
//Write a function that takes a server as a parameter and sets the HTML of the section element to the text produced by the server's "infoTable" method
//Modify the option/select or radio button to use an "onchange" or "onselect" Event that calls the previous function





//create main server
function Server(name, address, os, services = []) {
    this.hostname = name;
    this.ipAddress = address;
    this.operatingSystem = os;
    this.runningServices = services;
    this.serveractive = true;
    // create table
    this.infoTable = function () {
        var active = this.serveractive.toString();
        return (
        "<table>" + 
        "<tr><th>Name</th><th>Status</th></tr>" +
        "<tr><td>Host Name:</td><td>" + this.hostname + "</td></tr>" +
        "<tr><td>IP address:</td><td>" + this.ipAddress + "</td></tr>" +
        "<tr><td>OS:</td><td>" + this.operatingSystem + "</td></tr>" +
        "<tr><td>Services Running:</td><td>" + services + "</td></tr>" +
        "<tr><td>Server Active:</td><td>" + this.active + "</td></tr>" +
        "</table>");
    }
}
// defines serveractive is true
Object.defineProperty(Server.prototype, 'active', {
    get: function() {
        return this.serveractive;
    },
    set: function(active) {
        return this.serveractive = active;
    }
});

// make 3 servers
var server1 = new Server(location.hostname, "24.140.210.27", "Windows 10", ['database', 'web', 'mail', 'files']);
var server2 = new Server("www.cit215.com", "31.214.369.19", "MacOS 	10.15.7", ['drive', 'web','images', 'files']);
var server3 = new Server(location.hostname, "29.215.369.24", "Windows 7", ['files', 'database']);



// select server from select memu and calls the server info into table
function ServerSelection(server) {
    var index = document.getElementById('displayserver').selectedIndex;
    var displayserver = document.getElementById('displayserver').value;
    var server = server;

    if (index == 0) {
        document.getElementById('server').innerHTML = "";
        console.log(displayserver);
        return;
    }
    if (displayserver == "server1") {
        server = server1;
    }  
    if (displayserver == "server2") {
        server = server2;
    }    
    if (displayserver == "server3") {
        server = server3;
    } 
    document.getElementById('server').innerHTML = server.infoTable();
    console.log(server);
}

