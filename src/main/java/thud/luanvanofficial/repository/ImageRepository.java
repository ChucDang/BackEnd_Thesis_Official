package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thud.luanvanofficial.entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
