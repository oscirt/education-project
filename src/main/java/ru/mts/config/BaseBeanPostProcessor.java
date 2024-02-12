package ru.mts.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.service.CreateAnimalServiceImpl;
import ru.mts.service.interfaces.CreateAnimalService;

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
