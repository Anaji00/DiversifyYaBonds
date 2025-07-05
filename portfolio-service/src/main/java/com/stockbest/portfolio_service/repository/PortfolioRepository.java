package com.stockbest.portfolio_service.repository; // repository layer

import com.stockbest.portfolio_service.model.Portfolio; // import entity
import org.springframework.data.jpa.repository.JpaRepository; // base CRUD methods
import org.springframework.stereotype.Repository;

// Spring will scan this repo as a JPA data-access layer
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    // no custom methods needed yet — standard CRUD is inherited
}
