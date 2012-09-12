package me.batizhao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Base class for running DAO tests.
 * @author mraible
 */
@ContextConfiguration(
        locations={"classpath:/applicationContext.xml"
        })
public abstract class BaseDaoTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

}
