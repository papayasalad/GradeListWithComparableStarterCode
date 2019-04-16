import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grades {
    private List<Grade> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void readGrades(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNext()) {
            String studentName = scan.next();
            studentName = studentName.substring(0,studentName.length() - 1);
            double studentGrade = (Double.parseDouble(scan.next()));

            Grade grade = new Grade(studentName, studentGrade);
            grades.add(grade);
        }
    }

    public double calcAverage() {
        double total = 0.0;
        for (Grade grade : grades) {
            total += grade.getGrade();
        }
        return total / grades.size();
    }

    public Double dropLowest() {
        Grade lowest = grades.get(0);
        double minGrade = grades.get(0).getGrade();
        for (Grade grade : grades) {
            if (grade.getGrade() < minGrade) {
                lowest = grade;
            }
        }
        grades.remove(lowest);
        return lowest.getGrade();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    //return grades.removeAll(Collections.singleton(grade));
    public boolean removeAllGrades(double grade) {
        boolean found = false;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getGrade() == grade) {
                grades.remove(i);
                i--;
                found = true;
            }
        }
        return found;
    }

    // Collections.sort sorts the input list as a side-effect, which I didn't prefer
    // So I created a copy and sorted that.
    // You could also just sort grades.
    public void printSortedGrades() {
        List<Grade> gradesCopy = new ArrayList<>(grades);
        Collections.sort(gradesCopy);
        System.out.println(gradesCopy);
    }

    public void printGradeBreakdown() {
        // e.g. A: 7, B: 5, C: 2, D: 1, F: 1
        int[] cnt = new int[5];
        for (int i = 0; i < grades.size(); i++) {
            String letter = grades.get(i).toLetterGrade();
            if (letter.equalsIgnoreCase("A")) {
                cnt[0]++;
            } else if (letter.equalsIgnoreCase("B")) {
                cnt[1]++;
            } else if (letter.equalsIgnoreCase("C")) {
                cnt[2]++;
            } else if (letter.equalsIgnoreCase("D")) {
                cnt[3]++;
            } else {
                cnt[4]++;
            }
        }
        System.out.printf("A: %d, B: %d, C: %d, D: %d, F: %d", cnt[0], cnt[1], cnt[2], cnt[3], cnt[4]);
    }

    public String getStudentWithHighestGrade() {
        String res = grades.get(0).getStudent();
        Double highestGrade = grades.get(0).getGrade();
        for (Grade grade : grades) {
            if (grade.getGrade() > highestGrade) {
                res = grade.getStudent();
            }
        }
        return res;
    }

    // Simplest version of toString() for this method
//    public String toString() {
//        return grades.toString();
//    }

    // Using StringBuilder rather than less efficient string concatentation
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < grades.size() - 1; i++) {
            result.append(grades.get(i).getStudent() + ":" + grades.get(i).getGrade());
            result.append(", ");
        }
        result.append(grades.get(grades.size() - 1).getStudent() + ":" + grades.get(grades.size() - 1).getGrade());
        result.append("]");

        return result.toString();
    }

}

