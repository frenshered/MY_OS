package MY_OS;

import Admin.Admin;
import Admin.GeneralAdmin;
import DataBase.*;
import DataBase.GetDBConfig;
import User.StdUser;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

interface BasePerson {
    public default String getLogin() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException, SQLException {

        String userEmail = "paranchukserhiy@gmail.com";

        DataBase dataBase = new DataBase();

        StdUser stdUser = new StdUser("Serhiy", "Paranchuk", "admin", "1234");

        stdUser.sendMessageToDevelopers("Hello friends", dataBase);

//        dataBase.addNewUser(stdUser);
    }
}
