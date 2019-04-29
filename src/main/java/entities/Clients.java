package entities;

import java.util.Set;

public class Clients {
    private int clientId;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Set<Orders> ordersByClientsId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Orders> getOrdersByClientsId() {
        return ordersByClientsId;
    }

    public void setOrdersByClientsId(Set<Orders> ordersByClientsId) {
        this.ordersByClientsId = ordersByClientsId;
    }

    public void addOrder(Orders order) { this.ordersByClientsId.add(order); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (clientId != clients.clientId) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (phone != null ? !phone.equals(clients.phone) : clients.phone != null) return false;
        if (email != null ? !email.equals(clients.email) : clients.email != null) return false;
        if (password != null ? !password.equals(clients.password) : clients.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
