package sg.edu.rp.c346.id22024044.lesson_13_sgpolyenrolement;

public class Enrolment {
    private String year;
    private String typeOfStudy;
    private String enrolment;

    public Enrolment(String year, String typeOfStudy, String enrolment) {
        this.year = year;
        this.typeOfStudy = typeOfStudy;
        this.enrolment = enrolment;
    }

    public String getYear() {
        return year;
    }

    public String getTypeOfStudy() {
        return typeOfStudy;
    }

    public String getEnrolment() {
        return enrolment;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTypeOfStudy(String typeOfStudy) {
        this.typeOfStudy = typeOfStudy;
    }

    public void setEnrolment(String enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public String toString() {
        return "Year: " + year +
                "\nStudy Type: " + typeOfStudy +
                "\nTotal Enrolment Count: " + enrolment;
    }
}
