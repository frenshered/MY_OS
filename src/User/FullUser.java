package User;

public class FullUser extends StdUser {
    private final String email;
    private final String phone;
    private final String[] interest;

    public FullUser(String login, String password, String name, String subName) {
        super(name, subName, login, password);

        this.email = null;
        this.phone = null;
        this.interest = new String[0];
    }

    public FullUser(String login, String password, String name, String subName, String email, String phone, String[] interest) {
        super(name, subName, login, password);

        this.email = email;
        this.phone = phone;
        this.interest = interest;
    }
}
