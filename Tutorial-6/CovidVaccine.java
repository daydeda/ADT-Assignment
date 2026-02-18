import java.util.List;

public class CovidVaccine {
    private String sid;
    private String firstName;
    private String lastName;
    private List<String> previousVaccines;

    public CovidVaccine(String sid, String firstName, String lastName, List<String> previousVaccines) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.previousVaccines = previousVaccines;
    }

    public String getSid() {
        return sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPreviousVaccines() {
        return previousVaccines;
    }

    @Override
    public String toString() {
        return "SID: " + sid + ", Name: " + firstName + " " + lastName + ", Vaccines: " + previousVaccines;
    }
}
