package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public void clearTable() {
        sessionFactory.getCurrentSession().createQuery("delete from User").executeUpdate();
        sessionFactory.getCurrentSession().createQuery("delete from Car ").executeUpdate();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public User searchUserByKar(String model, int series) {
        User user;
        user = (User) sessionFactory.getCurrentSession().createQuery("from User where car.model=:model and car.series=:series")
                .setParameter("model", model)
                .setParameter("series", series).uniqueResult();
        return user;
    }

}
