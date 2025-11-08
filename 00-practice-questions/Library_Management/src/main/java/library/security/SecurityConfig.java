package library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails alice = User.builder()
//                .username("alice")
//                .password("{noop}123")
//                .roles("MEMBER")
//                .build();
//
//        UserDetails bob = User.builder()
//                .username("bob")
//                .password("{noop}123")
//                .roles("MEMBER", "LIBRARIAN")
//                .build();
//
//        UserDetails carol = User.builder()
//                .username("carol")
//                .password("{noop}123")
//                .roles("MEMBER", "LIBRARIAN","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(alice, carol, bob);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/books").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.GET,"/books/**").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.PUT,"/books/**").hasRole("LIBRARIAN")
                        .requestMatchers(HttpMethod.POST,"/books").hasRole("LIBRARIAN")
                        .requestMatchers(HttpMethod.PATCH,"/books/**").hasRole("LIBRARIAN")
                        .requestMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
