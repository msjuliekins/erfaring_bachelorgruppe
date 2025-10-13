def main():
    print("Here you can enter a word or sentance to see if it is a palindrome")
    entered = input("Please enter a word or sentence: ")
    if isPalindrome(entered):
        print("What you entered is a palindrome")
    else:
        print("What you entered is not a palindrome")

def isPalindrome(entered):
    #takes the input from user, removes spaces and checks that only characters or numbers are used
    cleaned = "".join(i.upper() for i in entered if i.isalnum())
    #returns true is the reverse version of cleaned and cleaned are the same
    return cleaned == cleaned[::-1]
    
main()