package br.com.uniamerica.api.entity;

import javax.persistence.MappedSuperclass;

/**
 * @author Eduardo Sganderla
 *
 * @since 1.0.0, 22/03/2022
 * @version 1.0.0
 */
@MappedSuperclass
public abstract class Pessoa extends AbstractEntity {

    private String nome;
    private String telefone;
    private String celular;
    private String nacionalidade;
    private String cpf;
    private String rg;
    private String email;

    private String login;
    private String senha;

    private Sexo sexo;
}
