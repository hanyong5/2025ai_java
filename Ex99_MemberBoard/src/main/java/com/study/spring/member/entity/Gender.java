package com.study.spring.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genders")
@Getter
@Setter
@NoArgsConstructor
public class Gender {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    
    private String name;
} 