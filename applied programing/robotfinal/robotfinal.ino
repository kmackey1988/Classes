/*
 * Kimberly Mackey
 * cit 227
 * 038/08/2021
 * 
 * 1. A successful robot that automatically navigates with whisker sensors
 * 2. The robot can escape corners
 * 3.The robot only works when there is enough ambient light.
 * 
 * 
 */

 #include <Servo.h>                                   //servo library

Servo servoLeft;                            
Servo servoRight;

//variables for corner loop

int leftWhiskerC;
int rightWhiskerC;
int counter;

void setup()
{

  // pins for whiskers
  pinMode(7, INPUT);           //right
  pinMode(5, INPUT);           //left 

  tone(4, 5000, 500);
  delay(1000);

  leftWhiskerC = 0;
  rightWhiskerC = 1;
  counter = 0;  
}

void loop()
{

  // loop to make bot stop or go with the photocell sensor based off voltage
  if (voltage(A3) < 1.5)
  {
    servoLeft.detach();    // stops servo signals   
    servoRight.detach();
  }
  else 
  {
    servoLeft.attach(13); // sends signal to wheels
    servoRight.attach(12);
  }

  //corner

  int leftWhisker = digitalRead(5);
  int rightWhisker = digitalRead(7);

  if (leftWhisker != rightWhisker)    //one whisker hit
  {
    if ((leftWhisker != leftWhiskerC) && (rightWhisker != rightWhiskerC)) //alternating
    {
      counter++;   //counting 
      leftWhiskerC = leftWhisker;
      rightWhiskerC = rightWhisker;
      if (counter == 4) // it alt back and forth 4 times
      {
        leftWhisker = 0;  // uturn
        rightWhisker = 0;
        counter = 0;  //reset counter
      }
    }
    else
    {
      counter = 0; // clear counter
    }
  }

  //whiskers

  if ((leftWhisker == 0) && (rightWhisker == 0)) // both whiskers hit
  {
    backward(1500);
    rightTurn(1000);
  }
  else if (leftWhisker == 0) //only left hits
  {
    backward(1500);
    rightTurn(800);
  }
  else if (rightWhisker == 0) // only right hits
  {
    backward(1500);
    leftTurn(800); 
  }
  else
  {
    forward(40);
  }
}

//measure voltage
float voltage(int adPin)                        
{                                           
 return float(analogRead(adPin)) * 5.0 / 1024.0; 
}

//movements

void forward(int time)                      
{
  servoLeft.writeMicroseconds(1700);        
  servoRight.writeMicroseconds(1300);        
  delay(time);                               
}

void leftTurn(int time)                      
{
  servoLeft.writeMicroseconds(1300);         
  servoRight.writeMicroseconds(1300);        
  delay(time);                               
}

void rightTurn(int time)                     
{
  servoLeft.writeMicroseconds(1700);         
  servoRight.writeMicroseconds(1700);       
  delay(time);                               
}

void backward(int time)                      
{
  servoLeft.writeMicroseconds(1300);        
  servoRight.writeMicroseconds(1700);        
  delay(time);                               
}
