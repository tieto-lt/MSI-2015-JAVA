package lt.msi2015.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	UserDetailsService userService = new UserDetailsService();
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
	  http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/points/**").authenticated()
//        .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
//        .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
        .anyRequest().permitAll()
        .and()
      .httpBasic().and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
}