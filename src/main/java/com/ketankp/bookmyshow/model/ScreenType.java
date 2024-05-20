package com.ketankp.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SCREEN_TYPE")
public class ScreenType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int screenTypeId;

    public String screenTypeName;
}
