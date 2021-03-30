package com.zy.store;

import com.zy.store.utils.LRUCacheUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLRUCache(){
        String testkey = (String) LRUCacheUtils.getInstance().getValue("testkey");
        LRUCacheUtils.getInstance().putValue("testkey","hello world");

        assertEquals(LRUCacheUtils.getInstance().getValue("testkey"),"hello world");
    }
}