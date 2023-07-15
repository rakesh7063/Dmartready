package com.DMart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movementId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stock stocks;

    private Integer quantity;

    private LocalDateTime timeStamp;
}
