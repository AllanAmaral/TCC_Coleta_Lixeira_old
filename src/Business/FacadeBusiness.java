package Business;

import java.math.BigDecimal;

/**
 *
 * @author Allan.Amaral
 * 
 * Delega para os controladores as chamadas de métodos
 */
public class FacadeBusiness {
    
    private final MotoristaController motoristaController;
    private final CaminhaoController caminhaoController;
    private final CaminhaoMotoristaController caminhaoMotoristaController;
    private final HistoricoColetaController historicoColetaController;
    private final LixeiraController lixeiraController;

    public FacadeBusiness() {
        motoristaController = new MotoristaController();
        caminhaoController = new CaminhaoController();
        caminhaoMotoristaController = new CaminhaoMotoristaController();
        historicoColetaController = new HistoricoColetaController();
        lixeiraController = new LixeiraController();
    }
    
    public void cadastrarMotorista(Integer matricula, String nomeMotorista) throws Exception {
        motoristaController.registrar(matricula, nomeMotorista);
    }
    
    public void cadastrarCaminhao(String placa, BigDecimal capacidadeCaminhaoKg, BigDecimal capacidadeCaminhaoLt, 
            BigDecimal coletadoCaminhaoKg, BigDecimal coletadoCaminhaoLt) throws Exception {
        caminhaoController.registrar(placa, capacidadeCaminhaoKg, capacidadeCaminhaoLt, 
                coletadoCaminhaoKg, coletadoCaminhaoLt);
 
    }
    
    public void cadastrarLixeira(BigDecimal capacidadeLixeiraKg, BigDecimal capacidadeLixeiraLt,
            BigDecimal coletadoLixeiraKg, BigDecimal coletadoLixeiraLt,
            BigDecimal latitude, BigDecimal longitude) throws Exception {
        lixeiraController.registrar(capacidadeLixeiraKg, capacidadeLixeiraLt, 
                coletadoLixeiraKg, coletadoLixeiraLt, latitude, longitude);
    }
}
