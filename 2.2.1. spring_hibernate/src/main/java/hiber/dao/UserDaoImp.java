package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
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
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select distinct u from User u left join fetch u.car", User.class);
      return query.getResultList();
   }

   @Override
   public User findUserByCar(String model, int series) {
      try (Session session = sessionFactory.openSession()) {
         Query<User> query = session.createQuery("select distinct u from User u join fetch u.car c where c.model = :model and c.series = :series", User.class);
         query.setParameter("model", model);
         query.setParameter("series", series);
         return query.uniqueResult();
      }
   }
}
