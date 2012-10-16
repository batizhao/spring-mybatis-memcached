package me.batizhao.cache;

import me.batizhao.dao.BaseDaoTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(
        locations={"classpath:/applicationContext.xml",
                "classpath:/applicationContext-cache.xml"
        })
public class CounterTest{

    private final Log log = LogFactory.getLog(CounterTest.class);

    @Autowired
    Counter test;

    @Test
    public void test() throws InterruptedException {
        String key = "my2-counter-key";
        log.info(test.getCounter(key));
        assertEquals(100L, test.getCounter(key));

        test.increment(key);
        log.info(test.getCounter(key));
        assertEquals(101L, test.getCounter(key));

        long value = 777L;
        test.update(key, value);
        Thread.sleep(100);
        log.info(test.getCounter(key));
        assertEquals(value, test.getCounter(key));

        test.decrement(key);
        log.info(test.getCounter(key));
        assertEquals(776L, test.getCounter(key));
    }
}
