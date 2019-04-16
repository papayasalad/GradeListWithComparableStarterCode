public class Grade implements Comparable<Grade> {
    private String student;
    private double grade;

    Grade(String student, double grade) {
        this.student = student;
        this.grade = grade;
    }

    public String toLetterGrade() {
        // >= 90 is a A, 80-89 B, 70-79 C, 60-69 D, < 60 F
        if (this.grade >= 90) {
            return "A";
        } else if (this.grade >= 80) {
            return "B";
        } else if (this.grade >= 70) {
            return "C";
        } else if (this.grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getStudent() {
        return this.student;
    }

    public double getGrade() {
        return this.grade;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.student + ":" + this.grade);
        return res.toString();
    }

    public int compareTo(Grade other) {
        // Don't forget anything else that might be missing in this class for this function to be called correctly.
        return Double.compare(this.grade, other.grade);
    }

}
