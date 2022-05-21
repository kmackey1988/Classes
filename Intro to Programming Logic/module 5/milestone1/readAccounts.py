
#kimberly Mackey
#10/04/2020
#cit232
#program to insert bank account infomation and add 10 dollars to current funds

def main():
    import csv

#input - accessing csv file and rewriting a new one
    infile = open('accounts.csv','r')
    outfile = open('adjustedaccounts.csv' , 'w')
    

    
    f_read = csv.reader(infile, delimiter=',') #seperates values
    
   
    for line in f_read:
        
        # accountbalance is line[3] and use float since bank accounts can use decimals
        accountBalance = float(line[3])
        accountBalance += 10   #add 10 dollars to the balance
        line[3] = str(accountBalance)

        print(line, file=outfile) #print new file with extra 10 in balance

    infile.close()
    outfile.close()

main()