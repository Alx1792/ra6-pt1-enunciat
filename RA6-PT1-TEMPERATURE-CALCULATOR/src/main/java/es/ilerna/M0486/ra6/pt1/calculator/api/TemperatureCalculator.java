package es.ilerna.M0486.ra6.pt1.calculator.api;

import java.util.List;

public interface TemperatureCalculator {

    double average(List<Double> temperatures);
    double max(List<Double> temperatures);
    double min(List<Double> temperatures);
    double celsiusToFahrenheit(double celsius);
    double celsiusToKelvin(double celsius);
}