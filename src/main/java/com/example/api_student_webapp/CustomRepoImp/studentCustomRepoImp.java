package com.example.api_student_webapp.CustomRepoImp;

import com.example.api_student_webapp.CustomRepo.studentCustomRepo;
import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.models.studentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class studentCustomRepoImp implements studentCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<studentEntity> getById(Integer studentId) {
        return null;
    }

    @Override
    public List<studentEntity> getByEmpId(Integer studentId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<studentEntity> criteriaQuery = builder.createQuery(studentEntity.class);
        Root<studentEntity> root = criteriaQuery.from(studentEntity.class);
        List<Order> orders = new ArrayList<>();
        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.distinct(true);
        final TypedQuery<studentEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Integer getNumberOfItemsByRequest(studentDto studentDto) {
        String query = "select COUNT(*) from quanlyhocsinh.hocsinh WHERE quanlyhocsinh.hocsinh.ho_ten like ?";

        Query q = entityManager.createNativeQuery(query);
        q.setParameter(1, "%" + Objects.toString(studentDto.getHoTen(), "") + "%");
        List<Object[]> list = (List<Object[]>) q.getResultList();
        int count = ((Number) q.getSingleResult()).intValue();
        return count;
    }

    @Override
    public List<studentDto> search(studentDto studentDto, Pageable pageable) {
        try {
            String query = "select hs.mahs,hs.ngay_sinh,hs.diachi,hs.gioitinh,hs.ho_ten,hs.ma_lop,lp.ten_lop from quanlyhocsinh.hocsinh hs INNER JOIN quanlyhocsinh.lophoc lh on hs.ma_lop = lp.ma_lop WHERE lh.ten_lop like ?";

            if(studentDto.getId() != 0){
                query += " And hs.ma_lop = " + studentDto.getMaLop();
            }

            query += " ORDER BY hs.mahs desc LIMIT ? OFFSET ?  ";
            Query q = entityManager.createNativeQuery(query);
            q.setParameter(1, "%" + Objects.toString(studentDto.getHoTen(), "") + "%");
            q.setParameter(2, pageable.getPageSize());
            q.setParameter(3, pageable.getPageNumber() * pageable.getPageSize());
            List<Object[]> list = (List<Object[]>) q.getResultList();
            ArrayList result = new ArrayList();
            for (Object[] obj : list){
                studentDto de = new studentDto(
                        (String) obj[0],(String) obj [1],(Date) obj [2],(String) obj[3],(Integer) obj[4]);
                result.add(de);
            }
            return result;
        }catch (Exception ex){
            return null;
        }
    }
}
