package DataBase;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetDBConfig {
    private DBConfig dbConfig;

    public GetDBConfig() throws FileNotFoundException {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("./dbConfig.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String password = (String) jsonObject.get("password");
            String login = (String) jsonObject.get("login");
            String dbName = (String) jsonObject.get("dbName");
            String dbURL = (String) jsonObject.get("dbURL");

            this.dbConfig = new DBConfig(password, login, dbName, dbURL);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    public DBConfig getDbConfig() {
        return this.dbConfig;
    }
}
