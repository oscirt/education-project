package org.example.animalsstarter.config;

import org.example.animalsstarter.service.CreateAnimalServiceImpl;
import org.example.animalsstarter.service.interfaces.CreateAnimalService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalService) {
            ((CreateAnimalServiceImpl) bean).initAnimalType();
        }
        return bean;
    }
}
