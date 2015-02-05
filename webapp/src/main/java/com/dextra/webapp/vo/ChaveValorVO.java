package com.dextra.webapp.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.dextra.webapp.entity.ChaveValor;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="value")
public class ChaveValorVO {
    
    @XmlElement
    private String nome;

    @XmlElement
    private List<ChaveValor> valores;
    
    public ChaveValorVO() {}
    
    public ChaveValorVO(String nome, List<ChaveValor> valores) {
        this.nome = nome;
        this.valores = valores;
    }
    
    public String getNome() {
        return nome;
    }

    public List<ChaveValor> getValores() {
        return valores;
    }
    
}
