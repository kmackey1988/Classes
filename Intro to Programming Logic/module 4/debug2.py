# debug2.py
# There are ten bugs in this program (depending on how you count)
# find and squash all ten bugs and comment your solutions

# This function calculates the sum of
# positive integers up to AND INCLUDING 'n'

def sum():
    n = int(input("Enter a whole number: "))
    
   # for i in range(n): 0. we dont need this line, since n is already identified as an int.
    sum = (n * ( n + 1) ) /2 #1formular is incorrect to get the sum of all positive intagers. 

    print("The triangular number of ",n, "is", sum) #2a factorial is when numbers are multiplied this is a triangular number
    #3. was an x in print, there should only be an n and sum since x was undefined. 

sum() #5 this was at the bottom of the page but should be before the next function. 
#6 said main instead of sum

# This function calculates the length of the hypotenuse
# of a right triangle
#
# It solves the formula a^2 + b^2 = c^2
# where a and b are the lengths of the sides
# and c is the length of the hypotenuse

def hypotenuse():
    from math import sqrt #7 sqrt was defined, this needs to be added to define it
    a = int(input("Enter the length of side a: "))
    b = int(input("Enter the length of side b: "))

    c = sqrt(a**2 + b**2) #8 should be two asterisks for the powers
    print("The length of the hypotenuse  is:", c) #9 should be c instead of the word hypotenuse 
hypotenuse() #10 function needs to be closed out. 