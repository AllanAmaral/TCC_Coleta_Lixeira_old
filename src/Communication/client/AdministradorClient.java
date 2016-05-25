package Communication.Client;

import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import Communication.Server.CommunicationInterface;

/**
 *
 * @author Allan.Amaral
 * 
 * Responsável pela interação entre usuário e processo­servidor
 */
public class AdministradorClient {

    public static void main(String[] args) throws Exception {
        try {
            CommunicationInterface communicationInterface = (CommunicationInterface) Naming.lookup("//localhost/TCC_Coleta_Lixo_RMI");
            
            Thread.sleep(5000);
            
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",JOptionPane.ERROR);
        }
    }
}