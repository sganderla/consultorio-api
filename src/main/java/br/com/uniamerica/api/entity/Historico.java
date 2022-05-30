package br.com.uniamerica.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Audited
@Table(name = "historicos", schema = "consultorio")
@AuditTable(value = "historicos_audit", schema = "consultorio_audit")
public class Historico extends AbstractEntity {

    @Getter @Setter
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusAgenda statusAgenda;

    @Getter @Setter
    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;

    @Getter @Setter
    @JoinColumn(name = "id_secretaria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Secretaria secretaria;

    @Getter @Setter
    @JoinColumn(name = "id_paciente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente paciente;

    @Getter @Setter
    @JoinColumn(name = "id_agenda", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Agenda agenda;

}
