package io.polybius.phonevalidator;

import java.util.Stack;

public class PhoneUtil {

    public static String normalize(String phoneNumber) {

        return phoneNumber.replaceAll("\\)", "").
                replaceAll("\\(", "")
                .replaceAll(" ", "")
                .replaceAll("-", "")
                .replaceAll("\\+", "");

    }

    public static boolean isPhoneNumberValid(String phoneNormalized) {
        try {
            Long.parseLong(phoneNormalized);
        }catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isBraceBalanced(String phoneNumber) {
        Stack<Character> stack = new Stack<>();

        for(char c : phoneNumber.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if((c == ')' && (stack.isEmpty() || stack.pop() != '('))) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
