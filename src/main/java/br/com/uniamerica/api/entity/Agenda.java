package br.com.uniamerica.api.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "agendas", schema = "public")
public class Agenda extends AbstractEntity {

    private StatusAgenda statusAgenda;
    private LocalDateTime dataAgenda;
    private Boolean encaixe;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
}
