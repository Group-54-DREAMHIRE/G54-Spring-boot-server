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

    public List<PostedJobsDTO> getPostedJobsByCompanyId(int id){

        Session session = entityManager.unwrap(Session.class);

        String sql =    "SELECT job.job_title ,job.tags ,job.validate,job.deadline,job.id,job.number_of_vacancies, COUNT(ajc.id)" +
                       " FROM jobpost job " +
                       " LEFT JOIN apply_job_candidate ajc" +
                       " ON ajc.job_id = job.id" +
                       " WHERE job.company_id = 1" +
                        "GROUP BY job.job_title,job.tags,job.validate,job.deadline,job.id,job.number_of_vacancies";

        NativeQuery<Object[]> query = session.createSQLQuery(sql)
                .addScalar("job_title", StringType.INSTANCE)
                .addScalar("tags", StringType.INSTANCE)
                .addScalar("validate", BooleanType.INSTANCE)
                .addScalar("deadline", DateType.INSTANCE)
                .addScalar("id", IntegerType.INSTANCE)
                .addScalar("number_of_vacancies", IntegerType.INSTANCE)
                .addScalar("COUNT(ajc.id)",IntegerType.INSTANCE);

       // query.setParameter("id",id);

        List<Object[]> resultList = query.list();

        List<PostedJobsDTO> dots = resultList.stream()
                .map(row -> new PostedJobsDTO((String) row[0],(String)row[1],(boolean) row[2],(Date) row[3],(int)row[4],(int) row[5],(int) row[6]))
                .collect(Collectors.toList());

        return dots;
    }
}
