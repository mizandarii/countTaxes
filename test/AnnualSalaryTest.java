/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class AnnualSalaryTest {
    
    public AnnualSalaryTest() {
    }

    AnnualSalary obj = new AnnualSalary();
    @Test
    public void testAnnualRight() {
        double[] result = obj.Annual(2000, 6);
        double[] expected = {24000, 14000, 3553.44};
        Assert.assertArrayEquals(expected, result, 0.00001);
    }
    @Test
    public void testAnnual2Right() {
        double[] result = obj.Annual(1000, 12);
        double[] expected = {24000, 14000, 3553.44};
        Assert.assertArrayEquals(expected, result, 0.00001);
    }
        @Test
    public void testAnnual3Right() {
        double[] result = obj.Annual(2000, 6);
        double[] expected = {24000, 14000, 3553.44};
        Assert.assertArrayEquals(expected, result, 0.00001);
    }
        public void testAnnual4Wrong() {
        double[] result = obj.Annual(2000, 6);
        double[] expected = {24000, 14000, 3553.44};
        Assert.assertArrayEquals(expected, result, 0.00001);
    }
            public void testAnnual5Wrong() {
        double[] result = obj.Annual(2000, 6);
        double[] expected = {24000, 14000, 3553.44};
        Assert.assertArrayEquals(expected, result, 0.00001);
    }
    
}
