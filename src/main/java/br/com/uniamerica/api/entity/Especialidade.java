package br.com.uniamerica.api.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@Entity
@Table(name = "especialidades", schema = "public")
public class Especialidade extends AbstractEntity {

    private String nome;

}
