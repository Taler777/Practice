package spring_test.conf;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import spring_test.Sample;


@Configuration // класс конфигурации нашего mvc-приложения
@EnableWebMvc
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp"); // расширение файлов из папки webapp/WEB-INF/jsp
        resolver.setPrefix("/WEB-INF/jsp/"); // путь до наших файлов
        resolver.setViewClass(JstlView.class); // класс, представляющий наши страницы
        return resolver;
    }

    @Bean
    public Sample getSample() {
        return new Sample();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/users");
        dataSource.setUsername("root");
        dataSource.setPassword("734734");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
