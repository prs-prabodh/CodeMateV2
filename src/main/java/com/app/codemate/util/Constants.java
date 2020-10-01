package com.app.codemate.util;

public interface Constants {
    String OK = "OK";

    interface Http {
        String V1           = "/v1";
        String EXECUTE      = "/execute";
        String CREDIT_SPENT = "/credit-spent";
    }

    interface JDoodle {
        String CLIENT_ID            = "26673b9299a9da1ff9970936c84c58c8";
        String CLIENT_SECRET        = "34b142e06f701da49ce97066d1f674e38fda31fd3c32fce55a5688c4934bb6c9";
        int    CREDIT_LIMIT_PER_DAY = 200;
    }
}
