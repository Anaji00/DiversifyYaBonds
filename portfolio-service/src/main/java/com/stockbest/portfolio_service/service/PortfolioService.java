package com.stockbest.portfolio_service.service;

import com.stockbest.portfolio_service.repository.PortfolioRepository;
import org.springframework.stereotype.Service;
import com.stockbest.portfolio_service.model.Portfolio;
import java.util.List;

@Service
public class PortfolioService {
    private final PortfolioRepository repo;

    public PortfolioService(PortfolioRepository repo) {
        this.repo = repo;
    }

    public List<Portfolio> getAll() {
        return repo.findAll();
    }

    public Portfolio getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Portfolio save(Portfolio portfolio) {
        return repo.save(portfolio);
    }
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
