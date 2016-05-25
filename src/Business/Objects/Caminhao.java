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
@Table(name = "caminhao")
@XmlRootElement
public class Caminhao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CAMINHAO")
    private Integer idCaminhao;
    
    @Column(name = "CAPACIDADE_CAMINHAO_KG")
    private BigDecimal capacidadeCaminhaoKg;
    
    @Column(name = "CAPACIDADE_CAMINHAO_LT")
    private BigDecimal capacidadeCaminhaoLt;
    
    @Column(name = "COLETADO_CAMINHAO_KG")
    private BigDecimal coletadoCaminhaoKg;
    
    @Column(name = "COLETADO_CAMINHAO_LT")
    private BigDecimal coletadoCaminhaoLt;

    public Caminhao() {
    }

    public Caminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Integer getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Integer idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public BigDecimal getCapacidadeCaminhaoKg() {
        return capacidadeCaminhaoKg;
    }

    public void setCapacidadeCaminhaoKg(BigDecimal capacidadeCaminhaoKg) {
        this.capacidadeCaminhaoKg = capacidadeCaminhaoKg;
    }

    public BigDecimal getCapacidadeCaminhaoLt() {
        return capacidadeCaminhaoLt;
    }

    public void setCapacidadeCaminhaoLt(BigDecimal capacidadeCaminhaoLt) {
        this.capacidadeCaminhaoLt = capacidadeCaminhaoLt;
    }

    public BigDecimal getColetadoCaminhaoKg() {
        return coletadoCaminhaoKg;
    }

    public void setColetadoCaminhaoKg(BigDecimal coletadoCaminhaoKg) {
        this.coletadoCaminhaoKg = coletadoCaminhaoKg;
    }

    public BigDecimal getColetadoCaminhaoLt() {
        return coletadoCaminhaoLt;
    }

    public void setColetadoCaminhaoLt(BigDecimal coletadoCaminhaoLt) {
        this.coletadoCaminhaoLt = coletadoCaminhaoLt;
    }

    @Override
    public String toString() {
        return "Objetos.Caminhao[ idCaminhao=" + idCaminhao + " ]";
    }
    
}
