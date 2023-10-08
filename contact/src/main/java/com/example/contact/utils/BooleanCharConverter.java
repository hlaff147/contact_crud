package com.example.contact.utils;

public class BooleanCharConverter {
    public static char toChar(boolean value) {
        return value ? 'Y' : 'N';
    }

    public static boolean toBoolean(char value) {
        return value == 'Y';
    }
}
