package MY_OS;

import Admin.Admin;
import User.StdUser;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataBase {
    private StdUser[] stdUsers;
    private Admin[] admins;
    private final int numberOfAllUsers;

    public DataBase() {
        this.stdUsers = new StdUser[0];
        this.numberOfAllUsers = this.stdUsers.length;
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

    public void addNewUser(StdUser newUser) {
        this.stdUsers = Arrays.copyOf(this.stdUsers, this.stdUsers.length + 1);
        this.stdUsers[this.stdUsers.length - 1] = newUser;
    }
}
