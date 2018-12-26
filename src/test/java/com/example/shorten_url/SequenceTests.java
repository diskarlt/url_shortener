package com.example.shorten_url;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenceTests {
    @Test
    public void contextLoads() throws Exception {
        int a = 10;
        assertEquals(a, 10);
    }
}
