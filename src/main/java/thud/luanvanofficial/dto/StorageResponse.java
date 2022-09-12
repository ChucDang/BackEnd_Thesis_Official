package thud.luanvanofficial.dto;

import java.util.List;

import thud.luanvanofficial.entity.Storage;

public class StorageResponse {
    private Storage savedStorage;
    private java.util.List<Storage> storages;
    public StorageResponse(Storage savedStorage, List<Storage> storages) {
        this.savedStorage = savedStorage;
        this.storages = storages;
    }
    public Storage getSavedStorage() {
        return savedStorage;
    }
    public void setSavedStorage(Storage savedStorage) {
        this.savedStorage = savedStorage;
    }
    public java.util.List<Storage> getstorages() {
        return storages;
    }
    public void setstorages(java.util.List<Storage> storages) {
        this.storages = storages;
    }
    
}
