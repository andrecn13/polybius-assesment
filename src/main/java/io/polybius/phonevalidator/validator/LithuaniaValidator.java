package io.polybius.phonevalidator.validator;

public class LithuaniaValidator implements Validator{
    public static final String CODE = "370";
    public static final String COUNTRY = "LT";

    @Override
    public boolean validate(String phoneNumber) {
        boolean isValid;

        if (phoneNumber.startsWith(CODE)) {
            isValid = phoneNumber.charAt(3) == '6' && phoneNumber.substring(3).length() == 8;
        }else{
            isValid = phoneNumber.charAt(4) == '6' && phoneNumber.substring(4).length() == 8;
        }

        return isValid;

    }

    @Override
    public String getCountryCode() {
        return COUNTRY;
    }
}
