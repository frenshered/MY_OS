package DataBase;

public class DBConfig {
    private final String password;
    private final String login;
    private final String dbName;
    private final String dbURL;

    public DBConfig(String password, String login, String dbName, String dbURL) {
        this.password = password;
        this.login = login;
        this.dbName = dbName;
        this.dbURL = dbURL;
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
}
