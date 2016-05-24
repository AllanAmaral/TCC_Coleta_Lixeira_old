/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Objetos;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "historico_coleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoColeta.findAll", query = "SELECT h FROM HistoricoColeta h"),
    @NamedQuery(name = "HistoricoColeta.findByIdHistoricoColeta", query = "SELECT h FROM HistoricoColeta h WHERE h.idHistoricoColeta = :idHistoricoColeta"),
    @NamedQuery(name = "HistoricoColeta.findByIdLixeira", query = "SELECT h FROM HistoricoColeta h WHERE h.idLixeira = :idLixeira"),
    @NamedQuery(name = "HistoricoColeta.findByIdCaminhaoMotorista", query = "SELECT h FROM HistoricoColeta h WHERE h.idCaminhaoMotorista = :idCaminhaoMotorista"),
    @NamedQuery(name = "HistoricoColeta.findByColetadoLixeiraKg", query = "SELECT h FROM HistoricoColeta h WHERE h.coletadoLixeiraKg = :coletadoLixeiraKg"),
    @NamedQuery(name = "HistoricoColeta.findByColetadoLixeiraLt", query = "SELECT h FROM HistoricoColeta h WHERE h.coletadoLixeiraLt = :coletadoLixeiraLt"),
    @NamedQuery(name = "HistoricoColeta.findByDataHora", query = "SELECT h FROM HistoricoColeta h WHERE h.dataHora = :dataHora")})
public class HistoricoColeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_HISTORICO_COLETA")
    private Integer idHistoricoColeta;
    @Column(name = "ID_LIXEIRA")
    private Integer idLixeira;
    @Column(name = "ID_CAMINHAO_MOTORISTA")
    private Integer idCaminhaoMotorista;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COLETADO_LIXEIRA_KG")
    private BigDecimal coletadoLixeiraKg;
    @Column(name = "COLETADO_LIXEIRA_LT")
    private BigDecimal coletadoLixeiraLt;
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public HistoricoColeta() {
    }

    public HistoricoColeta(Integer idHistoricoColeta) {
        this.idHistoricoColeta = idHistoricoColeta;
    }

    public Integer getIdHistoricoColeta() {
        return idHistoricoColeta;
    }

    public void setIdHistoricoColeta(Integer idHistoricoColeta) {
        this.idHistoricoColeta = idHistoricoColeta;
    }

    public Integer getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(Integer idLixeira) {
        this.idLixeira = idLixeira;
    }

    public Integer getIdCaminhaoMotorista() {
        return idCaminhaoMotorista;
    }

    public void setIdCaminhaoMotorista(Integer idCaminhaoMotorista) {
        this.idCaminhaoMotorista = idCaminhaoMotorista;
    }

    public BigDecimal getColetadoLixeiraKg() {
        return coletadoLixeiraKg;
    }

    public void setColetadoLixeiraKg(BigDecimal coletadoLixeiraKg) {
        this.coletadoLixeiraKg = coletadoLixeiraKg;
    }

    public BigDecimal getColetadoLixeiraLt() {
        return coletadoLixeiraLt;
    }

    public void setColetadoLixeiraLt(BigDecimal coletadoLixeiraLt) {
        this.coletadoLixeiraLt = coletadoLixeiraLt;
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
        hash += (idHistoricoColeta != null ? idHistoricoColeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoColeta)) {
            return false;
        }
        HistoricoColeta other = (HistoricoColeta) object;
        if ((this.idHistoricoColeta == null && other.idHistoricoColeta != null) || (this.idHistoricoColeta != null && !this.idHistoricoColeta.equals(other.idHistoricoColeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objetos.HistoricoColeta[ idHistoricoColeta=" + idHistoricoColeta + " ]";
    }
    
}
