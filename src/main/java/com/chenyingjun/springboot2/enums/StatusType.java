package com.chenyingjun.springboot2.enums;

public enum StatusType {

    STATUS_1(1, "可用"),
    STATUS_0(0, "禁用");
    private int key;
    private String value;

    public static String getName(Integer key) {
        if (null == key) {
            return null;
        }
        for (StatusType type : StatusType.values()) {
            if (type.key == key.intValue()) {
                return type.value;
            }
        }
        return null;
    }

    public Integer getKey() {
        return key;
    }

    StatusType(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
