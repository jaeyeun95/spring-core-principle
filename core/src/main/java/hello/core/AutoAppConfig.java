package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 어노테이션이 있는 것들을 스캔해주는 어노테이션
@ComponentScan(
        // 어디경로로부터 찾을지 설정 -> hello.core.member 에 있는 @Component 어노테이션만 인식
        // 지정하지 않으면 @ComponentScan이 붙은 설정정보 클래스의 패키지가 basePackage 가 된다
//        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return  new MemoryMemberRepository();
    }*/
}
