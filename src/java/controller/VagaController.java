package controller;

import dao.VagaDAO;
import java.util.List;
import model.Vagas;

public class VagaController {
    public String inserirVaga(Vagas vaga){
        return new VagaDAO().createVaga(vaga);
    }
        
    public String alterarVaga(Vagas vaga){
        return new VagaDAO().updateVaga(vaga);
    }
    
    public String excluirVaga(int idVaga){
        return new VagaDAO().deleteVaga(idVaga);
    }
    
    public List<Vagas> consultarVagas(){
        return new VagaDAO().readVagas();
    }
        
    public Vagas consultarVaga(int idVaga){
        return new VagaDAO().readVaga(idVaga);
    }
}
