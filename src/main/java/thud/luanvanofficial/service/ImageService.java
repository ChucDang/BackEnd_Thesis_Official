package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jayway.jsonpath.Option;

import thud.luanvanofficial.entity.Image;
import thud.luanvanofficial.repository.ImageRepository;

import java.io.IOException;


@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(fileName, file.getContentType(), file.getBytes());

        return imageRepository.save(image);
    }

    public Image getById(String id) {
        return imageRepository.getById(id);
    }
    public void deleteById(String id){
       imageRepository.deleteById(id);
    }
}
