//package az.edu.itbrains.ecommerce.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig2 {
//
//
//    @Autowired
//    @Qualifier("customAuthenticationEntryPoint")
//    AuthenticationEntryPoint authEntryPoint;
//
//    private static final String[] SWAGGER_WHITELIST = {
//            "/swagger-ui/**",
//            "/v3/api-doc/**",
//            "swagger/resources/**",
//            "swagger-resources"
//    };
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers(SWAGGER_WHITELIST).permitAll();
//                    request.requestMatchers("/**").permitAll();
//                    request.anyRequest().authenticated();
//                });
//        http.httpBasic(basic -> basic.authenticationEntryPoint(authEntryPoint))
//                .exceptionHandling(Customizer.withDefaults());
//        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//
//}
