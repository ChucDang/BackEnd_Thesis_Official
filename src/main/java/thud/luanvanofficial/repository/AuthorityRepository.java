package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
       @Query("select a from Authority a where a.authority = ?1")
       Authority getAuthorityByAuthority(String authority);
}
