package com.example.demo.repository;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Repository
public class CalculateDataRepository {
    @Autowired
    private EntityManager entityManager;

    public List<Map<String,Object>> findAll(){
        String str = """
                Select *
                From calculate_record
                """;

        return this.entityManager.createNativeQuery(str).unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).getResultList();
    }
}
