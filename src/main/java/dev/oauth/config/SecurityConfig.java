package dev.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize, @PostAuthorize
public class SecurityConfig {

    // application.yml에 작성된 값을 가져오기
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer_uri}")
    private String issuerUri; // 매칭을 잘 했다면, 해당 필드에 값이 초기화됨

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println(issuerUri);
        // TODO: jwt 토큰 방식으로 적용될 수 있는 설정

        http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated());

        // 빈으로 등록했던 JWTDecoder(jwtDecoder())를 oauth2 모듈에 적용
        http.oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())));

        return http.build();
    }

    // TODO: 토큰 디코딩해주는 스프링 빈 등록
    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }
}
