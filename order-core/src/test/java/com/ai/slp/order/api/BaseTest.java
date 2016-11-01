package com.ai.slp.order.api;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class BaseTest {
	public static final Logger log = LogManager.getLogger(BaseTest.class);

}
