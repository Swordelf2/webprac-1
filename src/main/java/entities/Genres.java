package entities;

import java.util.Set;

public class Genres {
    private int genreId;
    private String name;
    private Set<Books> bookSet;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Books> bookSet) {
        this.bookSet = bookSet;
    }

    public void addBook(Books book) { this.bookSet.add(book); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genres genres = (Genres) o;

        if (genreId != genres.genreId) return false;
        if (name != null ? !name.equals(genres.name) : genres.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
