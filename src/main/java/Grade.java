public class Grade {
    private String student;
    private double grade;

    Grade(String student, double grade) {
        // TODO constructor that sets the student and grade fields
    }

    public String toLetterGrade() {
        // TODO return the letter grade corresponding to the grade field
        // >= 90 is a A, 80-89 B, 70-79 C, 60-69 D, < 60 F
        return null;
    }

    public String getStudent() {
        // TODO getter for the student field
        return null;
    }

    public double getGrade() {
        // TODO getter for the grade field
        return 0.0;
    }

    public String toString() {
        // TODO return a useful representation of the object, including the name and grade fields
        return null;
    }

    public int compareTo(Grade other) {
        // TODO implement compareTo.
        // Don't forget anything else that might be missing in this class for this function to be called correctly.
        return 0;
    }

}
