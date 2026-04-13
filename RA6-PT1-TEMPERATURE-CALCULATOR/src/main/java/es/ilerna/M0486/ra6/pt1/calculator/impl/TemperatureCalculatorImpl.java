package es.ilerna.M0486.ra6.pt1.calculator.impl;

import java.util.List;

import es.ilerna.M0486.ra6.pt1.calculator.api.TemperatureCalculator;

public class TemperatureCalculatorImpl implements TemperatureCalculator {
	@Override
    public double celsiusToKelvin(double celsous) {
        celsous = celsous + 273.15;
        return celsous;
    }

    @Override
    public double celsiusToFahrenheit (double celsous){
        celsous = (celsous*1.8)+32; //es lo mateix que celsous 1.8=9/5
        return celsous;
    }
    @Override
    public double min(List<Double> temperatures) {
        double min1 = temperatures.get(0);
        for (Double temperatura : temperatures){
            if(min1>temperatura){
                min1=temperatura
            }
        }
        return min1;
    }
    @Override
    public double max(List<Double> temperatures) {
        double max1 = temperatures.get(0);
        for (Double temperatura : temperatures){
            if(max1<temperatura){
                max=temperatura
            }
        }
        return max1;
    }
    @Override
    public double average(List<Double> temperatures) {
        double suma= 0.0;
        for (Double temperatura : temperatures){
            suma += temperatura
        }
        double resultat= suma/temperatures.size();
        return resultat;
    }
}