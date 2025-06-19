public class MyLibrary
{
    private Book[] collection;
    private int count;

    public MyLibrary()
    {
        collection = new Book[100];
        count = 0;
    }

    public void addBook(Book b) throws DuplicateItemException
    {
        for (int i = 0; i < count; i++)
        {
            if (collection[i].getTitle().equalsIgnoreCase(b.getTitle()) &&
                    collection[i].getISBN().equals(b.getISBN()))
            {
                throw new DuplicateItemException("This book is already included in the collection.");
            }
        }
        collection[count++] = b;
    }

    public Book searchBook(String title) throws ItemNotFoundException
    {
        for (int i = 0; i < count; i++)
        {
            if (collection[i].getTitle().equalsIgnoreCase(title))
            {
                return collection[i];
            }
        }
        throw new ItemNotFoundException("The item being searched does not exist in the collection");
    }

    public static void main(String[] args)
    {
        MyLibrary library = new MyLibrary();

        Book b1 = new Book("To Kill a Mockingbird", "8123", "Harper Lee", "05-11-1960");
        Book b2 = new Book("The Great Gatsby", "1212", "F. Scott Fitzgerald", "26-04-1925");
        Book b3 = new Book("One Hundred Years of Solitude", "9280", "Gabriel Márquez", "13-11-1967");
        Book b4 = new Book("The Great Gatsby", "1212", "F. Scott Fitzgerald", "26-04-1925");

        try {
            library.addBook(b1);
            library.addBook(b2);
            library.addBook(b3);
            library.addBook(b4);
        } catch (DuplicateItemException e) {
            System.out.println("AddBook Error: " + e.getMessage());
        }

        try {
            Book found = library.searchBook("One Hundred Years of Solitude");
            System.out.println("Book Found: " + found);
        } catch (ItemNotFoundException e) {
            System.out.println("Search Error: " + e.getMessage());
        }

        try {
            Book notFound = library.searchBook("Brave New World");
            System.out.println("Book Found: " + notFound);
        } catch (ItemNotFoundException e) {
            System.out.println("Search Error: " + e.getMessage());
        }
    }
}

class DuplicateItemException extends Exception
{
    public DuplicateItemException(String message)
    {
        super(message);
    }
}

class ItemNotFoundException extends Exception
{
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}
