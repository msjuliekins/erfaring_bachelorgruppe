# Candidate nr: 396

# https://www.geeksforgeeks.org/python-program-for-word-guessing-game/      
# https://www.geeksforgeeks.org/hangman-game-python/?utm_source=auth&utm_medium=saved&utm_campaign=articles
# https://www.geeksforgeeks.org/python-select-random-value-from-a-list/

import random

def main():
    guess_word()

"""Funksjon for å åpne filen, lese og velge et tilfeldig ord""" 
def read_words():
    word_file = open("words.txt", "r")
    word = word_file.readline()
    words = [];
    for word in word_file:
        word = word.rstrip(".\n").lower()
        words.append(word)
    random_word = random.choice(words)
    
    word_file.close()      
    return random_word
  
""" Funksjon for å håndtere spillet """      
def guess_word():
    word = read_words()
    guesses = ""
    chances = len(word)

    print(f"The word you need to guess has {chances} characters")
    

    while chances > 0:
        failed = 0
        for character in word:
            if character in guesses:
                print(character, end = " ")
                
            else:
                print("_", end = " ")
                failed += 1
                
        if failed == 0:
            print()
            print()
            print(f"You found the word ---> '{word}'")
            print("Congratulations! you won")
            break 
        
        print()
        print()
        guess = input(str("Guess a character: "))
        guesses += guess
        
        if guess not in word:
            chances -= 1
            print()
            print(f"Wrong! You have {chances} guesses left")
            print()
            
            if chances == 0:
                print("Sorry, you are out of chances")
                print(f"The word is ---> {word}")
                break
    

main()
  
