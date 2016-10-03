package com.example.simonjang.activities_excercisecomplete;

import android.os.Bundle;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Excercises: Testing
 * TODO: Generate some tests for your application to see if basic testing is possible (not with activities).
 */

@RunWith(JUnit4.class)
public class Activity1Tests {
    private int number1;
    private int number2;
    private int sum, product;

    @Before
    public void initiate() {
        number1= 2;
        number2= 2;
        sum = number1 + number2;
        product = number1 * number2;
    }

    @Test
    public void checkValue() {
        Assert.assertEquals(4, sum);
        Assert.assertEquals(4, product);
    }
}
