package main.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneValidator {
    static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    public static boolean isValidNumber( final String phoneNumber ) throws NumberParseException {
        Phonenumber.PhoneNumber phone = parsePhoneNumber(phoneNumber);

        return phoneNumberUtil.isValidNumber(phone);
    }

    public static Phonenumber.PhoneNumber parsePhoneNumber( final String phoneNumber ) throws NumberParseException {
        return phoneNumberUtil.parse(phoneNumber,
                Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
    }
}
