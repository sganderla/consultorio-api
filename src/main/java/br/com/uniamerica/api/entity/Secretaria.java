package br.com.uniamerica.api.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "secretarias", schema = "public")
public class Secretaria extends Pessoa {

    private BigDecimal salario;
    private LocalDateTime dataContratacao;
    private String pis;

}
