package io.polybius.phonevalidator.validator;

public interface Validator {

    boolean validate(String phoneNumber);
    String getCountryCode();
}
