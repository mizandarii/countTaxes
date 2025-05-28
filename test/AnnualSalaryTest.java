import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AnnualSalaryTest {

    private static AnnualSalary obj = new AnnualSalary();

    private double salary;
    private int experience;
    private double[] expected;
    private Class<? extends Throwable> expectedException;

    public AnnualSalaryTest(double salary, int experience, double[] expected, Class<? extends Throwable> expectedException) {
        this.salary = salary;
        this.experience = experience;
        this.expected = expected;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters(name = "{index}: Annual({0}, {1}) => {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1000, 1, new double[]{12000, 4400, 913.44}, null},
                {1000, 25, new double[]{12000, 6000, 913.44}, null}, 
                {1000, 25, new double[]{12000, 6000, 913.44}, null},
                {1, 1, new double[]{12, 4.4, 0}, null},
                {121023940, 1, new double[]{1452287280, 532505336.00, 319503201.60}, null},
                {500.01, 1, new double[]{6000.12, 2200.04, 0}, null},
                {0, 1, new double[]{0, 0, 0}, null},
                {1000, 4, new double[]{12000, 4400, 913.44}, null},
                {1000, 5, new double[]{12000, 4800, 913.44}, null},
                {1000, 9, new double[]{12000, 4800, 913.44}, null},
                {1000, 10, new double[]{12000, 6000, 913.44}, null},
                {1000, 100, new double[]{12000, 6000, 913.44}, null},

                // негативный оклад дает ошибку
                {-500, 1, null, IllegalArgumentException.class},

                // негативный опыт дает ошибку
                {1000, -1, null, IllegalArgumentException.class},
        });
    }

    @Test
    public void testAnnual() {
        if (expectedException != null) {
            try {
                obj.Annual(salary, experience);
                Assert.fail("Expected exception: " + expectedException.getName());
            } catch (Throwable e) {
                Assert.assertTrue("Expected exception of type: " + expectedException.getName(),
                        expectedException.isInstance(e));
            }
        } else {
            double[] result = obj.Annual(salary, experience);
            Assert.assertArrayEquals(expected, result, 0.00001);
        }
    }
}
