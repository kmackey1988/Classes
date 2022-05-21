#kimberly mackey 
#rount_things
#09/20/2020

#Write a program to calculate the volume and surface area of a sphere from its radius, given as input. Here are some formulas that might be useful:

#V space equals space 4 divided by 3 pi r cubed

#A space equals space 4 pi r squared

#Instead of defining the program as "main", call it "sphere".  
# Then make sure instead of calling main() you call sphere(). 
#  This will be yet another IPO program.  Get the radius of the sphere
#  from the user input, process the two calculations using the formulae
#  provided, then output (print) the results.  Label the resulting values
#  when you print them.  


def sphere():
    print("This program finds the volume and surface area of a sphere")

    import math
    pi = math.pi

    r = float(input("Please enter the radius of the sphere in cm: "))
    

    a = (4 * pi * r**2)
    v = ((4 * pi * r**3) / 3)

    print()
    print("The volume of the sphere is", v, "cubic cm",)
    print("The area of the sphere is", a, "square cm")
sphere()

#Write a program that calculates the cost per square inch of a circular 
# pizza.  The user will give the diameter of the pizza and its total price. 
# The formula for the area of a circle is:

# A  equals pi r squared
#"pizza".  Then make sure to call pizza() instead of main(). 
#Again, this will be an IPO pattern.  You will get two things 
# from the user: the diameter of the pizza and the price of the pizza. 
#   You will then process the formula for area, then another formula to 
# calculate the cost per square inch.  Then output the results.

def pizza():
    print("This program finds the cost per square inch of a circular pizza")

    import math
    pi = math.pi

    diameter = float(input("Please enter the diameter of the pizza: "))
    cost = float(input("Please enter the price of the pizza: "))

    r = diameter / 2
    area = (pi * r**2)

    print("The cost per square inch of the pizza is", round(cost/area, 2), "cents")

pizza()