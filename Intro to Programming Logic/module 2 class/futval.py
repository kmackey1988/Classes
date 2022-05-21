#input: amount invested, (principal) interest rate
#output: future falue 
#3processing: value after one year = principal * (1+apr) apply 10 times.

def main():

    apr = eval(input("what is the interest rate for the investment as a decimal percentage: "))
    monthly_rate = apr / 12
    principal = eval(input("How much is being invested: "))
    contribution =eval(input("how much will be contributed each month: "))
    years = eval(input("how many years: "))

    for i in range(years*12):
        principal = (contribution + principal) * (1 + monthly_rate)

    print(principal)

main()

