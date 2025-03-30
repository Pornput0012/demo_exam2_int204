package sit.kmutt.demo_exam2_int204;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sit.kmutt.demo_exam2_int204.configs.FileStorageProperties;
import sit.kmutt.demo_exam2_int204.utils.ListMapper;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class DemoExam2Int204Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoExam2Int204Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ListMapper listMapper() {
        return ListMapper.getInstance();
    }
}
