package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        /**
         * 싱글톤 패턴
         * 
         * 클래스의 인스턴스가 한개만 되도록 보장하는 패턴
         * 
         */

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1=" + singletonService1);
        System.out.println("singletonService2=" + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }

}