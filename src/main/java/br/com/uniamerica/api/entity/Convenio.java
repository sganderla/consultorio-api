package br.com.uniamerica.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Audited
@Table(name = "convenios", schema = "consultorio")
@AuditTable(value = "convenios_audit", schema = "consultorio_audit")
public class Convenio extends AbstractEntity {

    @Max(value = 10, message = "Tamanho máximo estrapolado.")
    @Min(value = 3, message = "Tamanho Minimo não respeitado.")
    @NotNull(message = "Valor não informado")
    @NotEmpty(message = "Valor não informado")
    @
    @Getter @Setter
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

    @Getter @Setter
    @Digits(integer = 5, fraction = 3)
    @Column(name = "valor", precision = 5, scale = 3, nullable = false)
    private BigDecimal valor;

}
