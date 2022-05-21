#Kimberly Mackey 
#09/27/2020
#chapter5.py
#File contains a grade converter and an acronym generator.



def grade():
    #get letter grade when put in number that was recieved on as quiz score

    #input
    numscore = int(input("What number score did you recieve(1-5)? "))
     
    
    #processing
    lettergrade = ('F','F','D','C','B','A')
    grade = lettergrade[numscore]
    #output 
    print(grade)

grade()




def acronym():
    #turn words/phrase into an acronym.

    #input
     words = input("Enter in words/phrase you want to convert to an acronym: ")
     
     #processing
     words = words.upper()
     word_list = words.split()

     #output
     for i in word_list:
       print(i[0], end='')
       print()



acronym()