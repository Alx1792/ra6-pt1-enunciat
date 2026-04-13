package es.ilerna.M0486.ra6.pt1.calculator.impl;

import java.util.List;

import es.ilerna.M0486.ra6.pt1.calculator.api.TemperatureCalculator;

public class TemperatureCalculatorImpl implements TemperatureCalculator {
	@Override
    public double celsiusToKelvin(double celsous) {
        celsous = celsous + 273.15;
        return celsous;
    }

    public double celsiusToFahrenheit (double celsous){
        celsous = (celsous*1.8)+32; //es lo mateix que celsous 1.8=9/5
        return celsous;
    }

}