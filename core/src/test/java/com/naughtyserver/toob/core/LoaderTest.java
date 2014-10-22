package com.naughtyserver.toob.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoaderTest {

    private Loader underTest;

    @Test
    public void loadShouldLoad(){
        assertTrue(new Loader().load() != null);
    }
    @Test
    public void shouldReturnString(){
        underTest = new Loader();
        assertThat(underTest.load(), equalTo("tubeList"));
    }
}