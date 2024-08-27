package com.example.fabricstore.Service;

import com.example.fabricstore.ApiException.ApiException;
import com.example.fabricstore.DTO.StockDTO;
import com.example.fabricstore.Model.Fabric;
import com.example.fabricstore.Model.Merchant;
import com.example.fabricstore.Model.Stock;
import com.example.fabricstore.Repository.FabricRepository;
import com.example.fabricstore.Repository.MerchantRepository;
import com.example.fabricstore.Repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final FabricRepository fabricRepository;
    private final MerchantRepository merchantRepository;

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public void addStock(StockDTO stockDTO){
        Fabric fabric = fabricRepository.findFabricById(stockDTO.getFabricId());
        Merchant merchant = merchantRepository.findMerchantById(stockDTO.getMerchantId());
        if(fabric == null || merchant == null) {
            throw new ApiException("Fabric or Merchant not found");
        }
        Stock stock = new Stock();
        stock.setFabric(fabric);
        stock.setMerchant(merchant);
        stock.setQuantity(stockDTO.getQuantity());

        stockRepository.save(stock);
    }

    public void updateStock(Integer id, Stock stock) {
        Stock s = stockRepository.findStockById(id);
        if(s == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        s.setQuantity(stock.getQuantity());
        s.setFabric(stock.getFabric());
        s.setMerchant(stock.getMerchant());
        stockRepository.save(s);
    }

    public void deleteStock(Integer id) {
        Stock s = stockRepository.findStockById(id);
        if(s == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        stockRepository.delete(s);
    }

    public Stock getStockById(Integer id) {
        return stockRepository.findStockById(id);
    }

    public Stock getStockByFabricId(Integer id) {
        return stockRepository.findStockByFabricId(id);
    }

    public Stock getStockByMerchantId(Integer id) {
        return stockRepository.findStockByMerchantId(id);
    }

    public List<Stock> getStockByQuantity(Integer quantity) {
        return stockRepository.findByQuantityGreaterThanEqual(quantity);
    }
}
