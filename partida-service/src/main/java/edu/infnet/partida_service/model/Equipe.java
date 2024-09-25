package edu.infnet.partida_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pick> picks = new ArrayList<>();

    private String side;
    private Integer dragao;
    private Integer barao;
    private Integer herald;
    private Integer grub;
    private Integer torre;
    private Integer inibidor;

}

