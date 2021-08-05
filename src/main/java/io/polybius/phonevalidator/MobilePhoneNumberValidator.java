package io.polybius.phonevalidator;

import io.polybius.phonevalidator.validator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MobilePhoneNumberValidator {
  public ValidationResultDto validate(List<String> phoneNumbers) {
    ValidationResultDto result = new ValidationResultDto();
    result.invalidPhones = new ArrayList<>();
    result.validPhonesByCountry = new HashMap<>();

    for (int i = 0; i < phoneNumbers.size(); i++) {
      String phoneNumber = phoneNumbers.get(i);
      String phoneNormalized = PhoneUtil.normalize(phoneNumbers.get(i));

      try {
        Long.parseLong(phoneNormalized);
      }catch(NumberFormatException e) {
        result.invalidPhones.add(phoneNumber);
        continue;
      }

      Validator validator = null;

      if(phoneNormalized.startsWith("370")) {
        validator = new LithuaniaValidator();
      } else if(phoneNormalized.startsWith("371")) {
        validator = new LatviaValidator();
      } else if(phoneNormalized.startsWith("32")) {
        validator = new BelgiumValidator();
      }else if(phoneNormalized.startsWith("372")) {
        validator = new EstoniaValidator();
      } else {
        result.invalidPhones.add(phoneNumber);
        continue;
      }

      boolean isValid = validator.validate(phoneNormalized);

      if(isValid) {

        if (!result.validPhonesByCountry.containsKey(validator.getCountryCode())) {
          result.validPhonesByCountry.put(validator.getCountryCode(), new ArrayList<>());
        }

        result.validPhonesByCountry.get(validator.getCountryCode()).add(phoneNumber);
      } else {
        result.invalidPhones.add(phoneNumber);
      }

    }

    return result;
  }
}
