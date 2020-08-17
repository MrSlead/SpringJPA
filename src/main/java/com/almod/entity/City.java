package com.almod.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "name", "population"})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private int population;

}
