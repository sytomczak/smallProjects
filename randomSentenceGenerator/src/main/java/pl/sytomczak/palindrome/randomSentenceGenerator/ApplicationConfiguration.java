package pl.sytomczak.palindrome.randomSentenceGenerator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pl.sytomczak.randomSentenceGenerator")
public class ApplicationConfiguration implements WebMvcConfigurer {
}
