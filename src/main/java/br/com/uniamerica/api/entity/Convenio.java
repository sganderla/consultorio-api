package br.com.uniamerica.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "convenios", schema = "public")
public class Convenio extends AbstractEntity {

    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

    private BigDecimal valor;

}
