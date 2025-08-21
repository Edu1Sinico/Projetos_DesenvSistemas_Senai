package webapp.newsletterjdbc.model;

public class IndexModel {
    private String email;

    public IndexModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
