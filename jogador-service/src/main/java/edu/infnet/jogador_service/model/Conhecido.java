package edu.infnet.jogador_service.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("conhecido")
public class Conhecido extends Jogador {
    private String nome;
    private String discord;
    private String whatsapp;

    public Conhecido(String nickname, Long rotaId, String nome, String discord, String whatsapp) {
        super(nickname, rotaId);
        this.nome = nome;
        this.discord = discord;
        this.whatsapp = whatsapp;
    }
}
