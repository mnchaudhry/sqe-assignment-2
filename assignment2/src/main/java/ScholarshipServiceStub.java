// STUB - Simple hard-coded implementation
public class ScholarshipServiceStub implements ScholarshipService {

    @Override
    public boolean isEligible(double gpa) {
        return gpa >= 3.5;
    }

    @Override
    public double getAmount(double gpa) {
        if (gpa >= 3.8) {
            return 5000.0;
        } else if (gpa >= 3.5) {
            return 3000.0;
        }
        return 0.0;
    }
}
