package main.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneValidatorTest {

    @Test
    public void invalidPhoneReturnsFalse() {
        try {
            Assert.assertFalse(PhoneValidator.isValidNumber("+12345678"));
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validPhoneReturnsTrue() {
        try {
            Assert.assertTrue(PhoneValidator.isValidNumber("+50660312389"));
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
    }
}
