package io.polybius.phonevalidator.validator;

public class EstoniaValidator implements Validator{
    public static final String COUNTRY = "EE";

    @Override
    public boolean validate(String phoneNumber) {

        return phoneNumber.charAt(3) == '5' && (phoneNumber.substring(3).length() == 7
                || phoneNumber.substring(3).length() == 8);
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
