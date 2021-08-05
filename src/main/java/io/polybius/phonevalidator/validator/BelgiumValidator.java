package io.polybius.phonevalidator.validator;

public class BelgiumValidator implements Validator{
    public static final String CODE = "32";
    public static final String COUNTRY = "BE";

    @Override
    public boolean validate(String phoneNumber) {
        boolean isValid;

        if(phoneNumber.length() > 11)
            return false;

        isValid = phoneNumber.substring(2).length() == 9 && (phoneNumber.substring(2).startsWith("456")
                || phoneNumber.substring(2).startsWith("47")
                || phoneNumber.substring(2).startsWith("48")
                || phoneNumber.substring(2).startsWith("49"));


        return isValid;
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
