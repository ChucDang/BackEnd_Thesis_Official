package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Brand;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.BrandRepository;
import thud.luanvanofficial.repository.CatergoryRepository;

public class BrandController {

    private BrandRepository repo;

    @Autowired
    public BrandController(BrandRepository repo) {
        this.repo = repo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Brand> allBrand() {
        return repo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand postBrand(@RequestBody Brand brand) {
        return repo.save(brand);
    }

    @PutMapping(path = "/{Id}", consumes = "application/json")
    public Brand putBrand(@RequestBody Brand brand) {
        return repo.save(brand);
    }

    @PatchMapping(path = "/{Id}", consumes = "application/json")
    public Brand patchOrder(@PathVariable("Id") Long Id,
                                @RequestBody Catergory patch) {

        Brand brand = repo.findById(Id).get();
        if (patch.getCode() != null) {
            brand.setCode(patch.getCode());
        }
        return repo.save(brand);
    }

    @DeleteMapping("/{catergoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("catergoryId") Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
