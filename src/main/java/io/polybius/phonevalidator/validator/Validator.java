package io.polybius.phonevalidator.validator;

import io.polybius.phonevalidator.ValidationResultDto;

public interface Validator {

    boolean validate(String phoneNumber);
    String getCountryCode();
}
