package com.kosasih.filink;

import com.kosasih.filink.FilinkApp;
import com.kosasih.filink.config.AsyncSyncConfiguration;
import com.kosasih.filink.config.EmbeddedElasticsearch;
import com.kosasih.filink.config.EmbeddedKafka;
import com.kosasih.filink.config.EmbeddedSQL;
import com.kosasih.filink.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { FilinkApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
