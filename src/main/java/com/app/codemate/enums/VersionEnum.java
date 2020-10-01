package com.app.codemate.enums;

import lombok.Getter;

@Getter
public enum VersionEnum {
    C_5_3_0(0), C_5_0_0(1), JDK_1_8_0(0), JDK_9_0_1(1), JDK_11_0_4(3), CPP_14_5_3_0(0), CPP_14_7_2_0(1), CPP_17_9_10(0), CPP_5_3_0(0), CPP_5_0_0(1);

    private final int index;

    VersionEnum(int index) {
        this.index = index;
    }
}
