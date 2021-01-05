package User;

import DataBase.DataBase;
import MY_OS.Person;

import java.sql.SQLException;
import java.util.Scanner;

public class StdUser extends Person {
    protected String userName;
    protected String userSubName;
    protected String login;
    protected String password;

    public StdUser() {
        this.userName = null;
        this.userSubName = null;
        this.login = null;
        this.password = null;
    }

    public StdUser(String name, String subName, String login, String password) {
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

    public void sendMessageToDevelopers(String message, DataBase db) throws SQLException {
        System.out.print("Enter your email: ");
        Scanner email = new Scanner(System.in);

        db.sendMessageToDevelopers(message, this, email.nextLine());
    }
}
