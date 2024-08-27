package com.example.fabricstore.Controller;

import com.example.fabricstore.Model.Merchant;
import com.example.fabricstore.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAllMerchant() {
        return ResponseEntity.ok(merchantService.getMerchant());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant) {
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id, @RequestBody @Valid Merchant merchant) {
        merchantService.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body("Merchant updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body("Merchant deleted");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable Integer id) {
        Merchant merchant = merchantService.getMerchantById(id);
        return ResponseEntity.ok(merchant);
    }

    @GetMapping("/ownerName/{ownerName}")
    public ResponseEntity<Merchant> getMerchantByOwnerName(@PathVariable String ownerName) {
        Merchant merchant = merchantService.getMerchantByOwnerName(ownerName);
        return ResponseEntity.ok(merchant);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Merchant> getMerchantByEmail(@PathVariable String email) {
        Merchant merchant = merchantService.getMerchantByEmail(email);
        return ResponseEntity.ok(merchant);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Merchant> getMerchantByPhone(@PathVariable String phone) {
        Merchant merchant = merchantService.getMerchantByPhone(phone);
        return ResponseEntity.ok(merchant);
    }

}
