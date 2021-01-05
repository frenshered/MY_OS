package DataBase;

import Admin.Admin;
import MY_OS.Person;
import User.StdUser;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class DataBase {
    private DBConfig dbConfig;
    private StdUser[] stdUsers;
    private Admin[] admins;
    private final int numberOfAllUsers;


    public DataBase() throws FileNotFoundException, SQLException {
        GetDBConfig getDBConfig = new GetDBConfig();

        this.stdUsers = new StdUser[0];
        this.numberOfAllUsers = this.stdUsers.length;
        this.dbConfig = getDBConfig.getDbConfig();
    }

    public Connection connectionToDB() throws SQLException {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dbConfig.getDbURL(), dbConfig.getLogin(), dbConfig.getPassword());
            System.out.println("Database connection status: Successfully");

            return connection;

        } catch (Exception ex) {
            System.out.println("Database connection status: Failed");
            ex.printStackTrace();
        }

        return connection;
    }

    public StdUser[] getAllStdUsers() {
        return this.stdUsers;
    }

    public int getNumberOfAllUsers() {
        return this.numberOfAllUsers;
    }

    public Admin[] getAllAdmins() {
        return this.admins;
    }

    public Person[] getAllOSUsers() {
        return Stream.concat(Stream.of(this.stdUsers), Stream.of(admins)).toArray(Person[]::new);
    }

    public StdUser[] getStdUser(String param) {
        StdUser[] wantedUsers = new StdUser[0];

        for (StdUser user : this.stdUsers) {
            if (user.getUserName().equals(param)) {
                wantedUsers = Arrays.copyOf(wantedUsers, wantedUsers.length + 1);
                wantedUsers[wantedUsers.length - 1] = user;
                continue;
            }

            if (user.getUserSubName().equals(param)) {
                wantedUsers = Arrays.copyOf(wantedUsers, wantedUsers.length + 1);
                wantedUsers[wantedUsers.length - 1] = user;
            }
        }

        return wantedUsers;
    }

    public void addNewUser(StdUser newUser) throws SQLException {
        String insert = "INSERT INTO " + dbConfig.getUsersTableName() + "(name,subName,login,password)" + "VALUES(?,?,?,?)";
        Connection conn = this.connectionToDB();

        PreparedStatement prST = conn.prepareStatement(insert);
        prST.setString(1, newUser.getUserName());
        prST.setString(2, newUser.getUserSubName());
        prST.setString(3, newUser.getLogin());
        prST.setString(4, Crypt.encryptionPassword(newUser.getPassword()));

        try {

            prST.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error writing data to database");
            e.printStackTrace();
        }
    }

    public void sendMessageToDevelopers(String message, StdUser user, String userEmail) throws SQLException {
        Calendar calendar = new GregorianCalendar();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        String insert = "INSERT INTO " + dbConfig.getUserMessagesTable() + "(userName,userEmail,time,date,message)" + "VALUES(?,?,?,?,?)";
        Connection conn = this.connectionToDB();

        PreparedStatement prST = conn.prepareStatement(insert);
        prST.setString(1, user.getUserName());
        prST.setString(2, userEmail);
        prST.setString(3, time);
        prST.setString(4, date);
        prST.setString(5, message);

        try {

            prST.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Database connection status: Failed");
            e.printStackTrace();
        }

    }
}
