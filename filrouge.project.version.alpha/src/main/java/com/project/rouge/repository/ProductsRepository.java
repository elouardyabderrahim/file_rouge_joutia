package com.project.rouge.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.rouge.model.Category;
import com.project.rouge.model.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @RestResource(path = "/selectedProducts")
    public List<Products> findBySelectedIsTrue();
    @RestResource(path = "/productsByKeyword")
    public List<Products> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Products> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    public List<Products> findByAvailableIsTrue();
    @Query("SELECT p FROM Products p WHERE p.category = :id ")
    List <Products> findByCategoryId(@RequestParam("id") Category id);//,Pageable pageable
}
	
