package thud.luanvanofficial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig{
    // Truy vết thời gian thêm, chỉnh sửa và người thực hiện
   @Bean
    public AuditorAware<String> auditorProvider(){
       return new AuditorAware<String>() {
           @Override
           public Optional<String> getCurrentAuditor() {
               Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
               if (authentication == null || !authentication.isAuthenticated()){
                   return  null;
               }
               return Optional.ofNullable(authentication.getName());
           }
       };
   }

}
