package entities;

public class Workers {
    private int workerId;
    private String name;
    private String email;
    private String password;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workers workers = (Workers) o;

        if (workerId != workers.workerId) return false;
        if (name != null ? !name.equals(workers.name) : workers.name != null) return false;
        if (email != null ? !email.equals(workers.email) : workers.email != null) return false;
        if (password != null ? !password.equals(workers.password) : workers.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
