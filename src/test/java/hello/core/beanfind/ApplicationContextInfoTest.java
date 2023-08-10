package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

/**
 * ApplicationContextInfoTest
 */
class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();

        for (String def : BeanDefinitionNames) {
            Object object = ac.getBean(def);
            System.out.println("name = " + def + ", Object = " + object);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();

        for (String def : BeanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(def);

            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스피링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object object = ac.getBean(def);
                System.out.println("name = " + def + ", Object = " + object);
            }

        }
    }

    @Test
    @DisplayName("빈 출력하기")
    void findBeans() {

        for (String beanDefinitionName : ac.getBeanDefinitionNames()) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Name = " + beanDefinitionName + " / Object = " + bean);
            }

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Name = " + beanDefinitionName + " / Object = " + bean);
            }

        }

    }

}
