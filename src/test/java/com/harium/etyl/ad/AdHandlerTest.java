package com.harium.etyl.ad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class AdHandlerTest {

    AdHandler adHandler;

    @Before
    public void setUp() {
        adHandler = mock(AdHandler.class);
    }

    @Test
    public void testDummy() {
        Assert.assertNotNull(adHandler);
    }

}
