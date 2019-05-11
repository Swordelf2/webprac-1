package entity;

import java.util.Set;

public class Publishers {
    private int publisherId;
    private String name;
    private String city;
    private String country;
    private Set<Books> booksByPublisherId;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Books> getBooksByPublisherId() {
        return booksByPublisherId;
    }

    public void setBooksByPublisherId(Set<Books> booksByPublisherId) {
        this.booksByPublisherId = booksByPublisherId;
    }

    public void addBook(Books book) { this.booksByPublisherId.add(book); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publishers that = (Publishers) o;

        if (publisherId != that.publisherId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publisherId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
