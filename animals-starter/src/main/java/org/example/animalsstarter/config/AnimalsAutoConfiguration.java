package org.example.animalsstarter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.animalsstarter")
@EnableConfigurationProperties(AnimalsProperties.class)
public class AnimalsAutoConfiguration {

}
