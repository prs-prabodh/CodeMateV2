package com.app.codemate.util;

import java.util.concurrent.ThreadLocalRandom;

public class KeyUtil {

    public static String generateUid() {
        int uidLength = Constants.UID.LENGTH;
        String keyDomain = Constants.UID.KEY_DOMAIN;
        int keyDomainLength = keyDomain.length();
        StringBuilder uid;
        uid = new StringBuilder("");
        for (int i = 0; i < uidLength; i++) {
            uid.append(keyDomain.charAt(ThreadLocalRandom.current().nextInt(keyDomainLength)));
        }
        return uid.toString();
    }
}
