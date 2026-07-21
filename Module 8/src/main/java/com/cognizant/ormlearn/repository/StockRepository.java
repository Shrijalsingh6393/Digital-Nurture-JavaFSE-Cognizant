package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Get all stock details of a company in a specific date range (e.g. FB in Sept 2019)
    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    // 2. Get stock details where stock close price was greater than a given threshold
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // 3. Find the top 3 dates with the highest transaction volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Identify 3 dates when stock prices were the lowest for a given code (e.g. NFLX)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
