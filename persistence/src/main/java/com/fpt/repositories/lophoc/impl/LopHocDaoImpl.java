package com.fpt.repositories.lophoc.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.repositories.lophoc.LopHocDao;
import com.fpt.repositories.lophoc.LopHocDaoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LopHocDaoImpl implements LopHocDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getSchedule(String maGiaoVien, String kiHoc) {
        String sql = "select lh.ngayHoc, lh.caHoc from LopHoc lh where lh.giaoVien.maGiaoVien = :maGiaoVien and lh.monHoc.kiHoc.id = :kiHoc";
        Query query = entityManager.createQuery(sql)
                .setParameter("maGiaoVien", maGiaoVien)
                .setParameter("kiHoc", Integer.parseInt(kiHoc));
        List<Object[]> lstLichHoc = query.getResultList();
        return  lstLichHoc;
    }
}
