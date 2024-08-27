package com.example.fabricstore.Repository;

import com.example.fabricstore.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Stock findStockById(Integer id);

    @Query("select s from Stock s where s.fabric.id = :id")
    Stock findStockByFabricId(Integer id);

    @Query("select s from Stock s where s.merchant.id = :id")
    Stock findStockByMerchantId(Integer id);

    List<Stock> findByQuantityGreaterThanEqual(Integer quantity);

}
