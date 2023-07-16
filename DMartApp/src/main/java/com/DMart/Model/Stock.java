package com.DMart.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer quantity;

   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stocks")
    private List<StockMovement> stockMovements;
}
