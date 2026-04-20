package es.ilerna.M0486.ra6.pt1.statistics.impl;

import java.time.LocalDate;
import java.util.List;

import es.ilerna.M0486.ra6.pt1.statistics.api.HibernateSession;
import es.ilerna.M0486.ra6.pt1.statistics.api.TemperatureRepository;
import es.ilerna.M0486.ra6.pt1.statistics.domain.TemperatureRecord;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TemperatureRepositoryMySQL implements TemperatureRepository {

	private Session session;
	
	public TemperatureRepositoryMySQL() {
		this.session = HibernateSession.getSessionFactory().openSession();
	}
	
	// TODO: Implement methods
	
	@Override
	public void close() {
		if (session != null && session.isOpen()) {
			session.close();
			System.out.println("Session closed.");
		}
	}

    @Override
    public List<TemperatureRecord> findAll(){
        try{
            return session.createQuery("FROM TemperatureRecord", TemperatureRecord.class).list();
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
            return null;
        }

    }
}