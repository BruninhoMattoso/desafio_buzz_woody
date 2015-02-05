package com.dextra.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Entity
public class ChaveValor {

    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    @Column(length = 250)
    private String chave;

    @XmlElement
    @Column(length = 250)
    private String valor;
    
    @XmlElement
    @Column(length = 50)
    private String dataHora;
    
    @XmlElement
    @Column(length = 50)
    private String usuario;

    public Long getId() {
        return this.id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
