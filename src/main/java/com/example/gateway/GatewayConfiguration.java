package com.example.gateway;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
//	private static final String RESOURCE_ID = "gateway-service";
//	
//		
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(RESOURCE_ID).stateless(true);
//	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	    http.
	            anonymous().disable()
	            .authorizeRequests()
	            .antMatchers("/oauth-service/**").permitAll()
	            //.antMatchers("/api/users/**").access("hasRole('ADMIN')")
	            .antMatchers("/users/**").authenticated()
	            .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
//	@Override
//	public void configure(final HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("user-service/oauth/**").permitAll()
//		.antMatchers("user-service/api/**").authenticated()
//		.antMatchers("/**").permitAll();
//	}
}*/ 

@Configuration
@EnableResourceServer
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/oauth-service/**")
    .permitAll()
          .antMatchers("/user-service/**")
          .hasRole("ADMIN")
          .antMatchers("/**")
      .authenticated();
    //http.cors();
//    http.addFilterBefore(authenticationTokenFilterBean(),
//			   UsernamePasswordAuthenticationFilter.class);
    }
    
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("OPTIONS");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
//        bean.setOrder(0);
//        
//        return new CorsFilter(source);
//    }
    
    
    // new addition
//  @Bean
//  public JwtAuthenticationFilter authenticationTokenFilterBean() throws 
//            Exception {
//      return new JwtAuthenticationFilter();
//  }
}