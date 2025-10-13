# Candidate nr: 396

# https://www.geeksforgeeks.org/python-program-check-string-palindrome-not/
# https://stackoverflow.com/questions/74252349/checking-for-a-palindrome-using-for-loop-in-python-and-print-output-only-once

def Palindrome(word):
        if word == word[::-1]:
            print(f"{word} is a palindrome!\n")
        else:
            print(f"{word} is not a palindrome!\n")


def Main():
    user_input = input("\nEnter a word with letters A-Z: ")
    word = user_input.lower()
    if not word.isalpha():
        print("Invalid input")
        return
    Palindrome(word)

    
Main()

