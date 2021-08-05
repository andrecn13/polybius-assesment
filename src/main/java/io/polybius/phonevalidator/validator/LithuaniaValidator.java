package io.polybius.phonevalidator.validator;

public class LithuaniaValidator implements Validator{
    public static final String COUNTRY = "LT";

    @Override
    public boolean validate(String phoneNumber) {
        return phoneNumber.charAt(3) == '6' && phoneNumber.substring(3).length() == 8;
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
