package thud.luanvanofficial.dto;

import java.util.List;

import thud.luanvanofficial.entity.RAM;

public class RAMResponse {
    private RAM savedRam;
    private java.util.List<RAM> rams;
    public RAMResponse(RAM savedRam, List<RAM> rams) {
        this.savedRam = savedRam;
        this.rams = rams;
    }
    public RAM getSavedRam() {
        return savedRam;
    }
    public void setSavedRam(RAM savedRam) {
        this.savedRam = savedRam;
    }
    public java.util.List<RAM> getRams() {
        return rams;
    }
    public void setRams(java.util.List<RAM> rams) {
        this.rams = rams;
    }
    
}
