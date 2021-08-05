package io.polybius.phonevalidator.factory;

import io.polybius.phonevalidator.enums.CountryCodeEnum;
import io.polybius.phonevalidator.validator.*;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {

    final static Map<CountryCodeEnum, Validator> availableValidators = new HashMap<>();

    static {
        availableValidators.put(CountryCodeEnum.LITHUANIA, new LithuaniaValidator());
        availableValidators.put(CountryCodeEnum.LATVIA, new LatviaValidator());
        availableValidators.put(CountryCodeEnum.ESTONIA, new EstoniaValidator());
        availableValidators.put(CountryCodeEnum.BELGIUM, new BelgiumValidator());
    }

    public Validator getValidator(String phoneNormalized) {
        Validator validatorSupplier = null;

        if(phoneNormalized.startsWith(CountryCodeEnum.LITHUANIA.getCountryCode())) {
            validatorSupplier = availableValidators.get(CountryCodeEnum.LITHUANIA);
        } else if(phoneNormalized.startsWith(CountryCodeEnum.LATVIA.getCountryCode())) {
            validatorSupplier = availableValidators.get(CountryCodeEnum.LATVIA);
        } else if(phoneNormalized.startsWith(CountryCodeEnum.ESTONIA.getCountryCode())) {
            validatorSupplier = availableValidators.get(CountryCodeEnum.ESTONIA);
        }else if(phoneNormalized.startsWith(CountryCodeEnum.BELGIUM.getCountryCode())) {
            validatorSupplier = availableValidators.get(CountryCodeEnum.BELGIUM);
        }

        if (null == validatorSupplier)
            throw new IllegalArgumentException("No such validator available for number: " + phoneNormalized);

        return validatorSupplier;
    }
}
