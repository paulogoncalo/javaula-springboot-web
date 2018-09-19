package javaula.springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prjunior
 * @version $Revision: $<br/>
 * $Id: $
 * @since 28/08/18 23:36
 */
@Entity
@Table(name = "EMPREGADO")
public class Empregado {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    public Long getId () {
        return id;
    }

    public void setId (final Long id) {
        this.id = id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (final String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento () {
        return dataNascimento;
    }

    public void setDataNascimento (final LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDepartamento () {
        return departamento;
    }

    public void setDepartamento (final String departamento) {
        this.departamento = departamento;
    }
}
