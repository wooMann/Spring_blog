package com.example.spring_blog.data.dao;


import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.util.HibernateUtil;
import com.example.spring_blog.util.Sha256HashGenerator;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserDAO extends JpaDAO{


    public Optional<User> findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> result = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email",email).getResultList();
        return result.size() > 0 ? Optional.ofNullable(result.get(0)) : Optional.empty();

    }

    public Optional<User> login(UserDTO dto){
        User user = dto.makeUser();
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> result = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", user.getEmail()).
                setParameter("password", Sha256HashGenerator.hashGenerate(user.getPassword())).
                getResultList();
        entityManager.close();

        return result.size() > 0 ? Optional.ofNullable(result.get(0)) : Optional.empty();
    }

    public User login2(UserDTO dto){
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> list = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", dto.getEmail()).
                setParameter("password", dto.getPassword()).
                getResultList();
        entityManager.close();
        if(list.size() > 0){
            entityManager.close();
            return list.get(0);
        }else {
            entityManager.close();
            return null;
        }
    }


}
