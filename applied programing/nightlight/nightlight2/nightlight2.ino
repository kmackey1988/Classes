
 int sensor = 0;
 int base;
 int threshold = 100;

 void setup() {
   pinMode(7, OUTPUT);
   pinMode(sensor, INPUT);
   base = analogRead(sensor);
 }

 
 void loop() {
   int newRead = analogRead(sensor);
   if ((base - newRead) > threshold) {
     digitalWrite(7, HIGH);
   } else {
     digitalWrite(7, LOW);
   }
 }
