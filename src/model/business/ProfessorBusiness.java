
package model.business;

import dao.AlunoDAO;
import java.util.ArrayList;
import dao.ProfessorDAO;
import java.util.List;
import model.entity.Professor;

public class ProfessorBusiness {
    

    public ArrayList getListaProfessores() {
        return ProfessorDAO.minhaLista;
    }
    
    public boolean insertProfessorIntoBD(Professor professor) {
        ProfessorDAO.minhaLista.add(professor);
        return true;
    }
    
    public boolean deleteProfessorFromBD(int id) {
        int indice = this.procuraIndiceProfessor(id);
        ProfessorDAO.minhaLista.remove(indice);
        return true;
    }
    
    public boolean updateProfessorInBD(int id, Professor professor) {
        int indice = this.procuraIndiceProfessor(id);
        ProfessorDAO.minhaLista.set(indice, professor);
        return true;
    }

    private int procuraIndiceProfessor(int id) {
        int indice = -1;
        for (int i = 0; i < ProfessorDAO.minhaLista.size(); i++) {
            Professor currProfessor = ProfessorDAO.minhaLista.get(i);
            if (currProfessor.getId() == id) {
                indice = i;
                break;
            }
        }
        return indice;
    }
    
    public int maiorId() {
        return ProfessorDAO.maiorId();
    }
    
    public List<Professor> getMinhaLista(String inputPesquisa, String comboBoxTipoPesquisa) {
        ArrayList<Professor> resultList = new ArrayList<>();

        for (int i = 0; i < ProfessorDAO.minhaLista.size(); i++) {
            Professor currProfessor = ProfessorDAO.minhaLista.get(i);
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

    
