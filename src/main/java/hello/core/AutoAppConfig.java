package hello.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

    // @Bean(name = "memoryMemberRepository")
    // MemberRepository memberRepository() {

    // return new MemoryMemberRepository();
    // }

    public static void main(String[] args) {

        Map<String, String> a = new HashMap<>();

        a.keySet().i;
    }

}
