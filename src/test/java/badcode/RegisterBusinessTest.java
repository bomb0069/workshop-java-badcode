package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    // Test To Pass
    @Test
    @DisplayName("ใส่ Speaker ที่ถูกต้องจะได้ ID ตาม Repository")
    public void casePass01 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(1, actualResult);
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 2 ปี จะได้ Registration Fee ที่ 250")
    public void casePass02 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(2);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(250, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 1 ปี จะได้ Registration Fee ที่ 500")
    public void casePass03 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(1);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(500, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 5 ปี จะได้ Registration Fee ที่ 100")
    public void casePass04 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(5);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(100, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 9 ปี จะได้ Registration Fee ที่ 50")
    public void casePass05 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(9);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(50, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 3 ปี จะได้ Registration Fee ที่ 250")
    public void casePass06 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(3);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(250, speaker.getRegistrationFee());
    }

    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 4 ปี จะได้ Registration Fee ที่ 100")
    public void casePass07 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(4);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(100, speaker.getRegistrationFee());
    }


    @Test
    @DisplayName("ใส่ Exp ให้ Speaker 8 ปี จะได้ Registration Fee ที่ 50")
    public void casePass08 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Karan");
        speaker.setLastName("Sivarat");
        speaker.setEmail("bomb0069@gmail.com");
        speaker.setExp(8);
        int actualResult = registerBusiness.register(new FirstIdSpeakerRepository(), speaker);

        assertEquals(50, speaker.getRegistrationFee());
    }
    // Test To Fail
    @Test
    @DisplayName("ไม่ทำการกำหนดชื่อ จะเกิด Exception First name is required.")
    public void caseFail01 () {
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
    public void caseFail02 () {
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
    public void caseFail03 () {
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
    public void caseFail04 () {
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
    public void caseFail05 () {
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
    public void caseFail06 () {
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

    @Test
    @DisplayName("ใช่ชื่อเป็นค่าว่าง จะเกิด Exception First name is required.")
    public void caseFail07 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("");
            registerBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("First name is required.",argumentNullException.getMessage());
        }
    }


    @Test
    @DisplayName("ใช่นามสกุลเป็นค่าว่าง จะเกิด Exception Last name is required.")
    public void caseFail08 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("");
            registerBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("Last name is required.",argumentNullException.getMessage());
        }
    }


    @Test
    @DisplayName("ใส่อีเมลล์เป็นค่าว่าง จะเกิด Exception Email is required.")
    public void caseFail09 () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        try {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Karan");
            speaker.setLastName("Sivarat");
            speaker.setEmail("");
            registerBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException argumentNullException) {
            assertEquals("Email is required.",argumentNullException.getMessage());
        }
    }
}

class FirstIdSpeakerRepository implements SpeakerRepository {
        @Override
        public Integer saveSpeaker(Speaker speaker) {
            return 1;
        }
}