package lab3.phase;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhaseApplication.class, args);
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
