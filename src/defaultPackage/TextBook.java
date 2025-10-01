package defaultPackage;

public class TextBook extends Book {
    private String subject;

    public TextBook(String title, String author, String subject) {
        super(title, author);
        this.subject = subject;
    }

    public String getSubject() { return subject; }
}
