
package model.business;

import dao.AlunoDAO;
import java.util.ArrayList;
import dao.ProfessorDAO;
import java.util.List;
import model.entity.Professor;

public class ProfessorBusiness {
    
    private ProfessorDAO professorDAO;

    public ProfessorBusiness() {
        this.professorDAO = new ProfessorDAO();
    }
    
    public List<Professor> getMinhaLista() {
        return professorDAO.getMinhaListaProfessores();
    }
    
    public boolean insertProfessorIntoBD(Professor professor) {
        boolean isSucces = professorDAO.insertProfessor(professor);
        return isSucces;
    }

    public boolean updateProfessorInBD(Professor professor) {
        professorDAO.updateProfessor(professor);
        return true;
    }
    
    public boolean deleteProfessorFromBD(int id) {
        int indice = this.procuraIndiceProfessor(id);
        professorDAO.getMinhaListaProfessores().remove(indice);
        return true;
    }
    
    private int procuraIndiceProfessor(int id) {
        int indice = -1;
        for (int i = 0; i < professorDAO.getMinhaListaProfessores().size(); i++) {
            Professor currProfessor = professorDAO.getMinhaListaProfessores().get(i);
            if (currProfessor.getId() == id) {
                indice = i;
                break;
            }
        }
        return indice;
    }
      
    public List<Professor> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {
        List<Professor> resultList = new ArrayList<>();

        for (int i = 0; i < professorDAO.getMinhaListaProfessores().size(); i++) {
            Professor currProfessor = professorDAO.getMinhaListaProfessores().get(i);
            String novoInputPesquisa = inputPesquisa.toLowerCase();

            switch (comboBoxTipoPesquisa) {
                case "Nome":
                    if (currProfessor.getNome().toLowerCase().contains(novoInputPesquisa)) {
                        resultList.add(currProfessor);
                    }
                    break;

                case "Idade":
                    if (currProfessor.getIdade() == Integer.parseInt(inputPesquisa)) {
                        resultList.add(currProfessor);
                    }
                    break;

                case "Titulação":
                    if (currProfessor.getTitulacao().toLowerCase().contains(novoInputPesquisa)) {
                        resultList.add(currProfessor);
                    }
                break;
                case "Salario":
                    if (currProfessor.getSalario() == Double.parseDouble(inputPesquisa)) {
                        resultList.add(currProfessor);
                    }
                    break;
            }
        }
        return resultList;
    }

}

    
