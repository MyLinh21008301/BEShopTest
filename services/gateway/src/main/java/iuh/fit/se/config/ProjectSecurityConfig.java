//package iuh.fit.se.config;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
////import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//
//
//@Configuration
////@EnableWebSecurity
//@RequiredArgsConstructor
//@Slf4j
//public class ProjectSecurityConfig {
//	
//	private final iuh.fit.se.dto.CorsPropertiesDto corsProperties;
//	
////	@Bean
////    SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
////		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
////		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakConverter());
////		
////		
////		ReactiveJwtAuthenticationConverterAdapter reactiveJwtConverter =
////		        new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
////		
////		http
////			.cors(corsCfg -> corsCfg.configurationSource(corsConfigurationSource()))
////			.addFilterAt((exchange, chain) -> {
////		    return exchange.getPrincipal()
////		        .doOnNext(principal -> {
////		            if (principal instanceof Authentication auth) {
////		                log.info("User Authorities: {}", auth.getAuthorities());
////		            } else {
////		                log.info("No Authentication found in Principal: {}", principal);
////		            }
////		        })
////		        .then(chain.filter(exchange));
////		}, SecurityWebFiltersOrder.CORS);
////
////        http
////        	.securityContextRepository(NoOpServerSecurityContextRepository.getInstance()) // Tránh lưu session
////            .csrf(Customizer.withDefaults())
////            .authorizeExchange(authorize -> authorize
////                    .pathMatchers("/actuator/**").permitAll() // Mở quyền truy cập Actuator
////                    .anyExchange().authenticated()
////                );
////        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(reactiveJwtConverter)));
////        return http.build();
////    }
//	
////	@Bean
////	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
////		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakConverter());
////		http.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()));
////		http.addFilterAfter( 
////				new CustomAuthenticationFilter()
////		    , CorsFilter.class);
////		http
//////			.securityContext(NoOpServerSecurityContextRepository.getInstance()) // Tránh lưu session
////			.csrf(c -> c.disable())
////			.authorizeHttpRequests(authorize -> authorize
////				.requestMatchers("/actuator/**").permitAll() // Mở quyền truy cập Actuator
////				.anyRequest().permitAll() 
////			);
////		http.oauth2ResourceServer(oauth2 -> oauth2
////			.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));
////		return http.build();
////	}
////	
////	
////	@Bean
////    CorsConfigurationSource corsConfigurationSource() {
////        CorsConfiguration corsConfig = new CorsConfiguration();
////        corsConfig.setAllowedOrigins(corsProperties.getAllowedOrigins()); // Cho phép frontend truy cập
////        corsConfig.setAllowedMethods(corsProperties.getAllowedMethods());
////        corsConfig.setAllowedHeaders(List.of("*"));
////        corsConfig.setAllowCredentials(true);
////
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", corsConfig);
////        return source;
////    }
//}
