package thud.luanvanofficial.api;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.RAMDTO;
import thud.luanvanofficial.dto.RAMResponse;
import thud.luanvanofficial.entity.RAM;
import thud.luanvanofficial.repository.RamRepository;
@RestController
@RequestMapping(path = "/rams", produces = "application/json")
@CrossOrigin(origins = "*")
public class RAMController {
    private RamRepository ramRepository;
    @Autowired
    public RAMController(RamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createNewRAM(@RequestBody RAMDTO ramdto){
        ModelMapper modelMapper = new ModelMapper();
        RAM newRam = new RAM();
        newRam = modelMapper.map(ramdto, RAM.class);
        Optional<RAM> existRAM = ramRepository.findByType_Storage_Speed_MaxSpeed(newRam.getType(), newRam.getStorage(), newRam.getSpeed(), newRam.getSupportMaxSpeed());
       if(existRAM.isEmpty()){
        RAM savedRam = ramRepository.save(newRam);
        return ResponseEntity.ok(new RAMResponse(savedRam, ramRepository.findAll()));
       }
       return ResponseEntity.status(HttpStatus.CONTINUE).body(new MessageResponse("RAM đã tồn tại"));
    }

}
