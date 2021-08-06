package io.polybius.phonevalidator;

import io.polybius.phonevalidator.factory.ValidatorFactory;
import io.polybius.phonevalidator.validator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MobilePhoneNumberValidator {
  public ValidationResultDto validate(List<String> phoneNumbers) {
    ValidationResultDto result = new ValidationResultDto();
    result.invalidPhones = new ArrayList<>();
    result.validPhonesByCountry = new HashMap<>();

    ValidatorFactory validatorFactory = new ValidatorFactory();

    for (int i = 0; i < phoneNumbers.size(); i++) {
      String phoneNumber = phoneNumbers.get(i);
      String phoneNormalized = PhoneUtil.normalize(phoneNumbers.get(i));

      try {
        Validator validator = validatorFactory.getValidator(phoneNormalized);
        boolean isValid = PhoneUtil.isBraceBalanced(phoneNumber)
                && PhoneUtil.isPhoneNumberValid(phoneNormalized)
                && validator.validate(phoneNormalized);

        if(isValid) {

          if (!result.validPhonesByCountry.containsKey(validator.getCountryCode())) {
            result.validPhonesByCountry.put(validator.getCountryCode(), new ArrayList<>());
          }

          result.validPhonesByCountry.get(validator.getCountryCode()).add(phoneNumber);
        } else {
          result.invalidPhones.add(phoneNumber);
        }
      } catch (IllegalArgumentException e) {
        result.invalidPhones.add(phoneNumber);
      }

    }

    return result;
  }

}
