package theatre.spring.config;

import theatre.spring.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/inject").permitAll()
                .antMatchers(HttpMethod.GET, "/performance",
                        "/performance-session", "/theatre-stage").hasAnyRole(Role.RoleName.ADMIN.name(),
                Role.RoleName.USER.name())
                .antMatchers(HttpMethod.POST,"/performance", "/performance-session", "/theatre-stage")
                .hasRole(Role.RoleName.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/by-email").hasRole(Role.RoleName.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/complete",
                        "/shopping-carts/performance-session").hasRole(Role.RoleName.USER.name())
                .antMatchers(HttpMethod.PUT, "/performance-session")
                .hasRole(Role.RoleName.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/performance-session")
                .hasRole(Role.RoleName.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
