package model;

public class userinfo {
    private Integer id;
    private String username;
    private String pass;
    private String email;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        System.out.println("UserInfo [id=" + id + ", username=" + username + ", pass=" + pass + "]");
        return null;
    }
}
