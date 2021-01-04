package MY_OS;

import Admin.Admin;
import Admin.GeneralAdmin;

interface BasePerson {
    public default String getLogin() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
	    GeneralAdmin generalAdmin = new GeneralAdmin();
        Admin admin = new Admin("login", "1234");

    }
}
