package io.polybius.phonevalidator.factory;

import io.polybius.phonevalidator.enums.CountryCodeEnum;
import io.polybius.phonevalidator.validator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ValidatorFactory {

    final static Map<CountryCodeEnum, Supplier<Validator>> availableValidators = new HashMap<>();

    static {
        availableValidators.put(CountryCodeEnum.LITHUANIA, LithuaniaValidator::new);
        availableValidators.put(CountryCodeEnum.LATVIA, LatviaValidator::new);
        availableValidators.put(CountryCodeEnum.ESTONIA, EstoniaValidator::new);
        availableValidators.put(CountryCodeEnum.BELGIUM, BelgiumValidator::new);
    }

    public Validator getValidator(String phoneNormalized) {
        Supplier<Validator> validatorSupplier = null;

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

        return validatorSupplier.get();
    }
}
