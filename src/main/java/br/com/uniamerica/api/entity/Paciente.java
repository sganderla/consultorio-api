package br.com.uniamerica.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Audited
@Table(name = "pacientes", schema = "consultorio")
@AuditTable(value = "pacientes_audit", schema = "consultorio_audit")
public class Paciente extends Pessoa implements Serializable {

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_atendimento", nullable = false, length = 20)
    private TipoAtendimento tipoAtendimento;

    @Getter @Setter
    @Column(name = "numero_cartao_convenio", length = 20, unique = true)
    private String numeroCartaoConvenio;

    @Getter @Setter
    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    @Getter @Setter
    @JoinColumn(name = "id_convenio")
    @ManyToOne(fetch = FetchType.EAGER)
    private Convenio convenio;

}
