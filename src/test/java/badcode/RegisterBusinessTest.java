package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    // Test To Pass
    @Test
    @DisplayName("ใส่ Speaker ที่ถูกต้องจะได้ ID ตาม Repository")
    public void case05 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        int actualResult = registerBusiness.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1;
            }
        }, speaker);

        assertEquals(1, actualResult);
    }

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


    @Test
    @DisplayName("Email doesn't gmail or live จะเกิด SpeakerDoesntMeetRequirementsException -> Speaker doesn't meet our standard rules.")
    public void case06 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("Sivarat");
            speaker.setEmail("bomb0069@scrum123.com");
            registerBusiness.register(null, speaker);
            fail();
        } catch (SpeakerDoesntMeetRequirementsException speakerDoesntMeetRequirementsException) {
            assertEquals("Speaker doesn't meet our standard rules.",speakerDoesntMeetRequirementsException.getMessage());
        }
    }


    @Test
    @DisplayName("Email ผิด Format จะขึ้น DomainEmailInvalidException")
    public void case07 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("Sivarat");
            speaker.setEmail("bomb0069");
            registerBusiness.register(null, speaker);
            fail();
        } catch (DomainEmailInvalidException domainEmailInvalidException) {
        }
    }

}