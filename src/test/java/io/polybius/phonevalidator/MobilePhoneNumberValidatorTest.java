package io.polybius.phonevalidator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MobilePhoneNumberValidatorTest {

  private MobilePhoneNumberValidator validator = new MobilePhoneNumberValidator();


  @Test
  public void validate() {
    ValidationResultDto result = validator.validate(List.of("+37061234567"));
    assertEquals(List.of("+37061234567"), result.validPhonesByCountry.get("LT"));

    result = validator.validate(List.of("+37091234567"));
    assertEquals(List.of("+37091234567"), result.invalidPhones);

    result = validator.validate(List.of("+3706123456"));
    assertEquals(List.of("+3706123456"), result.invalidPhones);
  }

  @Test
  public void shouldReturnInvalidNumbers() {
    List<String> phoneNumbers = List.of("+37012", "#371 AA aa", "@$@",
            "32 124", "+32#@", "())", "()", "+370(6(3))4()567");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.invalidPhones);
    assertEquals(8, result.invalidPhones.size());
    assertEquals(0, result.validPhonesByCountry.size());
    assertEquals(phoneNumbers, result.invalidPhones);
  }

  @Test
  public void shouldReturnInvalidPhonesListWhenBelgiumNumberWrongFormat() {
    List<String> phoneNumbers = List.of("+3212345678", "3212345678", "+32 12345678",
            "32 12345678", "32 123", "32 678", "+32ABC", "ABC", "()", "+32(61234567", "+324734567892");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.invalidPhones);
    assertEquals(11, result.invalidPhones.size());
    assertEquals(0, result.validPhonesByCountry.size());
    assertEquals(phoneNumbers, result.invalidPhones);
  }

  @Test
  public void shouldValidateSuccessfullyBelgiumNumber() {
    List<String> phoneNumbers = List.of("32456123456", "+32456123456", "32 456123456",
            "+3245612 34 56", "+32 (4)56123456", "+32 456 123 456", "+32-456-123-456");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.validPhonesByCountry.get("BE"));
    assertNotNull(result.invalidPhones);
    assertEquals(1, result.validPhonesByCountry.size());
    assertEquals(7, result.validPhonesByCountry.get("BE").size());
    assertEquals(0, result.invalidPhones.size());
  }

  @Test
  public void shouldReturnInvalidPhonesListWhenLithuaniaNumberWrongFormat() {
    List<String> phoneNumbers = List.of("+37012345678", "37012345678", "+370 12345678",
            "370 12345678", "370 123", "370 678", "+370ABC", "ABC", "()", "+370(61234567");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.invalidPhones);
    assertEquals(10, result.invalidPhones.size());
    assertEquals(0, result.validPhonesByCountry.size());
    assertEquals(phoneNumbers, result.invalidPhones);
  }

  @Test
  public void shouldValidateSuccessfullyLithuaniaNumber() {
    List<String> phoneNumbers = List.of("37061234567", "+37061234567", "370 61234567",
            "+370 61234567", "+370(6)1234567", "+370 612 34 567", "+370-612-34-567");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.validPhonesByCountry.get("LT"));
    assertNotNull(result.invalidPhones);
    assertEquals(1, result.validPhonesByCountry.size());
    assertEquals(7, result.validPhonesByCountry.get("LT").size());
    assertEquals(0, result.invalidPhones.size());
  }

  @Test
  public void shouldReturnInvalidPhonesListWhenLatviaNumberWrongFormat() {
    List<String> phoneNumbers = List.of("+37112345678",
            "37112345678", "+371 12345678", "371 12345678", "371 123", "371 234");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.invalidPhones);
    assertEquals(6, result.invalidPhones.size());
    assertEquals(0, result.validPhonesByCountry.size());
    assertEquals(phoneNumbers, result.invalidPhones);
  }

  @Test
  public void shouldValidateSuccessfullyLatviaNumber() {
    List<String> phoneNumbers = List.of("37121234567", "+37121234567", "371 21234567",
            "+371 21234567", "+371(2)1234567", "+371 212 34 567", "+371-212-34-567");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.validPhonesByCountry.get("LV"));
    assertNotNull(result.invalidPhones);
    assertEquals(1, result.validPhonesByCountry.size());
    assertEquals(7, result.validPhonesByCountry.get("LV").size());
    assertEquals(0, result.invalidPhones.size());
  }

  @Test
  public void shouldReturnInvalidPhonesListWhenEstoniaNumberWrongFormat() {
    List<String> phoneNumbers = List.of("+37212345678",
            "37212345678", "+372 12345678", "372 12345678", "372 123", "372 5123");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.invalidPhones);
    assertEquals(6, result.invalidPhones.size());
    assertEquals(0, result.validPhonesByCountry.size());
    assertEquals(phoneNumbers, result.invalidPhones);
  }

  @Test
  public void shouldValidateSuccessfullyEstoniaNumber() {
    List<String> phoneNumbers = List.of("37251234567", "+37251234567", "372 51234567",
            "+372 51234567", "+372(5)1234567", "+372 512 34 567", "+372-512-34-567", "3725123456");

    ValidationResultDto result = validator.validate(phoneNumbers);

    assertNotNull(result);
    assertNotNull(result.validPhonesByCountry);
    assertNotNull(result.validPhonesByCountry.get("EE"));
    assertNotNull(result.invalidPhones);
    assertEquals(1, result.validPhonesByCountry.size());
    assertEquals(8, result.validPhonesByCountry.get("EE").size());
    assertEquals(0, result.invalidPhones.size());

  }

}