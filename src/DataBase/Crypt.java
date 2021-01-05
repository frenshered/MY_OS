package DataBase;

import com.lambdaworks.crypto.SCryptUtil;

public class Crypt {
    public static String encryptionPassword(String password) {
        return SCryptUtil.scrypt(password, 16, 16, 16);
    }

    public boolean checkPassword(String password) {
        return SCryptUtil.check(password, encryptionPassword(password));
    }
}
