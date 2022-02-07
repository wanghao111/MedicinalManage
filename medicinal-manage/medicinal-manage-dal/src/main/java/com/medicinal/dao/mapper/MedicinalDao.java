package com.medicinal.dao.mapper;

import com.medicinal.dao.params.MedicinalPageQueryParam;
import com.medicinal.dao.vo.MedicinalVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MedicinalDao {

    public int create(MedicinalVO medicinalVO);

//    public int update(MedicinalVO medicinalVO);
//
//    public int delete(String code);
//
    public MedicinalVO get(String code);
//
    public List<MedicinalVO> queryList(@Param("param") MedicinalPageQueryParam param);

    int getTotalCount(@Param("param") MedicinalPageQueryParam param);

    int update(MedicinalVO medicinalVO);

    int delete(String code);

    int decrementReserve(@Param("code") String code, @Param("delCount") int delCount);
}
