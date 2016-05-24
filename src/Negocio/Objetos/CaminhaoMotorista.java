/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Objetos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allan.Amaral
 */
@Entity
@Table(name = "caminhao_motorista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaminhaoMotorista.findAll", query = "SELECT c FROM CaminhaoMotorista c"),
    @NamedQuery(name = "CaminhaoMotorista.findByIdCaminhaoMotorista", query = "SELECT c FROM CaminhaoMotorista c WHERE c.idCaminhaoMotorista = :idCaminhaoMotorista"),
    @NamedQuery(name = "CaminhaoMotorista.findByIdCaminhao", query = "SELECT c FROM CaminhaoMotorista c WHERE c.idCaminhao = :idCaminhao"),
    @NamedQuery(name = "CaminhaoMotorista.findByIdMotorista", query = "SELECT c FROM CaminhaoMotorista c WHERE c.idMotorista = :idMotorista"),
    @NamedQuery(name = "CaminhaoMotorista.findByDataHora", query = "SELECT c FROM CaminhaoMotorista c WHERE c.dataHora = :dataHora")})
public class CaminhaoMotorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CAMINHAO_MOTORISTA")
    private Integer idCaminhaoMotorista;
    @Column(name = "ID_CAMINHAO")
    private Integer idCaminhao;
    @Column(name = "ID_MOTORISTA")
    private Integer idMotorista;
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public CaminhaoMotorista() {
    }

    public CaminhaoMotorista(Integer idCaminhaoMotorista) {
        this.idCaminhaoMotorista = idCaminhaoMotorista;
    }

    public Integer getIdCaminhaoMotorista() {
        return idCaminhaoMotorista;
    }

    public void setIdCaminhaoMotorista(Integer idCaminhaoMotorista) {
        this.idCaminhaoMotorista = idCaminhaoMotorista;
    }

    public Integer getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaminhaoMotorista != null ? idCaminhaoMotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaminhaoMotorista)) {
            return false;
        }
        CaminhaoMotorista other = (CaminhaoMotorista) object;
        if ((this.idCaminhaoMotorista == null && other.idCaminhaoMotorista != null) || (this.idCaminhaoMotorista != null && !this.idCaminhaoMotorista.equals(other.idCaminhaoMotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.CaminhaoMotorista[ idCaminhaoMotorista=" + idCaminhaoMotorista + " ]";
    }
    
}
