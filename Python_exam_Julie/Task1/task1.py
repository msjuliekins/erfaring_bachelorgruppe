import random

#global variables so that all functions have access to them
lettersInWord = 0
lines = []
word = ""
guessesRemaining = 0


def readFile():
    global lines
    #open file and read it
    #skips spaces so that words are added correctly to list
    with open("wordGuessing.txt", "r") as file:
        lines = [i.strip().lower() for i in file if i.strip()]

#chooses a random word from list and initiates nr of guesses
def getWord():
    global word, lettersInWord, guessesRemaining
    word = random.choice(lines) 
    word = word.upper() 
    lettersInWord = len(word)
    guessesRemaining = lettersInWord

    
def guess():
    global guessesRemaining
    guessed = ["_"] * len(word)
    #allows user to guess until they are out of attempts
    while guessesRemaining > 0:
        print("Word: " + " ".join(guessed))
        #I change input to uppercase to remove issues with comparing lower and uppercases
        guess = input("Enter a character: ").strip().upper()
        if guess in word:
            for i in range(len(word)):
                if word[i] == guess:
                    #adds a correctly guessed character to proper spot in list
                    guessed[i] = guess
            print("Correct guess")
        else:
            #remove an attempt if wrong guess
            guessesRemaining -= 1
            print(f"Wrong guess. Attempts remaining: {guessesRemaining}")
        if "_" not in guessed:
            print(f"You guessed the whole word. The word was {word}")
            return
    print("Out of attempts. Correct word is: " + word)
    

def main():
    print("This is a word guessing game")
    readFile()
    print("")
    getWord()
    print(f"Your word has {lettersInWord} letters in it")
    guess()
    
main()
    
    