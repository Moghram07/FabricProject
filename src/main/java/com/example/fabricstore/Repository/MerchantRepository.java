package com.example.fabricstore.Repository;

import com.example.fabricstore.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Merchant findMerchantById(Integer id);

    Merchant findByOwnerName(String ownerName);

    Merchant findByEmail(String email);

    Merchant findByPhone(String phone);
}
