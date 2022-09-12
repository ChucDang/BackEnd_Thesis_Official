package thud.luanvanofficial.api;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import thud.luanvanofficial.dto.CPUChangeResponse;
import thud.luanvanofficial.dto.CPU_DTO;
import thud.luanvanofficial.entity.CPU;
import thud.luanvanofficial.repository.CPURepository;

@RestController
@RequestMapping(path = "/cpus", produces = "application/json")
@CrossOrigin(origins = "*")

public class CPUController {
    private CPURepository cpuRepository;
    @Autowired
    public CPUController(CPURepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

   
    @PostMapping(value = "/getByBrandAndVersion", consumes =  { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> getByBrandAndVersion(@RequestPart String brand, @RequestPart String version){
        Optional<CPU> existCPU =  cpuRepository.findByBrandAndVersion(brand, version);
        if(existCPU.isPresent()) return ResponseEntity.ok(existCPU.get());
        return ResponseEntity.ok(new CPU());
    }

    @PostMapping(value = "/createOrEditCPU", consumes =  { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createOrEditCPU(@RequestPart String cpu){
        
        CPU newCPU = getJson(cpu);
        Optional <CPU> existCPU = cpuRepository.findByBrandAndVersion(newCPU.getBrand(), newCPU.getVersion());
        //Nếu existCPU tồn tại, thì xóa existCPU trong database, rồi add newCPU vào để chỉnh sửa
        if(existCPU.isPresent()){
            cpuRepository.delete(existCPU.get());
        }
        CPU savedCPU = cpuRepository.save(newCPU);

        return ResponseEntity.ok(new CPUChangeResponse(savedCPU, cpuRepository.findAll()));
    }
    public static CPU getJson(String _txtCPU){
        
        
        CPU_DTO cpuDTO = new CPU_DTO();
        CPU cpu = new CPU();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            cpuDTO = objectMapper.readValue(_txtCPU, CPU_DTO.class);
            ModelMapper modelMapper = new ModelMapper();
            cpu = modelMapper.map(cpuDTO, CPU.class);
        } catch (JsonProcessingException e) {
            System.out.println("Lỗi");
            throw new RuntimeException(e);
        }

        return cpu;
    }
}
