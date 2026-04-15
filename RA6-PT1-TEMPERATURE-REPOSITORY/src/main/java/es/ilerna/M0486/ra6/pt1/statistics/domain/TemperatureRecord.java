package es.ilerna.M0486.ra6.pt1.statistics.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temperature_record")
public class TemperatureRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="capital")
    private String capital;
    @Column(name="date")
    private LocalDate date;
    @Column(name="maxTemp")
    private double maxTemp;
    @Column(name="minTemp")
    private double minTemp;

    public TemperatureRecord() {
    }

    public TemperatureRecord(Integer id, String capital, LocalDate date, double maxTemp, double minTemp) {
        this.id = id;
        this.capital = capital;
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }
}