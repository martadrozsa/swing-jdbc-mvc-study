package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.Aluno;

public class AlunoDAO {
    
    private Connection connect;
    private Statement statement;
   
    public AlunoDAO() {
        connectToDatabase("localhost", 3306, "sistema_curso", "root", "pass");
    }
    
    private void connectToDatabase(String ip, int port, String schema, String username, String password) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            String connectionStr = "jdbc:mysql://" + ip + ":" + port + "/" + schema + "?user=" + username + "&password=" + password + "&serverTimezone=UTC";
           
            connect = DriverManager.getConnection(connectionStr);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (Exception ex) {
            System.out.println("Failed to connect to database: " + ex.toString());
        }
    }
        
    public List<Aluno> getMinhaListaAlunos(){
        try {
            String query = "SELECT * FROM aluno";

            // Recupera dados da base.
            ResultSet resultSet = statement.executeQuery(query);

            List<Aluno> alunos = parseResultSetToAluno(resultSet);

            // Todos os alunos na lista "alunos"
            return alunos;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }

    // transforma as rows do database -> objetos em lista local
    // transforma os dados da tabela na base em dados (objetos) em uma lista
    public List<Aluno> parseResultSetToAluno(ResultSet resultSet) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        
        while (resultSet.next()) {
            String curso = resultSet.getString("curso");
            int fase = resultSet.getInt("fase");
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            int idade = resultSet.getInt("idade");

            Aluno aluno = new Aluno(curso, fase, id, nome, idade);
            alunos.add(aluno);
        }
        
        return alunos;
    }
    
    public boolean insertAluno(Aluno aluno) {
        try {
            String insertStatement = "INSERT INTO aluno(curso, fase, nome, idade) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connect.prepareStatement(insertStatement);
            preparedStatement.setString(1, aluno.getCurso());
            preparedStatement.setInt(2, aluno.getFase());
            preparedStatement.setString(3, aluno.getNome());
            preparedStatement.setInt(4, aluno.getIdade());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
            return false;
        }
        
        return true;
    }
    
    public boolean updateAluno(Aluno aluno) {
        try {
            String updateStatement = "UPDATE aluno SET curso=?, fase=?, nome=?, idade=? WHERE id=?";
            PreparedStatement preparedStatement = connect.prepareStatement(updateStatement);
            
            preparedStatement.setString(1, aluno.getCurso());
            preparedStatement.setInt(2, aluno.getFase());
            preparedStatement.setString(3, aluno.getNome());
            preparedStatement.setInt(4, aluno.getIdade());

            preparedStatement.setInt(5, aluno.getId());
            
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while updating data: " + ex.toString());
            return false;
        }
        
        return true;
    }
    
    public boolean deleteAlunoById(int id) {
        try {
            String deleteStatement = "DELETE FROM aluno WHERE id=?";
            PreparedStatement preparedStatement = connect.prepareStatement(deleteStatement);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            return false;
        }
        
        return true;
    }
    
    public List<Aluno> getMinhaListByNome(String nome) {
        // database, me entrega todos as linhas na tabela aluno que tem o nome parecido com "nome".
        try {
            String termoBusca = "%" + nome + "%";
            
            String queryStatement = "SELECT * FROM aluno WHERE nome LIKE ?";
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = parseResultSetToAluno(resultSet);

            // Todos os alunos na lista "alunos"
            return alunos;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Aluno> getMinhaListByCurso(String curso) {
      // database, me entrega todos as linhas na tabela aluno que tem o nome parecido com "curso".
        try {
            String termoBusca = "%" + curso + "%";
            
            String queryStatement = "SELECT * FROM aluno WHERE curso LIKE ?";
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = parseResultSetToAluno(resultSet);

            // Todos os alunos na lista "alunos"
            return alunos;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Aluno> getMinhaListByIdade(int idade) {
        // database, me entrega todos as linhas na tabela aluno que tem o nome parecido com "nome".
        try {            
            String queryStatement = "SELECT * FROM aluno WHERE idade=?";
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setInt(1, idade);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = parseResultSetToAluno(resultSet);

            // Todos os alunos na lista "alunos"
            return alunos;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public List<Aluno> getMinhaListByFase(int fase) {
         // database, me entrega todos as linhas na tabela aluno que tem o nome parecido com "nome".
        try {            
            String queryStatement = "SELECT * FROM aluno WHERE fase=?";
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setInt(1, fase);

            // Recupera dados da base.
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = parseResultSetToAluno(resultSet);

            // Todos os alunos na lista "alunos"
            return alunos;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    
    
    
}
