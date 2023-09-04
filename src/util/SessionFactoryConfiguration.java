package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.BookEntity;
import entity.LaptopEntity;
import entity.StudentEntity;
import entity.SubjectEntity;

public class SessionFactoryConfiguration {
    // singleton;
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
        .addAnnotatedClass(LaptopEntity.class)
        .addAnnotatedClass(StudentEntity.class)
        .addAnnotatedClass(BookEntity.class)
        .addAnnotatedClass(SubjectEntity.class);
        // see the entity package there is a class named "StudentEntity"
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return sessionFactoryConfiguration == null ? sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
