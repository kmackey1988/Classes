
#kimberly Mackey
#10/06/2020

#This program calculates the average word length, counts lines,
# and the total number of characters, and words 
def main():
    infile = open('cw.txt', 'r') #open file
    data = infile.read()


    #prepare the output list
    words = []
    letter = 0
    #create loop to split tje data to be counted 
    for string in data.split():
        x = string[0] #create variable to store the first letter from each word
        words.append(x) 
        letter = len(string) + letter
        wordAvg = letter / (len(words))
    infile.close() #close file.

    infile = open('cw.txt', "r")   # open file to start next act 
    fileLines = infile.readlines() #read lines instead of words

    lines = []
    for line in fileLines:
        lines.append(line) #loop to count lines
    
    #print all line
    print("There number of lines in the file is: ", len(lines))

    #print info from previous loop 
    print("The avg word length is: ", wordAvg)
    print("The total number of letters is: ", letter)
    print("The number of words is: ", len(words))
    infile.close() # close fidle 
main()