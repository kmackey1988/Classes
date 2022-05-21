def main():
    print("This program calculates the future value")
    print("of a multi-year investement.")
    
    principal = float(input("Enter the initial principal: "))
    apr = float(input("Enter the annual interest rate: "))
    numyears = int(input("Enter the number of years the investment will be held: "))
    
    for i in range(numyears):
        principal = principal * (1 + apr)
    
    print(" The value in ", numyears ," years is: ", principal)
    

main()