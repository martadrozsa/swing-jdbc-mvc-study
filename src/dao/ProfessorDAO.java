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

            // Recupera dados da base
            ResultSet resultSet = statement.executeQuery(query);

            // transforma as rows do database -> objetos em lista local
            // transforma os dados da tabela na base em dados (objetos) em uma lista
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

        } catch (Exception ex) {
            System.out.println("Error while quering data: " + ex.toString());
            return new ArrayList<>();
        }
    }
    
    public boolean insertProfessor(Professor professor) {
        try {
            String insertStatement = "INSERT INTO professor(salario, titulacao, nome, idade) VALUES (?, ?, ?, ?)";
            
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
        try {
            String updateStatement = "UPDATE professor SET salario=?, titulacao=?, nome=?, idade=? WHERE id=?";
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

}
