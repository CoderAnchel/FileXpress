package org.magiceagle.filexpress.Utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class ByCriptUtils {
    public static BCrypt.Result resolve(String password,String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
    }
}
