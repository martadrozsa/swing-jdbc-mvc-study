
package control;

import java.util.ArrayList;
import java.util.List;
import model.business.ProfessorBusiness;
import model.entity.Professor;


public class ProfessorControl {
    

    private final ProfessorBusiness professorBusiness;
    
    
    public ProfessorControl() {
        this.professorBusiness = new ProfessorBusiness();
    }
    
       
    public boolean cadastrar(double salario, String titulacao, String nome, int idade) {
        Professor professor = new Professor(salario, titulacao, 0, nome, idade);
        return professorBusiness.insertProfessorIntoBD(professor);
    }

    public boolean editar(double salario, String titulacao, int id, String nome, int idade) {
        Professor professor = new Professor(salario, titulacao, id, nome, idade);
        return professorBusiness.updateProfessorInBD(professor); 
  
    }

    public boolean apagar(int id) {
        if (professorBusiness.deleteProfessorFromBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    public List getMinhaLista() {
        return professorBusiness.getMinhaLista();
    }

    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        List<Professor> minhalista = professorBusiness.getMinhaLista();
        int tamanho = minhalista.size();
        String[][] matrizProfessor = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            matrizProfessor[i][0] = minhalista.get(i).getId() + "";
            matrizProfessor[i][1] = minhalista.get(i).getNome();
            matrizProfessor[i][2] = minhalista.get(i).getIdade() + "";
            matrizProfessor[i][3] = minhalista.get(i).getTitulacao();
            matrizProfessor[i][4] = minhalista.get(i).getSalario() + "";
        }
        return matrizProfessor;
    }
    
    public String[][] getMinhaMatrizTexto(String inputPesquisa, String comboBoxTipoPesquisa) {
        List<Professor> resultList = professorBusiness.getMinhaLista(inputPesquisa, comboBoxTipoPesquisa);

        int tamanho = resultList.size();
        String[][] resulMatrizProfessores = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            resulMatrizProfessores[i][0] = resultList.get(i).getId() + "";
            resulMatrizProfessores[i][1] = resultList.get(i).getNome();
            resulMatrizProfessores[i][2] = resultList.get(i).getIdade() + "";
            resulMatrizProfessores[i][3] = resultList.get(i).getTitulacao();
            resulMatrizProfessores[i][4] = resultList.get(i).getSalario() + "";
        }
        return resulMatrizProfessores;
    }


}
