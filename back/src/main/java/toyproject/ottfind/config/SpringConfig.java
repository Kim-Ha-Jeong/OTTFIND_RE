package toyproject.ottfind.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
}
