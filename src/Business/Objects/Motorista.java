package Business.Objects;

import java.io.Serializable;
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
@Table(name = "motorista")
@XmlRootElement
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

    public Motorista(Integer idMotorista, String nomeMotorista) {
        this.idMotorista = idMotorista;
        this.nomeMotorista = nomeMotorista;
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
    public String toString() {
        return "Objetos.Motorista[ idMotorista=" + idMotorista + " ]";
    }

}
