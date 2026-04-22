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
            System.out.println("Error "+e.getMessage());
            return null;
        }

    }
    @Override
    public List<TemperatureRecord> findByCapital(String capital){
        try{
            return session.createQuery("FROM TemperatureRecord WHERE capital = :capital", TemperatureRecord.class).setParameter("capital",capital).list();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
            return null;
        }

    }
    @Override
    public TemperatureRecord findByCapitalAndDate(String capital, LocalDate date){
        try{
            return session.createQuery("FROM TemperatureRecord WHERE capital = :capital AND date = :date", TemperatureRecord.class).setParameter("capital",capital).setParameter("date",date).uniqueResult();
            //UNique perque per logica retornara un resultat
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
            return null;
        }
    }
    @Override
    public boolean exists(String capital, LocalDate date){
        if(findByCapitalAndDate(capital,date) !=null){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void save(TemperatureRecord record){
        Transaction t= null;
        try {
            t= session.beginTransaction();
            if(exists(record.getCapital(), record.getDate())){
                System.out.println("[ERROR] Record already exists: "+record.getCapital() + " / " +record.getDate());
                return;
            }
            session.saveOrUpdate(record);
            t.commit();
            System.out.println("Saved: "+ record);
        }catch (Exception e){
            if (t !=null) {
                t.rollback();
            }
            System.out.println("Error "+e.getMessage());
        }

    }
    @Override
    public void delete(String capital, LocalDate date){
        Transaction t = null;
        try{
            t = session.beginTransaction();
            session.createQuery("DELETE FROM TemperatureRecord WHERE capital = :capital AND date = :date").setParameter("capital", capital).setParameter("date", date).executeUpdate();//Diferencia amb select i tal
            t.commit();
        } catch (Exception e){
            if(t != null){
                t.rollback();
            }
            System.out.println("Error " +e.getMessage());
        }
    }
}