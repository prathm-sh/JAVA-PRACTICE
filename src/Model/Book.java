package Model;
//Book: String title, String authorName, String genre, int publicationYear, int pages

public class Book {
    private String title;
    private String authorName;
    private String genre;
    private int publicationYear;
    private int pages;

    public Book(String title, String authorName, String genre, int publicationYear, int pages) {
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
