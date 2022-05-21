 /*Kimberly Mackey 
  cit 215
  09/27/2020*/

var computer = {
    make : "HP",
    model  : "15-bs013dx",
    cpu     : "Intel Core i3",
    cpu_frequency  : "2.4 GHz",
    memory : "8 GB",
    color : "Black",
  };


computer.gpumake_model = "HP Pavillion";
computer.disk_space = "1000GB";


cpu_frequency = "2.5 GHz";

computer['memory'] = "914 GB";

delete computer.color;

for (var key in computer) {
    if (computer.hasOwnProperty(key)) {
        console.log(key + "  " + computer[key]);
    }
}

 