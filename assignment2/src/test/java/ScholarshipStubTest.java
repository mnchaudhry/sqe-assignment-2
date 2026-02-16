import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipStubTest {

    @Test
    void scholarshipEligibilityStub() {
        ScholarshipService service = new ScholarshipServiceStub();

        assertTrue(service.isEligible(3.6));
        assertFalse(service.isEligible(3.4));
    }

    @Test
    void scholarshipAmountStub() {
        ScholarshipService service = new ScholarshipServiceStub();

        assertEquals(5000.0, service.getAmount(3.9));
        assertEquals(3000.0, service.getAmount(3.6));
        assertEquals(0.0, service.getAmount(3.3));
    }
}
