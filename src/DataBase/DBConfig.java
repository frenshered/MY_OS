package DataBase;

public class DBConfig {
    private final String password;
    private final String login;
    private final String dbName;
    private final String dbURL;
    private final String usersTableName;
    private final String adminsTableName;
    private final String userMessagesTable;

    public DBConfig(String password, String login, String dbName, String dbURL, String usersTableName,
                    String adminsTableName, String userMessagesTable)
    {
        this.password = password;
        this.login = login;
        this.dbName = dbName;
        this.dbURL = dbURL;
        this.usersTableName = usersTableName;
        this.adminsTableName = adminsTableName;
        this.userMessagesTable = userMessagesTable;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getDbURL() {
        return this.dbURL;
    }

    public String getAdminsTableName() {
        return this.adminsTableName;
    }

    public String getUsersTableName() {
        return this.usersTableName;
    }

    public String getUserMessagesTable() {
        return this.userMessagesTable;
    }
}
