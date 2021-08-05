package io.polybius.phonevalidator;

public class PhoneUtil {

    public static String normalize(String phoneNumber) {

        return phoneNumber.replaceAll("\\)", "").
                replaceAll("\\(", "")
                .replaceAll(" ", "")
                .replaceAll("-", "")
                .replaceAll("\\+", "");

    }
}
