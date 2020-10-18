package com.app.codemate.util;

public interface Constants {
    String OK = "OK";

    interface UID {
        int    LENGTH     = 6;
        String KEY_DOMAIN = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    }

    interface Http {
        String V1           = "/v1";
        String EXECUTE      = "/execute";
        String CREDIT_SPENT = "/credit-spent";
    }

    interface JDoodle {
        int CREDIT_LIMIT_PER_DAY = 200;
    }
}
