package MY_OS;

import Admin.Admin;
import Admin.GeneralAdmin;
import DataBase.GetDBConfig;

import java.io.FileNotFoundException;

interface BasePerson {
    public default String getLogin() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        GetDBConfig config = new GetDBConfig();

    }
}
