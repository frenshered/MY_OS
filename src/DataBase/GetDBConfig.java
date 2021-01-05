package DataBase;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetDBConfig {
    private DBConfig dbConfig;
    private final String dbConfigURL = "./dbConfig.json";

    public GetDBConfig() throws FileNotFoundException {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(this.dbConfigURL));
            JSONObject jsonObject = (JSONObject) obj;

            String password = (String) jsonObject.get("password");
            String login = (String) jsonObject.get("login");
            String dbName = (String) jsonObject.get("my_os");
            String dbURL = (String) jsonObject.get("db_url");
            String usersTableName = (String) jsonObject.get("users_table_name");
            String adminsTableName = (String) jsonObject.get("admins_table_name");
            String userMessagesTable = (String) jsonObject.get("user_messages_table");

            this.dbConfig = new DBConfig(password, login, dbName, dbURL, usersTableName, adminsTableName, userMessagesTable);

        } catch (ParseException | IOException e) {
            System.out.println("Error reading file \"" + this.dbConfigURL + "\"");
            e.printStackTrace();
        }

    }

    public DBConfig getDbConfig() {
        return this.dbConfig;
    }
}
