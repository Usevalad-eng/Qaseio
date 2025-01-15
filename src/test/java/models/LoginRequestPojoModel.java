package models;

public class LoginRequestPojoModel {
    //String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\":\"cityslicka\" }";
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
