package com.DMart.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Stock stocks;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location sourceLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location destinationLocation;

    private Integer quantity;

    private LocalDateTime timeStamp;
}
