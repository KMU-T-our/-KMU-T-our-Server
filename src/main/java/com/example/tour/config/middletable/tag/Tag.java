package com.example.tour.config.middletable.tag;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long tagId;

}
