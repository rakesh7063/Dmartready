package com.DMart.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockMovementDTO {
    private Integer StockId;
    private String sourceStoreName;
    private String destinationStoreName;
    private Integer quantity;
}
