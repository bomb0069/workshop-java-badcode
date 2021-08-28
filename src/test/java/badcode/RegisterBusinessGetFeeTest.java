package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessGetFeeTest {
    @Test
    @DisplayName("ทดสอบ getFee ตาม Experience")
    public void getFee () {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(500, registerBusiness.getFee(0));
        assertEquals(500, registerBusiness.getFee(1));
        assertEquals(250, registerBusiness.getFee(2));
        assertEquals(250, registerBusiness.getFee(3));
        assertEquals(100, registerBusiness.getFee(4));
        assertEquals(100, registerBusiness.getFee(5));
        assertEquals(50, registerBusiness.getFee(8));
        assertEquals(50, registerBusiness.getFee(9));
        assertEquals(0, registerBusiness.getFee(10));
    }


}