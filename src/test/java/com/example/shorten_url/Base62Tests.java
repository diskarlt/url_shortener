package com.example.shorten_url;

import com.example.shorten_url.util.Base62Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Base62Tests {
    @Autowired
    Base62Util base62Util;

    @Test
    public void encodingTest() throws Exception {
        assertEquals(base62Util.Encode(1L), "00000001");
        assertEquals(base62Util.Encode(10L), "0000000a");
        assertEquals(base62Util.Encode(36L), "0000000A");
        assertEquals(base62Util.Encode(62L), "00000010");
    }
}
