package org.example.oop;
/*
    Compozitia este procesul prin care o clasa principala este asamblata pe baza altor clase secundare.
 */

class Laptop {

    private String model;
    private int modelNumber;
    protected Double price;
    private CPU cpu;
    private RAM ram;
    private GPU gpu;
    // todo: Motherboard, etc.


    public Laptop(String model, int modelNumber, Double price, CPU cpu, RAM ram, GPU gpu) {
        this.model = model;
        this.modelNumber = modelNumber;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", modelNumber=" + modelNumber +
                ", price=" + price +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", gpu=" + gpu +
                '}';
    }
}

class CPU {

    private String model;
    private int cores;
    private int threads;

    public CPU(String model, int cores, int threads) {
        this.model = model;
        this.cores = cores;
        this.threads = threads;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "model='" + model + '\'' +
                ", cores=" + cores +
                ", threads=" + threads +
                '}';
    }
}

class RAM {

    private String model;
    private int capacity;
    private String type;

    public RAM(String model, int capacity, String type) {
        this.model = model;
        this.capacity = capacity;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}

class GPU {

    private String model;
    private int memorySize;
    private String memoryType;

    public GPU(String model, int memorySize, String memoryType) {
        this.model = model;
        this.memorySize = memorySize;
        this.memoryType = memoryType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    @Override
    public String toString() {
        return "GPU{" +
                "model='" + model + '\'' +
                ", memorySize=" + memorySize +
                ", memoryType='" + memoryType + '\'' +
                '}';
    }
}


public class CompositionPrinciple {

    public static void main(String[] args) {

        // Initializare veche
        CPU cpu1 = new CPU("Intel I7", 8, 16);
        RAM ram1 = new RAM("DDR4", 16, "Sirius");
        GPU gpu1 = new GPU("GeForce1090", 8, "GDDR5");
        Laptop laptop1 = new Laptop(
                "MSI",
                20082024,
                9000.2,
                cpu1,
                ram1,
                gpu1);
        System.out.println(laptop1);

        // Initializare noua

        Laptop laptop2 = new Laptop(
                "MSI",
                20082024,
                9000.2,
                new CPU("Intel I7", 8, 16),
                new RAM("DDR4", 16, "Sirius"),
                new GPU("GeForce1090", 8, "GDDR5"));
        System.out.println(laptop2);
    }

}
