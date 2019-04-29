package entities;

import java.math.BigDecimal;
import java.util.Set;

public class Books {
    private int bookId;
    private String name;
    private BigDecimal price;
    private Integer year;
    private Integer pages;
    private String cover;
    private Integer quantity;
    private String annotation;
    private Publishers publishersByPublisherId;
    private Set<Authors> authorSet;
    private Set<Orders> orderSet;
    private Set<Genres> genreSet;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Set<Authors> getAuthorSet() { return authorSet; }

    public void setAuthorSet(Set<Authors> authorSet) { this.authorSet = authorSet; }

    public void addAuthor(Authors author) { this.authorSet.add(author); }

    public Set<Orders> getOrderSet() { return orderSet; }

    public void setOrderSet(Set<Orders> orderSet) { this.orderSet = orderSet; }

    public void addOrder(Orders order) { this.orderSet.add(order); }

    public Set<Genres> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genres> genreSet) {
        this.genreSet = genreSet;
    }

    public void addGenre(Genres genre) { this.genreSet.add(genre); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (bookId != books.bookId) return false;
        if (name != null ? !name.equals(books.name) : books.name != null) return false;
        if (price != null ? !price.equals(books.price) : books.price != null) return false;
        if (year != null ? !year.equals(books.year) : books.year != null) return false;
        if (pages != null ? !pages.equals(books.pages) : books.pages != null) return false;
        if (cover != null ? !cover.equals(books.cover) : books.cover != null) return false;
        if (quantity != null ? !quantity.equals(books.quantity) : books.quantity != null) return false;
        if (annotation != null ? !annotation.equals(books.annotation) : books.annotation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        return result;
    }

    public Publishers getPublishersByPublisherId() {
        return publishersByPublisherId;
    }

    public void setPublishersByPublisherId(Publishers publishersByPublisherId) {
        this.publishersByPublisherId = publishersByPublisherId;
    }
}
