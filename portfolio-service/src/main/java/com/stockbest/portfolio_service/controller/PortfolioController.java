package com.stockbest.portfolio_service.controller; // controller layer

import com.stockbest.portfolio_service.model.Portfolio;
import com.stockbest.portfolio_service.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {
    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Portfolio> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Portfolio one(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Portfolio create(@RequestBody Portfolio portfolio) {
        return service.save(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    // Test endpoint to verify JSON serialization
    @GetMapping("/test")
    public Portfolio testPortfolio() {
        Portfolio p = new Portfolio();
        p.setId(123L);
        p.setUserId("testuser");
        p.setStockSymbol("AAPL");
        p.setQuantity(5);
        p.setPurchasePrice(100.0);
        p.setTimestamp("2025-07-01T12:00:00");
        p.setCurrentPrice(110.0);
        return p;
    }
}