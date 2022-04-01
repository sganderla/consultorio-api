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
@Table(name = "pacientes", schema = "public")
public class Paciente extends Pessoa {

    private TipoAtendimento tipoAtendimento;
    private String numeroCartaoConvenio;
    private LocalDateTime dataVencimento;

    @ManyToOne
    private Convenio convenio;

}
