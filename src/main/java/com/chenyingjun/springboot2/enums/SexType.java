package com.chenyingjun.springboot2.enums;

import org.apache.commons.lang3.StringUtils;

public enum SexType {

    SEX_MAN("1", "男"),
    SEX_WOMAN("2", "女");
    private String key;
    private String value;

    public static String getName(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        for (SexType type : SexType.values()) {
            if (type.key.equals(key)) {
                return type.value;
            }
        }
        return null;
    }

    SexType(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
