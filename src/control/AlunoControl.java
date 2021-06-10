package control;

import java.util.List;
import model.entity.Aluno;
import model.business.AlunoBusiness;

public class AlunoControl {

    private final AlunoBusiness alunoBusiness;

    public AlunoControl() {
        this.alunoBusiness = new AlunoBusiness();
    }

    public boolean cadastrar(String curso, int fase, String nome, int idade) {
        Aluno aluno = new Aluno(curso, fase, 0, nome, idade);

        return alunoBusiness.insertAlunoIntoBD(aluno);
    }

    public boolean editar(String curso, int fase, int id, String nome, int idade) {
        Aluno aluno = new Aluno(curso, fase, id, nome, idade);
        return alunoBusiness.updateAlunoInBD(aluno);
    }

    public boolean apagar(int id) {
        return alunoBusiness.deleteAlunoFromBD(id);
    }

    public List<Aluno> getMinhaLista() {
        return alunoBusiness.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        List<Aluno> minhalista = alunoBusiness.getMinhaLista();
        int tamanho = minhalista.size();
        String[][] matrizAlunos = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            matrizAlunos[i][0] = minhalista.get(i).getId() + "";
            matrizAlunos[i][1] = minhalista.get(i).getNome();
            matrizAlunos[i][2] = minhalista.get(i).getIdade() + "";
            matrizAlunos[i][3] = minhalista.get(i).getCurso();
            matrizAlunos[i][4] = minhalista.get(i).getFase() + "";
        }
        return matrizAlunos;
    }
    
    public String[][] getMinhaMatrizTexto(String inputPesquisa, String comboBoxTipoPesquisa) {
        List<Aluno> resultList =  alunoBusiness.getMinhaLista(inputPesquisa, comboBoxTipoPesquisa);
        
        int tamanho = resultList.size();
        String[][] resulMatrizAlunos = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            resulMatrizAlunos[i][0] = resultList.get(i).getId() + "";
            resulMatrizAlunos[i][1] = resultList.get(i).getNome();
            resulMatrizAlunos[i][2] = resultList.get(i).getIdade() + "";
            resulMatrizAlunos[i][3] = resultList.get(i).getCurso();
            resulMatrizAlunos[i][4] = resultList.get(i).getFase() + "";
        }
        return resulMatrizAlunos;
    }
}
