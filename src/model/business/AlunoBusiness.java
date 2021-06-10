package model.business;

import dao.AlunoDAO;
import java.util.List;
import java.util.ArrayList;
import model.entity.Aluno;

public class AlunoBusiness {
      
    private AlunoDAO alunoDAO;

    public AlunoBusiness() {
        this.alunoDAO = new AlunoDAO();
    }

    public List<Aluno> getMinhaLista() {
        return alunoDAO.getMinhaListaAlunos();
    }
    
    public boolean insertAlunoIntoBD(Aluno aluno) {
        boolean isSuccess = alunoDAO.insertAluno(aluno);
        return isSuccess;
    }
      
    public boolean updateAlunoInBD(Aluno aluno) {
        return alunoDAO.updateAluno(aluno);
    }

    public boolean deleteAlunoFromBD(int id) {
        return alunoDAO.deleteAlunoById(id);
    }

    public List<Aluno> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {        
        switch (comboBoxTipoPesquisa) {
            case "Nome":
                return alunoDAO.getMinhaListByNome(inputPesquisa);

            case "Curso":
                return alunoDAO.getMinhaListByCurso(inputPesquisa);

            case "Idade":
                return alunoDAO.getMinhaListByIdade(Integer.parseInt(inputPesquisa));

            case "Fase":
                return alunoDAO.getMinhaListByFase(Integer.parseInt(inputPesquisa));
        }
        
        return new ArrayList<>();
    }
     
}

