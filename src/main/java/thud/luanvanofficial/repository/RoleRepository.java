package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Authority;

public interface RoleRepository extends JpaRepository<Authority, Long> {
}
