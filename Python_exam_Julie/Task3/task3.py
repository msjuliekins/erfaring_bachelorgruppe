class Menu:
    def __init__(self):
        self.menu_options = [
            "1 - open new account", 
            "2 - deposit", "3 - withdraw", 
            "4 - add interest", 
            "5 - get balance", 
            "6 - quit"]

    def add_option(self):
        #adds an option that gets listed in same format as the others
        length = len(self.menu_options) + 1
        new_option = input("Enter the new menu option")
        self.menu_options.append(f"{length}  - {new_option}")

    def get_input(self):
        optionChosen = int(input("Enter nr of option: "))
        return optionChosen

class BankAccount:
    def __init__(self, balance):
        self.balance = float(balance)

    def deposit(self, deposited):
        self.balance+= float(deposited)
        self.get_balance()

    def withdraw(self, withdrawn):
        self.balance-= float(withdrawn)
        self.get_balance()

    def add_interest(self):
        #interest is 1% and gets added everytime the function is called
        self.balance *= 1.01
        print("Interest added")
        self.get_balance()

    def get_balance(self):
        #prints out balance with two decimal points
        print(f"Your balance is {self.balance:.2f} kr")

def main():
    newAccount = None
    newMenu = Menu()
    print("Welcome to the bank")
    for i in newMenu.menu_options:
        print(i)
    chosenOption = newMenu.get_input()
    while chosenOption != 6:
        
        if chosenOption == 1:
            balance = input("Enter balance of new account: ")
            newAccount = BankAccount(balance)
            
        elif chosenOption == 2:
            deposited = input("Enter balance to deposit: ")
            newAccount.deposit(deposited)
            
        elif chosenOption == 3:
            withdrawn = input("Enter balance to withdraw: ")
            newAccount.withdraw(withdrawn)
            
        elif chosenOption == 4:
            newAccount.add_interest()
            
        elif chosenOption == 5:
            newAccount.get_balance()
        
        #new options added will not have been initiated yet
        elif chosenOption > 6:
            print("Option not initiated yet")
        
        for i in newMenu.menu_options:
            print(i)
        chosenOption = newMenu.get_input()
    print("Goodbye")

main()

