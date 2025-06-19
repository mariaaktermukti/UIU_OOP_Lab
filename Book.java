public class Book
{
    private String title;
    private String ISBN;
    private String author;
    private String dateOfPublish;

    public Book(String title, String ISBN, String author, String dateOfPublish)
    {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.dateOfPublish = dateOfPublish;
    }

    public String getTitle()
    {
        return title;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getDateOfPublish()
    {
        return dateOfPublish;
    }

    public String toString()
    {
        return "Title: " + title + ", ISBN: " + ISBN + ", Author: " + author + ", Date of Publish: " + dateOfPublish;
    }
}
