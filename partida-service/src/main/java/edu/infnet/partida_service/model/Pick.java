package edu.infnet.partida_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pick")
public class Pick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jogadorId;
    private Long campeaoId;
    private Long rotaId;

    private Integer abates;
    private Integer mortes;
    private Integer assistencias;
    private Integer danoCausado;
    private Integer danoRecebido;
    private Integer gold;
    private Integer cs;
}

