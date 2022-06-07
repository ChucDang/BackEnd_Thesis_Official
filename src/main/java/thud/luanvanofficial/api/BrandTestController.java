package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.User;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping(path = "/api/assignments" , produces = "application/json")
//public class BrandTestController {
//
//    private AssignmentService assignmentService;
//    @Autowired
//    public BrandTestController(AssignmentService assignmentService) {
//        this.assignmentService = assignmentService;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
//    Brand newBrand = assignmentService.save(user);
//    return ResponseEntity.ok(newBrand);
//    }
//    @GetMapping
//    public ResponseEntity<?> getAssignment(@AuthenticationPrincipal User user){
//        List<Brand> assignmentsByUser = assignmentService.findAll(user);
//        return ResponseEntity.ok(assignmentsByUser);
//    }
//    @GetMapping("{Id}")
//    public ResponseEntity<?> getAssignmentById(@PathVariable String Id, @AuthenticationPrincipal User user){
//        Optional<Brand> assignment= assignmentService.findByCode(Id);
//        return ResponseEntity.ok(assignment.orElse(new Brand()));
//    }
//    @PutMapping("{Id}")
//    public ResponseEntity<?> updateAssignmentById(@PathVariable Integer Id, @RequestBody Brand brand, @AuthenticationPrincipal User user){
//        Brand assignment= assignmentService.save(brand);
//        return ResponseEntity.ok(assignment);
//    }
//}
