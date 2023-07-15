package com.DMart.Exception;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class MyErrorDetails {

    private String message;

    private LocalDateTime timeStamp;

    private String description;

}
