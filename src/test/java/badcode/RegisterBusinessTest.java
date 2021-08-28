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


    @Test
    @DisplayName("ไม่ทำการกำหนดอีเมลล์ จะเกิด Exception Email is required.")
    public void case03 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("Sivarat");
            registerBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("Email is required.",argumentNullException.getMessage());
        }
    }

    @Test
    @DisplayName("Repository เป็น Null จะเกิด SaveSpeakerException Can't save a speaker.")
    public void case04 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("Sivarat");
            speaker.setEmail("bomb0069@gmail.com");
            registerBusiness.register(null, speaker);
            fail();
        } catch (SaveSpeakerException saveSpeakerException) {
            assertEquals("Can't save a speaker.",saveSpeakerException.getMessage());
        }
    }

}