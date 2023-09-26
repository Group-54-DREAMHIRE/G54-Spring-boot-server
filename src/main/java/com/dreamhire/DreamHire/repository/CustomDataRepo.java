package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.dto.PostedJobsDTO;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.BooleanType;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomDataRepo {

    private final EntityManager entityManager;

    public CustomDataRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
