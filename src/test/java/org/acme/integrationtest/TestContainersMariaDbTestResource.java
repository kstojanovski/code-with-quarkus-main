package org.acme.integrationtest;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MariaDBContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class TestContainersMariaDbTestResource {

    public static class TestContainersMariaDbInitializer implements QuarkusTestResourceLifecycleManager {
        private MariaDBContainer mariaDBContainer;

        @Override
        public Map<String, String> start() {
            this.mariaDBContainer = new MariaDBContainer<>("mariadb:10.8.3");
            this.mariaDBContainer.start();
            return configurationParameters();
        }

        private Map<String, String> configurationParameters() {
            final Map<String, String> configuration = new HashMap<>();
            configuration.put("quarkus.datasource.jdbc.url", this.mariaDBContainer.getJdbcUrl());
            configuration.put("quarkus.datasource.username", this.mariaDBContainer.getUsername());
            configuration.put("quarkus.datasource.password", this.mariaDBContainer.getPassword());
            return configuration;
        }

        @Override
        public void stop() {
            if (Objects.nonNull(this.mariaDBContainer)) {
                this.mariaDBContainer.close();
            }
        }

    }

}
