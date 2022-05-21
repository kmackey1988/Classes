# There are ten things wrong with this program
#
# Welcome to debugging
# Find and correct the ten problems
# Add comments before each problem stating what the
# problem was and what you did to fix it


#1 needs a colon after the (), colon added.
def main():
    # 2 had a sing quotation instead of double at the end 
    print( "This program calculates the future value")  
    print("of an investment.  You must enter the number of years")
    print("for the investment.")
   
    # 3 added data type
    principal = float(input("Enter the initial principal: "))
    # 4 added data type float
    apr = float(input("Enter the annual interest rate: "))
    # 5 added data type int
    # 6 should not be indented
    # 7 num-years cannot have the "-" changed to "_"
    num_years = int(input("How many years will it be invested: ")) 
    

    for i in range(num_years):
        # 8 should be indented 
        principal = principal * (1 + apr) 
    
    # 9 spelled as principle instead of principal
    # maybe? the word years wasn't with the is so added. it was driving me crazy.
    print("The value in",num_years,"years is:",principal)
  

# 10 added quotation marks
main () 
