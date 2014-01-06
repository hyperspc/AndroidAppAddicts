package com.sage42.androidappaddicts.lib;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sage42.androidappaddicts.lib.CalculatorModel;

/**
 * Simpel Tests for the CalculatorModel, using jUnit4 and Hamcrest
 *
 */
public class CalculatorModelTest
{
    /**
     * These tests are all very simple and probably not worth testing normally as the method could considered "too simple to break".
     * That said, the tests where fast to write and run so they come at very low cost.
     */
    @Test
    public void testAdd()
    {
        // check the 1 + 1 = 2
        assertThat(CalculatorModel.add(1, 1), is(2));

        // check the method handles 0's
        assertThat(CalculatorModel.add(0, 1), is(1));
        assertThat(CalculatorModel.add(1, 0), is(1));
        assertThat(CalculatorModel.add(0, 0), is(0));

        // check that it can handle negatives
        assertThat(CalculatorModel.add(-1, 1), is(0));
        assertThat(CalculatorModel.add(1, -1), is(0));
        assertThat(CalculatorModel.add(-1, -1), is(-2));
    }

}
