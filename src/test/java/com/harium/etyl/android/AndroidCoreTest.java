package com.harium.etyl.android;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AndroidCoreTest {

    AndroidCore engine;

    @Before
    public void setUp() {
        engine = new AndroidCore(0,0);
    }

    @Test
    public void testDummy() {
        Assert.assertNotNull(engine);
    }

}
