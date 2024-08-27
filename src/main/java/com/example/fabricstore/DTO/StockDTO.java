package com.example.fabricstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockDTO {

    private Integer fabricId;
    private Integer merchantId;
    private int quantity;
}
