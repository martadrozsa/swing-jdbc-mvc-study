
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
        return professorDAO.deleteProfessorById(id);
    }
      
    public List<Professor> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {
        switch (comboBoxTipoPesquisa) {
            case "Titulação":
                return professorDAO.getMinhaListByTitulacao(inputPesquisa);

            case "Salário":
                return professorDAO.getMinhaListBySalario(Double.parseDouble(inputPesquisa));

            case "Nome":
                return professorDAO.getMinhaListByNome(inputPesquisa);

            case "Idade":
                return professorDAO.getMinhaListByIdade(Integer.parseInt(inputPesquisa));
        }
        return new ArrayList<>();
    }   
}