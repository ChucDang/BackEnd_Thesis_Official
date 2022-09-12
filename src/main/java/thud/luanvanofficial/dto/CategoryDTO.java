package thud.luanvanofficial.dto;

import thud.luanvanofficial.entity.*;

import java.util.List;

public class CategoryDTO {
    private List<Brand> brands;
    private List<RAM> rams;
    private List<CPU> cpus;
    private List<Screen> screens;
    private List<Storage> storages;

    public CategoryDTO(List<Brand> brands, List<RAM> rams, List<CPU> cpus, List<Screen> screens, List<Storage> storages) {
        this.brands = brands;
        this.rams = rams;
        this.cpus = cpus;
        this.screens = screens;
        this.storages = storages;
    }

    public CategoryDTO() {
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<RAM> getRams() {
        return rams;
    }

    public List<CPU> getCpus() {
        return cpus;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Storage> getStorages() {
        return storages;
    }
}
