// External service for scholarship calculation
public interface ScholarshipService {
    boolean isEligible(double gpa);
    double getAmount(double gpa);
}
