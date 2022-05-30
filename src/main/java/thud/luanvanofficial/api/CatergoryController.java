package thud.luanvanofficial.api;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.CatergoryRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/catergories", produces="application/json",consumes = "application/json")
@CrossOrigin(origins="*")
public class CatergoryController {

    private CatergoryRepository repo;

    public CatergoryController(CatergoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Catergory> allCatergory() {
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Catergory> oneBrand(@PathVariable("id") Long id) {
        Optional<Catergory> brand = repo.findById(id);
        if (brand.isPresent()) {
            return new ResponseEntity<>(brand.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Catergory postCatergory(@RequestBody Catergory cater) {
        return repo.save(cater);
    }

    @PutMapping
    public Catergory putCatergory(@RequestBody Catergory cater) {
        return repo.save(cater);
    }

    @PatchMapping("/{id}")
    public Catergory patchCatergory(@PathVariable("id") Long id,
                            @RequestBody Catergory patch) {

        Catergory catergory = repo.findById(id).get();
        if (patch.getCode() != null) {
            catergory.setCode(patch.getCode());
        }
        if (patch.getName() != null) {
            catergory.setName(patch.getName());
        }
        return repo.save(catergory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCatergory(@PathVariable("id") Long id) {
        try {
            repo.deleteById(id);
            System.out.println("Xóathành công");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Xóa thất bại");
        }
    }

}
