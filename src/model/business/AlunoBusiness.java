package model.business;

import dao.AlunoDAO;
import java.util.List;
import java.util.ArrayList;
import model.entity.Aluno;

public class AlunoBusiness {
      

    public ArrayList getMinhaLista() {
        return AlunoDAO.minhaLista;
    }
    
    public boolean insertAlunoIntoBD(Aluno aluno) {
        AlunoDAO.minhaLista.add(aluno);
        return true;
    }
    
    public boolean deleteAlunoFromBD(int id) {
        int indice = this.procuraIndiceAluno(id);
        AlunoDAO.minhaLista.remove(indice);
        return true;
    }
    
    public boolean updateAlunoInBD(int id, Aluno aluno) {
        int indice = this.procuraIndiceAluno(id);
        AlunoDAO.minhaLista.set(indice, aluno);
        return true;
    }
    
    private int procuraIndiceAluno(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.minhaLista.size(); i++) {
            if (AlunoDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
    
    public int maiorId() {
        return AlunoDAO.maiorId();
    }
    
    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndiceAluno(id);
        return AlunoDAO.minhaLista.get(indice);
    }
      
    
    public List<Aluno> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {
        ArrayList<Aluno> resultList = new ArrayList<>();
       
        for (int i = 0; i < AlunoDAO.minhaLista.size(); i++) {
            Aluno currAluno = AlunoDAO.minhaLista.get(i);
            String novoInputPesquisa = inputPesquisa.toLowerCase();
            
            switch (comboBoxTipoPesquisa) {
                case "Nome":
                    if (currAluno.getNome().toLowerCase().contains(novoInputPesquisa)) {
                        resultList.add(currAluno);
                    }
                break;

                case "Idade":
                    if (currAluno.getIdade() == Integer.parseInt(inputPesquisa)) {
                        resultList.add(currAluno);
                    }
                break;

                case "Curso":
                    if (currAluno.getCurso().toLowerCase().contains(novoInputPesquisa)) {
                        resultList.add(currAluno);
                    }
                break;

                case "Fase":
                    if (currAluno.getFase()== Integer.parseInt(inputPesquisa)) {
                        resultList.add(currAluno);
                    }
                break;
            }
        }
        return resultList;
    }
}

