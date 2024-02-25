package SpringSecurity.Java_Online_Shop.configs;


import SpringSecurity.Java_Online_Shop.services.UserService;
import SpringSecurity.Java_Online_Shop.services.impls.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigs {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoderNew() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoderNew());
        httpSecurity.exceptionHandling(
                exception -> exception.accessDeniedPage("/errorPage")
        );

        httpSecurity.authorizeRequests(
                authorize -> authorize
                        .requestMatchers("/sign_in", "/auth").anonymous()
                        .requestMatchers("/logout").authenticated()
                        .requestMatchers("/profile").authenticated()
                        .requestMatchers("/adminPanel").hasAuthority("ROLE_ADMIN")
                        .anyRequest().permitAll()
        ).formLogin(
                login -> login
                        .loginProcessingUrl("/auth")
                        .defaultSuccessUrl("/steam/")
                        .loginPage("/steam//sign_in")
                        .failureUrl("/steam/sign_in?error")
                        .usernameParameter("email")
                        .passwordParameter("password")
        ).logout(
                logout -> logout
                        .logoutUrl("/steam/logout")
                        .logoutSuccessUrl("/steam/sign_in?logout")
        ).csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}
