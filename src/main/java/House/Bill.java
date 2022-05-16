package House;

import java.time.LocalDate;

public class Bill {
    private Double totalCost;
    private Double consumo;
    private LocalDate emissionDate;
    private LocalDate startDate;

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
}
