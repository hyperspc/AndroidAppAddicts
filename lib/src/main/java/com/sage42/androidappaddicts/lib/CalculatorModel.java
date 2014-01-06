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

/**
 * This is a contrived example mention to show how to test via gradle and junit.
 *
 */
public class CalculatorModel
{
    /**
     * Returns the sum of the supplied 2 integers.
     * 
     * @param operandA
     * @param operandB
     * @return
     */
    public static int add(final int operandA, final int operandB)
    {
        return operandA + operandB;
    }

}