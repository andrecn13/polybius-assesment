package io.polybius.phonevalidator.enums;

public enum CountryCodeEnum {

    LITHUANIA("370"),
    LATVIA("371"),
    ESTONIA("372"),
    BELGIUM("32");

    private final String countryCode;

    CountryCodeEnum(String code) {
        this.countryCode = code;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
