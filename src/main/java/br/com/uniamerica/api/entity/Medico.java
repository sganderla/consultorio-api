package br.com.uniamerica.api.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "medicos", schema = "public")
public class Medico extends Pessoa {

    private String crm;
    private BigDecimal porcentagemParticipacao;
    private String consultorio;
    private BigDecimal valorConsulta;

    @ManyToOne
    private Especialidade especialidade;
}
