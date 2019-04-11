import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGrades {
    private Grades grades = new Grades();
    private static final List<Double> initialData = Arrays.asList(
            34.0, 23.0, 10.5, 88.0, 23.0, 23.0, 23.0, 90.5
    );

    @Before
    public void setUp() throws FileNotFoundException {
        grades.readGrades("src/main/resources/grades.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadGradesBadPath() throws FileNotFoundException {
        grades.readGrades("badfilepath.txt");
    }

    @Test
    public void testReadGrades() {
        Assert.assertEquals(initialData, grades.getGrades());
    }

    @Test
    public void testAverage() {
        Assert.assertEquals(39.375, grades.calcAverage(), .1);
    }

    @Test
    public void dropLowest() {
        List<Double> data = new ArrayList<>(initialData);
        data.remove(10.5);

        Assert.assertEquals(10.5, grades.dropLowest(), .1);
        Assert.assertEquals(data, grades.getGrades());
    }

    @Test
    public void addGrade() {
        List<Double> data = new ArrayList<>(initialData);
        data.add(100.0);

        grades.addGrade(100);
        Assert.assertEquals(data, grades.getGrades());
    }

    @Test
    public void removeGrades() {
        List<Double> data = Arrays.asList(
                34.0, 10.5, 88.0, 90.5
        );

        grades.removeAllGrades(23);
        Assert.assertEquals(data, grades.getGrades());
    }

    @Test
    public void testString() {
        Assert.assertEquals(
                "[34.0, 23.0, 10.5, 88.0, 23.0, 23.0, 23.0, 90.5]",
                grades.toString()
        );
    }

}
