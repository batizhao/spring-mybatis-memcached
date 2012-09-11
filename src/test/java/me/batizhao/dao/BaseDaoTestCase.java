package me.batizhao.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Base class for running DAO tests.
 * @author mraible
 */
@ContextConfiguration(
        locations={"classpath:/applicationContext.xml"
        })
public abstract class BaseDaoTestCase extends AbstractJUnit4SpringContextTests {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

}
