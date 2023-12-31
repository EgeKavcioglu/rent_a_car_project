package com.example.demo.repositories;

import com.example.demo.dtos.responses.brand.GetBrandListResponse;
import com.example.demo.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    List<Brand> findByNameLikeOrIdEqual(String name, int id);
    List<Brand> findByName(String name);
    @Query("SELECT b FROM Brand b Where b.name LIKE %:name%")
    List<Brand> search(String name);
    @Query(value = "Select * from brands Where name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);
    @Query("SELECT new com.example.demo.services.dtos.responses.brand.GetBrandListResponse(b.name) " +
            "FROM Brand b Where b.name LIKE %:name%")
    List<GetBrandListResponse> search3(String name);

}

