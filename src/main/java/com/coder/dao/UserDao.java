package com.coder.dao;

import com.coder.entity.QUser;
import com.coder.entity.User;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    EntityManager em;

    QUser qUser = QUser.user;

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 保存
     * @param user
     * @return
     */
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * 保存或更新
     */
    public void saveAndFlush(User user) {
//        em.merge(user);
//        em.flush();
        userRepository.saveAndFlush(user);
    }

    /**
     * 删除
     */
    public void remove(long id){
//        em.remove(id);
        userRepository.delete(id);
    }

    /**
     * 查询所有
     */
    public List<User> getUserList(){
//        String ql = "from User";
//        Query query = em.createQuery(ql);
//        List<User> list = query.getResultList();
//        List<User> list = userRepository.findAll();
        JPAQueryBase queryBase = new JPAQuery(em).from(qUser);
        List<User> list = queryBase.fetch();
        return list;
    }

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    public User getUserById(long userId) {
//        String ql = "from User where id =" +userId;
//        Query query = em.createQuery(ql);
//        User user =  (User) query.getSingleResult();
        User user = userRepository.findOne(userId);
        return user;
    }

//    public Page getUserListByPage(Page page) {
//        JPAQueryBase queryBase=new JPAQuery(em).from(qUser);
//        Long countPage = queryBase.fetchCount();
//        page.setCount(Integer.valueOf(countPage.toString()));
//        queryBase.limit(page.getRows()).offset(page.getFirstResult());
//        List<User> list = queryBase.fetch();
//        return page.setResultList(list);
//        return null;
//    }



}
