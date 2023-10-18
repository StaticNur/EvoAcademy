package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geodata implements Serializable {
    @Id
    @GeneratedValue
    int id;
    @NonNull
    private double lon;
    @NonNull
    private double lat;
    @NonNull
    private String name;
}
