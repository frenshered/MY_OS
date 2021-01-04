package Admin;

import MY_OS.Person;

public class GeneralAdmin extends Person {
    protected String login;
    protected String password;
    protected boolean deleteUser = true;
    protected boolean deleteAdmin = true;
    protected boolean clearDataBase = true;
    protected boolean addNewUser = true;
    protected boolean addNewAdmin = true;

    public GeneralAdmin() {
        this.login = "admin";
        this.password = "root";
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isDeleteUser() {
        return this.deleteUser;
    }

    public boolean isDeleteAdmin() {
        return this.deleteAdmin;
    }

    public boolean isClearDataBase() {
        return this.clearDataBase;
    }

    public boolean isAddNewUser() {
        return this.addNewUser;
    }

    public boolean isAddNewAdmin() {
        return this.addNewAdmin;
    }
}
