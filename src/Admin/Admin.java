package Admin;

import DataBase.DataBase;
import MY_OS.Person;

import java.util.Scanner;

public class Admin extends GeneralAdmin {
     public Admin(String login, String password) {
         this.deleteAdmin = false;
         this.deleteUser = false;
         this.clearDataBase = false;
         this.login = login;
         this.password = password;
     }

     public void setAddNewUser(boolean value) {
         this.addNewUser = value;
     }

     public void setAddNewAdmin(boolean value) {
         this.addNewAdmin = value;
     }

     public void setDeleteUser(boolean value) {
         this.deleteUser = value;
     }

     public void setDeleteAdmin(boolean value) {
         this.deleteAdmin = value;
     }

     public void setClearDataBase(boolean value) {
         this.clearDataBase = value;
     }

     public boolean changeLogin() {
         System.out.print("Enter password: ");
         Scanner inP = new Scanner(System.in);

         String inputPassword = inP.nextLine();

         if (!this.password.equals(inputPassword)) {
             return false;
         }

         DataBase db = new DataBase();

         System.out.print("Enter new login: ");
         Scanner inL = new Scanner(System.in);

         String newLogin = inL.nextLine();

         for (Person person : db.getAllOSUsers()) {
             if (person.getLogin().equals(newLogin)) {
                 return false;
             }
         }

         this.login = newLogin;

         return true;
     }

    public boolean changePassword() {
        System.out.print("Enter password: ");
        Scanner inP = new Scanner(System.in);

        String inputPassword = inP.nextLine();

        if (!this.password.equals(inputPassword)) {
            return false;
        }

        System.out.print("Enter new login: ");
        Scanner inNP = new Scanner(System.in);

        this.password = inNP.nextLine();

        return true;
    }
}
