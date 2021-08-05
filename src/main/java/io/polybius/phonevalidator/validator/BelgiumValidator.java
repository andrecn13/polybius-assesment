package io.polybius.phonevalidator.validator;

public class BelgiumValidator implements Validator{
    public static final String COUNTRY = "BE";

    @Override
    public boolean validate(String phoneNumber) {
        boolean isValid;

        if(phoneNumber.length() > 11)
            return false;

        final String phoneNumberWithoutCode = phoneNumber.substring(2);

        isValid = phoneNumberWithoutCode.length() == 9 && (phoneNumberWithoutCode.startsWith("456")
                || phoneNumberWithoutCode.startsWith("47")
                || phoneNumberWithoutCode.startsWith("48")
                || phoneNumberWithoutCode.startsWith("49"));

        return isValid;
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
