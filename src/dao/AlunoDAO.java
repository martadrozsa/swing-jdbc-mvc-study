package dao;

import java.util.ArrayList;
import model.entity.Aluno;

public class AlunoDAO {
    
   
    public static ArrayList<Aluno> minhaLista = new ArrayList<>();
    
    static {{
        minhaLista.add(new Aluno("Turismo",2,0,"Maria Luiza", 19));
        minhaLista.add(new Aluno("Engenharia Elétrica",3,1,"João Pedro", 25));
        minhaLista.add(new Aluno("Filosofia",1,2,"Lucas Santos", 20));
        minhaLista.add(new Aluno("Medicina",4,3,"Beatriz Oliveria", 27));
        minhaLista.add(new Aluno("História",6,4,"Carlos Silva", 23));
        minhaLista.add(new Aluno("Ciência da Computação",2,5,"Camila Rosa", 32));
        minhaLista.add(new Aluno("Sistemas de Informação",3,6,"Ana Lima", 29));
        minhaLista.add(new Aluno("Enfermagem",1,7,"Pedro Henrique", 19));
        minhaLista.add(new Aluno("Direito",7,8,"Bruno Carvalho", 34));
        minhaLista.add(new Aluno("Filosofia",8,9,"Paulo Borges", 25));
        
    }}
    
    // método que fornece o maior CAMPO ID dentro da nossa base de dados
    public static int maiorId() {
        int maiorID = 0;
        for (int i = 0; i < minhaLista.size(); i++) {
            if (minhaLista.get(i).getId() > maiorID) {
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;  
    }    
}
