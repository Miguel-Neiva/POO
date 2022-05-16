package House;

import java.time.LocalDate;

public class Bill {
    private Double totalCost;
    private Double consumo;
    private LocalDate emissionDate;
    private LocalDate startDate;

    private int numDevices;

    private String HouseOwner;



    public Bill(Double totalCost, Double consumo, LocalDate emissionDate, LocalDate startDate) {
        this.totalCost = totalCost;
        this.consumo = consumo;
        this.emissionDate =emissionDate;
        this.startDate = startDate;
    }

    public Bill() {
        this.totalCost = 0.0;
        this.consumo = 0.0;
        this.emissionDate = LocalDate.now();
        this.startDate = LocalDate.now();
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setNumDevices(int numDevices) {
        this.numDevices = numDevices;
    }

    public void setHouseOwner(String houseOwner) {
        HouseOwner = houseOwner;
    }

}
