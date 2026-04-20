package es.ilerna.M0486.ra6.pt1.statistics.api;

import java.time.LocalDate;
import java.util.List;

import es.ilerna.M0486.ra6.pt1.statistics.domain.TemperatureRecord;

public interface TemperatureRepository extends AutoCloseable {

    void close();

    void save(TemperatureRecord record);

    List<TemperatureRecord> findAll();

    List<TemperatureRecord> findByCapital(String capital);

    TemperatureRecord findByCapitalAndDate(String capital, LocalDate date);

    boolean exists(String capital, LocalDate date);

    void delete(String capital, LocalDate date);
}

