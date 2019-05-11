package entity;

import java.util.Set;

public class Authors {
    private int authorId;
    private String name;
    private Set<Books> bookSet;


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBookSet() { return bookSet; }

    public void setBookSet(Set<Books> bookSet) { this.bookSet = bookSet; }

    public void addBook(Books book) { this.bookSet.add(book); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors authors = (Authors) o;

        if (authorId != authors.authorId) return false;
        if (name != null ? !name.equals(authors.name) : authors.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
