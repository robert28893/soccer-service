package vn.unigap.java.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	@Bean
	@Order(1)
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, ObjectMapper objectMapper)
			throws Exception {
		http
				.headers(header -> header.frameOptions(frame -> frame.disable()))
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers(
								new AntPathRequestMatcher("/h2-console/**"),
								new AntPathRequestMatcher("/"),
								new AntPathRequestMatcher("/test/test")
//								new AntPathRequestMatcher("/competition/**")
						).permitAll()
						.anyRequest().authenticated()
				)
				// Form login handles the redirect to the login page from the
				// authorization server filter chain
//                .formLogin(Customizer.withDefaults())
				.oauth2ResourceServer(resourceServer ->
								resourceServer
										.accessDeniedHandler(new CustomAccessDeniedHandler(objectMapper))
										.authenticationEntryPoint(new CustomAuthenticationEntryPoint(objectMapper))
										.jwt(jwtConfigurer -> jwtConfigurer.jwkSetUri("http://localhost:8051/oauth2/jwks"))
//										.jwt(Customizer.withDefaults())
				);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}

