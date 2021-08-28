package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    // Test To Pass

    // Test To Fail
    @Test
    @DisplayName("ไม่ทำการกำหนดชื่อ จะเกิด Exception First name is required.")
    public void case01 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            registerBusiness.register(null, new Speaker());
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("First name is required.",argumentNullException.getMessage());
        }
    }

    @Test
    @DisplayName("ไม่ทำการกำหนดนามสกุล จะเกิด Exception Last name is required.")
    public void case02 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            registerBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("Last name is required.",argumentNullException.getMessage());
        }
    }

}