package thud.luanvanofficial.dto;

import java.util.List;

import thud.luanvanofficial.entity.CPU;

public class CPUChangeResponse {
    //Trường select CPU có value là cả object cpu, nên khi tạo mới hoặc chỉnh sửa một CPU, ta cần trả về CPU mới tạo
    // và trả về list CPU để tạo default value
    private CPU createdCPU;
    private List<CPU> cpus;
    public CPUChangeResponse(CPU cpu, List<CPU> cpus){
        this.createdCPU = cpu;
        this.cpus = cpus;
    }
    public CPU getCreatedCPU() {
        return createdCPU;
    }
    public void setCreatedCPU(CPU createdCPU) {
        this.createdCPU = createdCPU;
    }
    public List<CPU> getCpus() {
        return cpus;
    }
    public void setCpus(List<CPU> cpus) {
        this.cpus = cpus;
    }
    
}
