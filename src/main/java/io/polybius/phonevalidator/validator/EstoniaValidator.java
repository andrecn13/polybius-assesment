package io.polybius.phonevalidator.validator;

public class EstoniaValidator implements Validator{
    public static final String CODE = "372";
    public static final String COUNTRY = "EE";

    @Override
    public boolean validate(String phoneNumber) {
        boolean isValid;

        if (phoneNumber.startsWith(CODE)) {
            isValid = phoneNumber.charAt(4) == '5' && (phoneNumber.substring(4).length() == 7
                    || phoneNumber.substring(4).length() == 8);
        } else {
            isValid = phoneNumber.charAt(3) == '5' && phoneNumber.substring(3).length() == 7;
        }

        return isValid;
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
