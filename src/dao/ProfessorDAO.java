package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.Professor;

public class ProfessorDAO {

    private Connection connect;
    private Statement statement;

    public ProfessorDAO() {

        connectToDatabase("localhost", 3306, "sistema_curso", "root", "pass");
    }

    private void connectToDatabase(String ip, int port, String schema, String username, String password) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionStr = "jdbc:mysql://" + ip + ":" + port + "/" + schema + "?user=" + username + "&password=" + password + "&serverTimezone=UTC";

            connect = DriverManager.getConnection(connectionStr);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

        } catch (Exception ex) {
            System.out.println("Failed to connect to database: " + ex.toString());
        }
    }

    // public static ArrayList<Professor> minhaLista = new ArrayList<>();
    public List<Professor> getMinhaListaProfessores() {
        try {
            String query = "SELECT * FROM professor";

            // Recupera dados da base.
            ResultSet resultSet = statement.executeQuery(query);

            List<Professor> professores = parseResultSetToProfessor(resultSet);
            
            // Todos os alunos na lista "professores"
            return professores;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public boolean insertProfessor(Professor professor) {
        String insertStatement = "INSERT INTO professor(salario, titulacao, nome, idade) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(insertStatement);
            preparedStatement.setDouble(1, professor.getSalario());
            preparedStatement.setString(2, professor.getTitulacao());
            preparedStatement.setString(3, professor.getNome());
            preparedStatement.setInt(4, professor.getIdade());
            preparedStatement.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
            return false;
        }
        return true;
    }

    public boolean updateProfessor(Professor professor) {
        String updateStatement = "UPDATE professor SET salario=?, titulacao=?, nome=?, idade=? WHERE id=?";
        
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(updateStatement);
            preparedStatement.setDouble(1, professor.getSalario());
            preparedStatement.setString(2, professor.getTitulacao());
            preparedStatement.setString(3, professor.getNome());
            preparedStatement.setInt(4, professor.getIdade());
            preparedStatement.setInt(5, professor.getId());
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while updating data: " + ex.toString());
            return false;
        }
        return true;
    }
    
    public boolean deleteProfessorById(int id) {
        String deleteStatement = "DELETE FROM professor WHERE id=?";
        
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(deleteStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            return false;
        }
        return true;
    }
     
    public List<Professor> parseResultSetToProfessor(ResultSet resultSet) throws SQLException {
        List<Professor> professores = new ArrayList<>();

        while (resultSet.next()) {
            double salario = resultSet.getDouble("salario");
            String titulacao = resultSet.getString("titulacao");
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            int idade = resultSet.getInt("idade");

            Professor professor = new Professor(salario, titulacao, id, nome, idade);
            professores.add(professor);
        }

        return professores;
    } 
    
    public List<Professor> getMinhaListByNome(String nome) {
        // database, me entrega todos as linhas na tabela professor que tem o nome parecido com "nome".
            String termoBusca = "%" + nome + "%";
            String queryStatement = "SELECT * FROM professor WHERE nome LIKE ?";
            
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = parseResultSetToProfessor(resultSet);
            
            preparedStatement.close();
            // Todos os professores na lista "professores"
            return professores;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Professor> getMinhaListByTitulacao(String titulacao) {
      // database, me entrega todos as linhas na tabela professor que tem a titulação  parecido com "titulacao".
            String termoBusca = "%" + titulacao + "%";
            String queryStatement = "SELECT * FROM professor WHERE titulacao LIKE ?";
      
        try {

            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = parseResultSetToProfessor(resultSet);
            
            preparedStatement.close();
            // Todos os professores na lista "professores"
            return professores;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Professor> getMinhaListByIdade(int idade) {
        // database, me entrega todos as linhas na tabela professore que tem a idade = ?
        String queryStatement = "SELECT * FROM professor WHERE idade=?";
        
        try {            
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setInt(1, idade);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = parseResultSetToProfessor(resultSet);
            
            preparedStatement.close();
            // Todos os professores na lista "professores"
            return professores;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Professor> getMinhaListBySalario(double salario) {
         // database, me entrega todos as linhas na tabela professore que tem o salario = ?
        String queryStatement = "SELECT * FROM professor WHERE salario=?";
        
        try {            
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setDouble(1, salario);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = parseResultSetToProfessor(resultSet);
            
            preparedStatement.close();
            // Todos os professores na lista "professores"
            return professores;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }

}
