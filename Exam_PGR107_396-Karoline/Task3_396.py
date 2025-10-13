# Candidate nr: 396

#https://kristiania.instructure.com/courses/12805/files/1591783?module_item_id=544950
#https://stackoverflow.com/questions/58895355/how-do-i-display-the-menu-properly-after-each-user-input
#https://medium.com/@firozkaif27/create-a-python-menu-to-run-various-commands-7be4d70cc127

import random

class Menu:
    def __init__(self):
        self.options = []

    def add_option(self, option):
      self.options.append(option)

    def get_input(self):
        done = False
        while not done:
            for i in range(len(self.options)):
                try:
                    user_choice = int(input("Enter your choice: "))
                    if (1 <= user_choice <= len(self.options)):
                        done = True
                        return user_choice
                    else:
                        print("\nInvalid option.\n")
                        
                except ValueError:
                    print(f"\nPlease enter a number >= 1 and <= {len(self.options)}\n")
                    
                
    def __str__(self):
        print("\nMenu: \n")
        result = ""
        for i in range (len(self.options)):
            result += f"{i+1} " + str(self.options[i]) + "\n\n"
        return result
                
class BankAccount:
    def __init__(self):
        self.balance = 0
        self.interest = 0
    
    def open_account(self, name):
        self.name = name
        self.account_number = random.randint(1000, 9999)
        print(f"\nAccount for {self.name} ")
        print(f"Your new account nr. {self.account_number} is now open \n")
        print("----------------------------------------------------------------")
    
    def deposit(self, amount):
        self.balance += amount
        print(f"{amount} has been added to your account")
        print("----------------------------------------------------------------")
    
    def withdraw(self, amount):
        if amount > self.balance:
            print(f"Unable to withdraw {amount}")
            print("----------------------------------------------------------------")
        else:
            self.balance-= amount
            print(f"{amount} has been withdrawed to your account")
            print("----------------------------------------------------------------")
    
    def add_interest(self, interest):
        self.interest += interest
        print(f"{interest} has been added to your interests")
        print("----------------------------------------------------------------")
    
    def get_balance(self):
        return self.balance



def main():
    menu = Menu()
    bank = BankAccount()
    
    menu.add_option("Open an account")
    menu.add_option("Deposit money into your account")
    menu.add_option("Withdraw money from your account")
    menu.add_option("Add interests to your account")
    menu.add_option("Get the current balance of your account")
    menu.add_option("Quit")
 
    
    #print(menu)
    
    while True:
        print(menu)
        choice = menu.get_input()
        if choice == 1:
            name = input("Enter your name to open account: ")
            bank.open_account(name)
        elif choice == 2:
            amount = int(input("Enter amount to deposit: "))
            bank.deposit(amount)
        elif choice == 3:
            amount = int(input("Enter amount to withdraw: "))
            bank.withdraw(amount)
        elif choice == 4:
            interest = int(input("Enter number for interest: "))
            bank.add_interest(interest)
        elif choice == 5:
            print(f"Current balance: {bank.get_balance()}")
        elif choice == 6:
                print("Exiting")
                break
        else:
            print("Invalid choice. Please  enter a number between 1-6")
    
  
    
main()




