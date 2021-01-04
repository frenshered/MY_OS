package User;

import MY_OS.Person;

public class StdUser extends Person {
    protected String userName;
    protected String userSubName;
    protected String login;
    protected String password;

    StdUser() {
        this.userName = null;
        this.userSubName = null;
        this.login = null;
        this.password = null;
    }

    StdUser(String name, String subName, String login, String password) {
        this.userName = name;
        this.userSubName = subName;
        this.login = login;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserSubName() {
        return this.userSubName;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(String newName) {
        this.userName = newName;
    }

    public void setUserSubName(String newSubName) {
        this.userSubName = newSubName;
    }

    public void setLogin(String newLogin) {
        this.login = newLogin;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
