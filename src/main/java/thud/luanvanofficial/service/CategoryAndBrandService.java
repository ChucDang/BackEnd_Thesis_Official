package thud.luanvanofficial.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import thud.luanvanofficial.dto.BrandByCategoryResponse;
import thud.luanvanofficial.dto.CategoryDTO;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.entity.*;
import thud.luanvanofficial.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class CategoryAndBrandService {
    private BrandRepository brandRepository;
    private RamRepository ramRepository;
    private ScreenRepository screenRepository;
    private StorageRepository storageRepository;
    private CPURepository cpuRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryAndBrandService(BrandRepository brandRepository, RamRepository ramRepository, ScreenRepository screenRepository, StorageRepository storageRepository, CPURepository cpuRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.ramRepository = ramRepository;
        this.screenRepository = screenRepository;
        this.storageRepository = storageRepository;
        this.cpuRepository = cpuRepository;
        this.categoryRepository = categoryRepository;
    }
    public ResponseEntity<?> getAllBrandsScreensCpusStorages(String code){
        List<Brand> brands = brandRepository.findAllBrandsByCategoryCode(code);
        List<CPU> cpus = cpuRepository.findAll();
        List<Screen> screens = screenRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Storage> storages = storageRepository.findAll();
        return ResponseEntity.ok(new CategoryDTO(brands, rams, cpus, screens, storages));

    }

    public ResponseEntity<?> getBrandsIfExist(String code) {
        Optional<Category> optionalCategory = categoryRepository.findByCode(code);
        if(optionalCategory.isPresent()) {
            List<String> brands = brandRepository.getStringBrandsByCategoryCode(code);

            return ResponseEntity.status(HttpStatus.OK).body(new BrandByCategoryResponse(optionalCategory.get(), brands));
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("Không có"));
        }


    }

    @SuppressWarnings("unchecked")
	public ResponseEntity<?> addNewCategory(String category, String brands) {
        //Get JSON
        List<String> listBrands = new ArrayList<String>();
        Category operateCategory = new Category();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            listBrands =(List<String>) objectMapper.readValue(brands, List.class);
            operateCategory = objectMapper.readValue(category, Category.class);
        } catch (JsonProcessingException e) {
            System.out.println("Lỗi");
            throw new RuntimeException(e);
        }
      
        Optional<Category> optionalCategory = categoryRepository.findByCode(operateCategory.getCode());
        ListIterator<String> listIterator;
        if(optionalCategory.isEmpty()){
            Category newCategory = new Category(operateCategory.getCode(), operateCategory.getName());
            Category justSavedCategory = categoryRepository.save(newCategory);
            listIterator = listBrands.listIterator();
            while(listIterator.hasNext()){
                String currentName = listIterator.next();
                Optional<Brand> optionalBrand = brandRepository.findByName(currentName);
                if(optionalBrand.isEmpty()){
                    Brand newBrand = new Brand();
                    newBrand.setName(currentName);
                    newBrand.setCategory(justSavedCategory);
                    brandRepository.save(newBrand);
                }
            }
            return ResponseEntity.ok(justSavedCategory);
        }else {
            listIterator = listBrands.listIterator();
            while(listIterator.hasNext()){
                String currentName = listIterator.next();
                Optional<Brand> optionalBrand = brandRepository.findByName(currentName);
                if(optionalBrand.isEmpty()){
                    Brand newBrand = new Brand(currentName, optionalCategory.get());
                    brandRepository.save(newBrand);
                }
            }
            return ResponseEntity.ok(optionalCategory.get());

        }

    }

    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }
}
