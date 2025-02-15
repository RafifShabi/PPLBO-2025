import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class TestcontainersConfiguration {

    @Bean
    public GenericContainer<?> myContainer() {
        return new GenericContainer<>(DockerImageName.parse("my-image:latest"))
                .withExposedPorts(8080);
    }
}