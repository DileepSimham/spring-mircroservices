package com.infosys.poolcarz.fare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fare_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareDetailsEntity {
    @Id
    private Integer fareId;
    private String source;
    private String destination;
    private Integer fare;


}
