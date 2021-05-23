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
    
    public boolean deleteAlunoFromBD(int id) {
        return alunoDAO.deleteAlunoById(id);
    }
    
    public boolean updateAlunoInBD(Aluno aluno) {
        return alunoDAO.updateAluno(aluno);
    }
    
    private int procuraIndiceAluno(int id) {
        int indice = -1;
        for (int i = 0; i < alunoDAO.getMinhaListaAlunos().size(); i++) {
            if (alunoDAO.getMinhaListaAlunos().get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
    
    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndiceAluno(id);
        return alunoDAO.getMinhaListaAlunos().get(indice);
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
      
    
//    public List<Aluno> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {
//        
//        ArrayList<Aluno> resultList = new ArrayList<>();
//
//        for (int i = 0; i < alunoDAO.getMinhaListaAlunos().size(); i++) {
//            Aluno currAluno = alunoDAO.getMinhaListaAlunos().get(i);
//            String novoInputPesquisa = inputPesquisa.toLowerCase();
//            
//            switch (comboBoxTipoPesquisa) {
//                case "Nome":
//                    if (currAluno.getNome().toLowerCase().contains(novoInputPesquisa)) {
//                        resultList.add(currAluno);
//                    }
//                break;
//
//                case "Idade":
//                    if (currAluno.getIdade() == Integer.parseInt(inputPesquisa)) {
//                        resultList.add(currAluno);
//                    }
//                break;
//
//                case "Curso":
//                    if (currAluno.getCurso().toLowerCase().contains(novoInputPesquisa)) {
//                        resultList.add(currAluno);
//                    }
//                break;
//
//                case "Fase":
//                    if (currAluno.getFase()== Integer.parseInt(inputPesquisa)) {
//                        resultList.add(currAluno);
//                    }
//                break;
//            }
//        }
//        return resultList;
//    }
}

