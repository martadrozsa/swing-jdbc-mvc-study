package dao;

import java.util.ArrayList;
import model.entity.Professor;

public class ProfessorDAO {
    
    public static ArrayList<Professor> minhaLista = new ArrayList<>();
    
    
    static {{
        minhaLista.add(new Professor(4500.0, "Mestrado", 0, "Pedro Silva", 30));
        minhaLista.add(new Professor(7000.0, "Doutorado", 1, "Luiz Gustavo", 45));
        minhaLista.add(new Professor(3500.0, "Especialização", 2, "Ana Lucia", 23));
        minhaLista.add(new Professor(2500.0, "Graduação", 3, "Carlos Roberto", 26));
        minhaLista.add(new Professor(9000.0, "Doutorado", 4, "Maria Lima", 29));
    }}
    
    
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
  

