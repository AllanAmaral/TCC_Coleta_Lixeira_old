package Communication.client;

import Business.FacadeBusiness;
import Business.Objects.Motorista;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import Communication.server.CommunicationInterface;
import DAO.MotoristaRepository;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Allan.Amaral
 * 
 * Responsável pela interação entre usuário e processo­servidor
 */
public class AdministradorClient {                                                                      

    private static FacadeBusiness facade;
    
    public static void main(String[] args) throws Exception {
        try {
            CommunicationInterface communicationInterface = (CommunicationInterface) Naming.lookup("//localhost/TCC_Coleta_Lixo_RMI");
            facade = new FacadeBusiness();
            
            MotoristaRepository mr = new MotoristaRepository();
            List<Motorista> result = mr.buscarMotorista("allan");
            
            Thread.sleep(5000);
            
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarMotorista(Integer matricula, String nomeMotorista) {
        try {
            facade.cadastrarMotorista(matricula, nomeMotorista);
            System.out.println("Motorista cadastrado com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarCaminhao(String placa, BigDecimal capacidadeCaminhaoKg, BigDecimal capacidadeCaminhaoLt, 
            BigDecimal coletadoCaminhaoKg, BigDecimal coletadoCaminhaoLt) {
        try {
            facade.cadastrarCaminhao(placa, capacidadeCaminhaoKg, capacidadeCaminhaoLt, 
                    coletadoCaminhaoKg, coletadoCaminhaoLt);
            System.out.println("Caminhão cadastrado com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void cadastrarLixeira(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) {
        try {
            facade.cadastrarLixeira(capacidadeLixeiraKg, capacidadeLixeiraLt, 
                    coletadoLixeiraKg, coletadoLixeiraLt, latitude, longitude);
            System.out.println("Lixeira cadastrada com sucesso");
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}