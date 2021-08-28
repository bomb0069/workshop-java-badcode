package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeakerGetRegistrationFeeTest {
    @Test
    @DisplayName("ทดสอบ getFee ตาม Experience")
    public void getFee () {
        Speaker speaker = new Speaker();
        speaker.setExp(0);
        assertEquals(500, speaker.getRegistrationFee());

        speaker.setExp(1);
        assertEquals(500, speaker.getRegistrationFee());

        speaker.setExp(2);
        assertEquals(250, speaker.getRegistrationFee());

        speaker.setExp(3);
        assertEquals(250, speaker.getRegistrationFee());

        speaker.setExp(4);
        assertEquals(100, speaker.getRegistrationFee());

        speaker.setExp(5);
        assertEquals(100, speaker.getRegistrationFee());

        speaker.setExp(8);
        assertEquals(50, speaker.getRegistrationFee());

        speaker.setExp(9);
        assertEquals(50, speaker.getRegistrationFee());

        speaker.setExp(10);
        assertEquals(0, speaker.getRegistrationFee());
    }


}