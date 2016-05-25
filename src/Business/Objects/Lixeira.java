package Business.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allan.Amaral
 */
@Entity
@Table(name = "lixeira")
@XmlRootElement
public class Lixeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIXEIRA")
    private Integer idLixeira;
    
    @Column(name = "CAPACIDADE_LIXEIRA_KG")
    private BigDecimal capacidadeLixeiraKg;
    
    @Column(name = "CAPACIDADE_LIXEIRA_LT")
    private BigDecimal capacidadeLixeiraLt;
    
    @Column(name = "COLETADO_LIXEIRA_KG")
    private BigDecimal coletadoLixeiraKg;
    
    @Column(name = "COLETADO_LIXEIRA_LT")
    private BigDecimal coletadoLixeiraLt;
    
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    public Lixeira() {
    }

    public Lixeira(Integer idLixeira) {
        this.idLixeira = idLixeira;
    }

    public Integer getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(Integer idLixeira) {
        this.idLixeira = idLixeira;
    }

    public BigDecimal getCapacidadeLixeiraKg() {
        return capacidadeLixeiraKg;
    }

    public void setCapacidadeLixeiraKg(BigDecimal capacidadeLixeiraKg) {
        this.capacidadeLixeiraKg = capacidadeLixeiraKg;
    }

    public BigDecimal getCapacidadeLixeiraLt() {
        return capacidadeLixeiraLt;
    }

    public void setCapacidadeLixeiraLt(BigDecimal capacidadeLixeiraLt) {
        this.capacidadeLixeiraLt = capacidadeLixeiraLt;
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Objetos.Lixeira[ idLixeira=" + idLixeira + " ]";
    }
    
}
