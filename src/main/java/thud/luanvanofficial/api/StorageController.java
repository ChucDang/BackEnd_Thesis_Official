package thud.luanvanofficial.api;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.StorageDTO;
import thud.luanvanofficial.dto.StorageResponse;
import thud.luanvanofficial.entity.Storage;
import thud.luanvanofficial.repository.StorageRepository;

@RestController
@RequestMapping(path = "/storages", produces = "application/json")
@CrossOrigin(origins = "*")
public class StorageController {
    private StorageRepository storageRepository;

    public StorageController(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createNewStorage(@RequestBody StorageDTO storageDTO){
        ModelMapper modelMapper = new ModelMapper();
        Storage newStorage = new Storage();
        newStorage = modelMapper.map(storageDTO, Storage.class);
        Optional<Storage> existStorage = storageRepository.findByType_Code_Optane_Storage(newStorage.getType(), newStorage.getCode(), newStorage.getSupportOptane(), newStorage.getStorage());
       if(existStorage.isEmpty()){
        Storage savedStorage = storageRepository.save(newStorage);
        return ResponseEntity.ok(new StorageResponse(savedStorage, storageRepository.findAll()));
       }
       return ResponseEntity.status(HttpStatus.CONTINUE).body(new MessageResponse("Storage đã tồn tại"));
    }

}
