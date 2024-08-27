package com.example.fabricstore.Service;

import com.example.fabricstore.ApiException.ApiException;
import com.example.fabricstore.Model.Merchant;
import com.example.fabricstore.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getMerchant() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant merchant) {
        Merchant m = merchantRepository.findMerchantById(id);
        if (m == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        m.setEmail(merchant.getEmail());
        m.setPhone(merchant.getPhone());
        m.setOwnerName(merchant.getOwnerName());
        m.setName(m.getName());
        merchantRepository.save(m);
    }

    public void deleteMerchant(Integer id) {
        Merchant m = merchantRepository.findMerchantById(id);
        if (m == null) {
            throw new ApiException("Customer with id " + id + " not found");
        }
        merchantRepository.delete(m);
    }

    public Merchant getMerchantById(Integer id) {
        return merchantRepository.findMerchantById(id);
    }

    public Merchant getMerchantByOwnerName(String ownerName) {
        return merchantRepository.findByOwnerName(ownerName);
    }

    public Merchant getMerchantByEmail(String email) {
        return merchantRepository.findByEmail(email);
    }

    public Merchant getMerchantByPhone(String phone) {
        return merchantRepository.findByPhone(phone);
    }
}
