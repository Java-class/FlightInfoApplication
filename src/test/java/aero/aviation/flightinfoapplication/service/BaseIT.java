package aero.aviation.flightinfoapplication.service;

import aero.aviation.flightinfoapplication.FlightInfoApplication;
import org.junit.ClassRule;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-14 16:03
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = FlightInfoApplication.class)
@Testcontainers
public class BaseIT {

    public static final DockerImageName POSTGRES_IMAGE = DockerImageName.parse("postgres:latest");

    @Container
    @ClassRule
    public static GenericContainer<?> postgres = new GenericContainer<>(POSTGRES_IMAGE)
            .withEnv("POSTGRES_USER", "postgres")
            .withEnv("POSTGRES_PASSWORD", "12345ma")
            .withExposedPorts(5432);

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", BaseIT::getJdbcUrl);
        registry.add("spring.datasource.username", () -> "postgres");
        registry.add("spring.datasource.password", () -> "12345ma");
    }

    private static String getJdbcUrl() {
        return "jdbc:postgresql://" +
                postgres.getHost() +
                ":" +
                postgres.getMappedPort(5432) +
                "/" + "postgres";
    }
}
