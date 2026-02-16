
public class ScholarshipServiceStub implements ScholarshipService {

    private static final double ELIGIBILITY_THRESHOLD = 3.5;
    private static final double HIGH_TIER_THRESHOLD = 3.8;
    private static final double HIGH_TIER_AMOUNT = 5000.0;
    private static final double BASE_TIER_AMOUNT = 3000.0;

    @Override
    public boolean isEligible(double gpa) {
        return gpa >= ELIGIBILITY_THRESHOLD;
    }

    @Override
    public double getAmount(double gpa) {
        if (gpa >= HIGH_TIER_THRESHOLD) {
            return HIGH_TIER_AMOUNT;
        }
        if (gpa >= ELIGIBILITY_THRESHOLD) {
            return BASE_TIER_AMOUNT;
        }
        return 0.0;
    }
}
