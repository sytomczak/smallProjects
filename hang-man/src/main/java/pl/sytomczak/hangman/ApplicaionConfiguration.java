package pl.sytomczak.hangman;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pl.sytomczak.hangman")
public class ApplicaionConfiguration implements WebMvcConfigurer {
}
