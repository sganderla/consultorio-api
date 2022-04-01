package br.com.uniamerica.api.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "historicos", schema = "public")
public class Historico extends AbstractEntity {

    private String observacao;
    private LocalDateTime data;
    private StatusAgenda statusAgenda;

    @ManyToOne
    private Secretaria secretaria;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Agenda agenda;

}
