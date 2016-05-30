package Business.Objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allan.Amaral
 */
@Entity
@Table(name = "caminhao_lixeira")
@XmlRootElement
public class CaminhaoLixeira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CAMINHAO_LIXEIRA")
    private Integer idCaminhaoLixeira;

    @Column(name = "ID_CAMINHAO")
    private String idCaminhao;

    @Column(name = "ID_LIXEIRA")
    private Integer idLixeira;

    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public CaminhaoLixeira() {
    }

    public CaminhaoLixeira(String idCaminhao, Integer idLixeira, Date dataHora) {
        this.idCaminhao = idCaminhao;
        this.idLixeira = idLixeira;
        this.dataHora = dataHora;
    }
    
    public Integer getIdCaminhaoLixeira() {
        return idCaminhaoLixeira;
    }

    public void setIdCaminhaoLixeira(Integer idCaminhaoLixeira) {
        this.idCaminhaoLixeira = idCaminhaoLixeira;
    }

    public String getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(String idCaminhao) {
        this.idCaminhao = idCaminhao;
    }

    public Integer getIdLixeira() {
        return idLixeira;
    }

    public void setIdLixeira(Integer idLixeira) {
        this.idLixeira = idLixeira;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Objetos.CaminhaoLixeira[ idCaminhaoLixeira=" + idCaminhaoLixeira + " ]";
    }

}
