/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Objetos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allan.Amaral
 */
@Entity
@Table(name = "motorista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m"),
    @NamedQuery(name = "Motorista.findByIdMotorista", query = "SELECT m FROM Motorista m WHERE m.idMotorista = :idMotorista"),
    @NamedQuery(name = "Motorista.findByNomeMotorista", query = "SELECT m FROM Motorista m WHERE m.nomeMotorista = :nomeMotorista")})
public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MOTORISTA")
    private Integer idMotorista;
    @Column(name = "NOME_MOTORISTA")
    private String nomeMotorista;

    public Motorista() {
    }

    public Motorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotorista != null ? idMotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.idMotorista == null && other.idMotorista != null) || (this.idMotorista != null && !this.idMotorista.equals(other.idMotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.Motorista[ idMotorista=" + idMotorista + " ]";
    }
    
}
