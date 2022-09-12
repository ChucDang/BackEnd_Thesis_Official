package thud.luanvanofficial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import thud.luanvanofficial.enums.Role_Enum;
import thud.luanvanofficial.security.UserDetailServiceIml;
import thud.luanvanofficial.util.CustomPasswordEncoder;
import thud.luanvanofficial.service.JwtFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceIml userDetailsService;
    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

        // configure authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
    }
        // configure web security
    @Override
    protected void configure(HttpSecurity http) throws Exception {

       // Enable CORS and disable CSRF
       http = http.cors().and().csrf().disable();
    


        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                
                .antMatchers("/api/auth/**").permitAll()
                // order là enpoint sử dụng bảo mật cấp method, do có một số method cần public cho customer.
                // nên đặt permitAll
                .antMatchers("/order/**").permitAll()
                .antMatchers("/invoice/saveInvoice/**").permitAll()
                .antMatchers("/categories/**").permitAll()
                .antMatchers("/api/products/**").permitAll()

        // Private enpoint
                .antMatchers("/cart/addCart").hasAuthority(Role_Enum.ROLE_CUSTOMER.toString())
                .antMatchers("/stock/**").hasAnyAuthority(Role_Enum.ROLE_ADMIN.toString(), Role_Enum.ROLE_CUSTOMER.toString())
                .antMatchers("/admin/**").hasAuthority(Role_Enum.ROLE_ADMIN.toString())
                .antMatchers("/sales/**").hasAnyAuthority(Role_Enum.ROLE_ADMIN.toString(), Role_Enum.ROLE_CUSTOMER.toString())
                .antMatchers("/gifts/**").hasAnyAuthority(Role_Enum.ROLE_ADMIN.toString(), Role_Enum.ROLE_CUSTOMER.toString())

                .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class
        );

       
   
    }
   
}
