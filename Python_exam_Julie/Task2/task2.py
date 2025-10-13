class Book:

    def __init__(self, title, author, nrOfPages):
        self.title = title
        self.author = author
        self.nrOfPages = nrOfPages

class Library:

    def __init__(self, books,checkedOut):
        self.books = books
        self.checkedOut = checkedOut

    def add_book(self, book):
        self.books.append(book)
        print("")
        print("Book added")

    def remove_book(self, title):
        for i in self.books:
            if i.title == title:
                self.books.remove(i)
                print("")
                print("Book removed")
                return
        print("")
        print("Couldn´t remove book")

    def check_in(self, title):
        for i in self.checkedOut:
            if i.title == title:
                self.books.append(i)
                #i use a list to keep track of checked out books 
                #so that books not from this library can´t be checked in
                self.checkedOut.remove(i)
                print("")
                print("Book checked in")
                return
        print("")
        print("Couldn´t check in book")

    def check_out(self, title):
        for i in self.books:
            if i.title == title:
                self.checkedOut.append(i)
                self.books.remove(i)
                print("")
                print("Book checked out")
                return
        print("")
        print("Couldn´t check out book")

def main():
    print("Welcome to the library!")
    books = []
    checkedOut = []
    lib = Library(books, checkedOut)

    print("Library at start:")
    for i in books:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")

    book1 = Book("Book1", "Author1", 234)
    book2 = Book("Book2", "Author2", 123)
    book3 = Book("Book3", "Author3", 456)
    lib.add_book(book1)
    lib.add_book(book2)
    lib.add_book(book3)
    print("")
    print("Library after adding books")
    for i in books:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")

    lib.remove_book("Book2")
    print("")
    print("Library after removing book")
    for i in books:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")

    lib.check_out("Book1")
    print("")
    print("Library after checking out book")
    for i in books:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")
    print("")
    print("Checked out books")
    for i in checkedOut:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")

    lib.check_in("Book1")
    print("")
    print("Library after checking in book")
    for i in books:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")
    print("")
    print("Checked out books")
    for i in checkedOut:
        print(f"Title: {i.title}")
        print(f"Author: {i.author}")
        print(f"Nr of pages: {i.nrOfPages}")
        
main()