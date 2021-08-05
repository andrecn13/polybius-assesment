package io.polybius.phonevalidator.validator;

public class EstoniaValidator implements Validator{
    public static final String COUNTRY = "EE";

    @Override
    public boolean validate(String phoneNumber) {

        return phoneNumber.charAt(4) == '5' && (phoneNumber.substring(4).length() == 7
                || phoneNumber.substring(4).length() == 8);
    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
