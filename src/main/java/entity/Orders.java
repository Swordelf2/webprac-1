package entity;

import java.sql.Date;
import java.util.Set;

public class Orders {
    private int orderId;
    private Clients clientsByClientId;
    private Date deliveryDate;
    private Integer period;
    private String deliveryAddress;
    private String status;
    private String notes;
    private Set<Books> bookSet;

    public Set<Books> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Books> bookSet) {
        this.bookSet = bookSet;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Books> getBooksSet() {
        return bookSet;
    }

    public void setBooksSet(Set<Books> booksSet) {
        this.bookSet = booksSet;
    }

    public void addBook(Books book) {
        this.bookSet.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (clientsByClientId != null ? !clientsByClientId.equals(orders.clientsByClientId) : orders.clientsByClientId != null) return false;
        if (deliveryDate != null ? !deliveryDate.equals(orders.deliveryDate) : orders.deliveryDate != null)
            return false;
        if (period != null ? !period.equals(orders.period) : orders.period != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(orders.deliveryAddress) : orders.deliveryAddress != null)
            return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;
        if (notes != null ? !notes.equals(orders.notes) : orders.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (clientsByClientId != null ? clientsByClientId.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
