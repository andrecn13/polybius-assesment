package io.polybius.phonevalidator.validator;

public class LatviaValidator implements Validator{
    public static final String COUNTRY = "LV";

    @Override
    public boolean validate(String phoneNumber) {
        return phoneNumber.charAt(3) == '2' && phoneNumber.substring(3).length() == 8;
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
