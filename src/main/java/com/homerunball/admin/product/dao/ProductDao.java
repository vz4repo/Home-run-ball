package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.ProductDto;

import java.util.List;

public interface ProductDao {
    int countAll() throws Exception;

    int deleteAll() throws Exception;

    int delete(String pd_id) throws Exception;

    int insert(ProductDto productDto) throws Exception;

    ProductDto selectPrd(String pd_id) throws Exception;

    List<ProductDto> selectPrdAll() throws Exception;

    List<ProductDto> selectPrdPrcAll() throws Exception;

    ProductDto selectPrdPrc(String pd_id) throws Exception;

    int searchBiggestSerialNumber(String pd_type_cd) throws Exception;

    int countType(String pd_type_cd) throws Exception;

    int updateContent(ProductDto productDto) throws Exception;

    int updateStatus(ProductDto productDto) throws Exception;

    int increaseHitCnt(String pd_id) throws Exception;
}