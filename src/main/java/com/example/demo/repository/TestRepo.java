package com.example.demo.repository;

import com.example.demo.model.UserInfoTest;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public class TestRepo {

    @Autowired
    private EntityManager entityManager;

//    public List<Map<String, Object>> findAll() {
//        String queryStr = """
//                SELECT *
//                FROM user_info_test
//                """;
//        try {
//            return this.entityManager.createNativeQuery(queryStr)
//                    .unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
//                    .getResultList();
//        }catch (Exception e) {
//            return null;
//        }
//    }

    public Map<String,Object> findById(Integer id){
        String queryStr= """
                select *
                from user_info_test
                where id = :id
                """;
        try {
            return (Map) this.entityManager.createNativeQuery(queryStr).unwrap(NativeQueryImpl.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Integer deleteById_TestRepo(Integer id){
        String queryStr= """
                delete
                from user_info_test
                where id = :id
                """;

        try {
            this.entityManager.createNativeQuery(queryStr).unwrap(NativeQueryImpl.class)
                    .executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 500;
        }
        return 1;
    }
}
