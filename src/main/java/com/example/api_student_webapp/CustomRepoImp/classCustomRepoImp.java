package com.example.api_student_webapp.CustomRepoImp;

import com.example.api_student_webapp.CustomRepo.classCustomRepo;
import com.example.api_student_webapp.dto.classDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class classCustomRepoImp implements classCustomRepo {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<classDto> search(classDto classDto, Pageable pageable) {
        try {
            String query = "select quanlyhocsinh.lophoc.ma_lop,quanlyhocsinh.lophoc.ten_lop from quanlyhocsinh.lophoc where quanlyhocsinh.lophoc.ten_lop like ?";

            query += " ORDER BY quanlyhocsinh.lophoc.ma_lop desc LIMIT ? OFFSET ?  ";
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, "%" + Objects.toString(classDto.getTenLop(), "") + "%");
            q.setParameter(2, pageable.getPageSize());
            q.setParameter(3, pageable.getPageNumber() * pageable.getPageSize());
            List<Object[]> list = (List<Object[]>) q.getResultList();
            ArrayList result = new ArrayList();
            for (Object[] obj : list){
                classDto de = new classDto(
                        (Integer) obj[0],(String) obj [1]
                );
                result.add(de);
            }
            return result;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Integer getNumberOfItemsByRequest(classDto classDto) {
        String query = "select COUNT(*) from quanlyhocsinh.lophoc WHERE quanlyhocsinh.lophoc.ten_lop like ?";

        Query q = entityManager.createNativeQuery(query);
        q.setParameter(1, "%" + Objects.toString(classDto.getTenLop(), "") + "%");
        List<Object[]> list = (List<Object[]>) q.getResultList();
        int count = ((Number) q.getSingleResult()).intValue();
        return count;
    }

    @Override
    public void delete(Integer id) {

    }
}
