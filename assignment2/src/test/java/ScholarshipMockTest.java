import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScholarshipMockTest {

    @Test
    void mockSetupBehavior() {
        ScholarshipService service = mock(ScholarshipService.class);
        when(service.isEligible(3.6)).thenReturn(true);
        when(service.getAmount(3.6)).thenReturn(2000.0);

        assertTrue(service.isEligible(3.6));
        assertEquals(2000.0, service.getAmount(3.6));
    }

    @Test
    void mockVerifyCallsTimes() {
        ScholarshipService service = mock(ScholarshipService.class);

        service.isEligible(3.2);
        service.isEligible(3.2);

        verify(service, times(2)).isEligible(3.2);
        verify(service, never()).isEligible(3.8);
    }

    @Test
    void mockVerifyParameters() {
        ScholarshipService service = mock(ScholarshipService.class);

        service.getAmount(3.1);

        ArgumentCaptor<Double> captor = ArgumentCaptor.forClass(Double.class);
        verify(service).getAmount(captor.capture());
        assertEquals(3.1, captor.getValue());
    }
}
