package lt.msi2015.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(userDetailsService);
    }
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
//	  http
//      .csrf().disable()
//      .authorizeRequests()
//      .antMatchers(HttpMethod.POST, "/login/**").fullyAuthenticated()
////        .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
////        .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
// 
//        .and()
//      .httpBasic().and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  
//	  http
//      .csrf().disable()
//      .authorizeRequests()
//      .antMatchers(HttpMethod.POST, "/login/**").fullyAuthenticated()
////        .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
////        .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
// 
//        .and()
//      .httpBasic().and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http
	  .csrf().disable()
      .httpBasic()
    .and()
      .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/login/**").authenticated()
        .anyRequest().permitAll().and()
       .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
       .csrf().csrfTokenRepository(csrfTokenRepository());
	  
	  //THIS WORKS
	  /*http
      .csrf().disable()
      .authorizeRequests()
//        .antMatchers(HttpMethod.POST, "/points/**").fullyAuthenticated()
//        .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
//        .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
        .anyRequest().fullyAuthenticated()
        .and()
      .httpBasic().and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
  }
  
  private CsrfTokenRepository csrfTokenRepository() {
	HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	repository.setHeaderName("X-XSRF-TOKEN");
	return repository;
  }
}