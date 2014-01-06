/**
 *  Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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
