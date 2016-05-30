package Business.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class HistoricoColeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_HISTORICO_COLETA")
    private Integer idHistoricoColeta;

    @ManyToOne
    @JoinColumn(name="ID_LIXEIRA")
    private Lixeira lixeira;

    @ManyToOne
    @JoinColumn(name = "ID_CAMINHAO_MOTORISTA")
    private CaminhaoMotorista caminhaoMotorista;

    @Column(name = "COLETADO_LIXEIRA_KG")
    private BigDecimal coletadoLixeiraKg;

    @Column(name = "COLETADO_LIXEIRA_LT")
    private BigDecimal coletadoLixeiraLt;

    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public HistoricoColeta() {
    }

    public HistoricoColeta(Lixeira lixeira, CaminhaoMotorista caminhaoMotorista,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt, Date dataHora) {
        this.lixeira = lixeira;
        this.caminhaoMotorista = caminhaoMotorista;
        this.coletadoLixeiraKg = coletadoLixeiraKg;
        this.coletadoLixeiraLt = coletadoLixeiraLt;
        this.dataHora = dataHora;
    }

    public Integer getIdHistoricoColeta() {
        return idHistoricoColeta;
    }

    public void setIdHistoricoColeta(Integer idHistoricoColeta) {
        this.idHistoricoColeta = idHistoricoColeta;
    }

    public Lixeira getLixeira() {
        return lixeira;
    }

    public void setLixeira(Lixeira lixeira) {
        this.lixeira = lixeira;
    }

    public CaminhaoMotorista getCaminhaoMotorista() {
        return caminhaoMotorista;
    }

    public void setCaminhaoMotorista(CaminhaoMotorista caminhaoMotorista) {
        this.caminhaoMotorista = caminhaoMotorista;
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
    public String toString() {
        return "Objetos.HistoricoColeta[ idHistoricoColeta=" + idHistoricoColeta + " ]";
    }

}
