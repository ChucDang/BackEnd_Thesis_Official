package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.CatergoryRepository;

@RestController
@RequestMapping(path="/catergories", produces="application/json")
@CrossOrigin(origins="*")
public class CatergoryController {

    private CatergoryRepository repo;

    @Autowired
    public CatergoryController(CatergoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Catergory> allCatergory() {
        return repo.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Catergory postCatergory(@RequestBody Catergory order) {
        return repo.save(order);
    }

    @PutMapping(path = "/{catergoryId}", consumes = "application/json")
    public Catergory putOrder(@RequestBody Catergory order) {
        return repo.save(order);
    }

    @PatchMapping(path = "/{catergoryId}", consumes = "application/json")
    public Catergory patchOrder(@PathVariable("catergoryId") Long orderId,
                            @RequestBody Catergory patch) {

        Catergory catergory = repo.findById(orderId).get();
        if (patch.getCode() != null) {
            catergory.setCode(patch.getCode());
        }
        if (patch.getName() != null) {
            catergory.setName(patch.getName());
        }
        return repo.save(catergory);
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
