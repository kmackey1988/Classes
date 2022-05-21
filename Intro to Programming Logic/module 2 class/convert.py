
'''
Kimberly Mackey
09/06/2020
convert.py
cit232
This program allows you to convert celsius into fahrenheit five times
then allows you to convert ounces into cups once.
'''
def main():
    
    for i in range(5):
        celsius = eval(input("enter the temp in celsius: "))
        fahrenheit = (9/5) * celsius + 32 
        print("the temperature in farenheit is:", fahrenheit) 

    ounces = eval(input("Enter how many ounces you have?: "))  
    cups = ounces * 0.125
    print("This number you have is:", cups)  

main() 