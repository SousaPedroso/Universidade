package br.ufmt.ic.alg3.universidade.persistencia.MySQL;

import br.ufmt.ic.alg3.universidade.entidades.Professor;
import br.ufmt.ic.alg3.universidade.persistencia.ProfessorDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAOMySQL implements ProfessorDAO {

    private Connection con;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/universidadeTeste?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "a10f05s09";

    private void abreConexao() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Professor professor) {
        try{
            abreConexao();

            String sql = "INSERT INTO professor (nome, salario, cpf, email, titulo) VALUES (";
            sql += "'" + professor.getNome() + "', ";
            sql += "'" + professor.getSalario() + "', ";
            sql += "'" + professor.getIdentificacaoCPF() + "', ";
            sql += "'" + professor.getEmail() + "', ";
            sql += "'" + professor.getTitulo() + "'";
            sql += ");";

            con.createStatement().execute(sql);
            System.out.println("Dados do professor salvos com sucesso");
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void editar(Professor professor) {
        try {
            abreConexao();
            String sql = "UPDATE professor SET nome = ?, salario = ?, cpf = ?, email = ?, titulo = ? WHERE cpf = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, professor.getNome());
            pstm.setDouble(2, professor.getSalario());
            pstm.setString(3, professor.getIdentificacaoCPF());
            pstm.setString(4, professor.getEmail());
            pstm.setString(5, professor.getTitulo());

            pstm.execute();

            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(String cpf) {
        try {
            abreConexao();
            String sql = "DELETE FROM professor WHERE cpf = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.execute();

            fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Professor getById(String cpf) {
        Professor professor = null;
        try {
            abreConexao();
            String sql = "SELECT * FROM professor WHERE cpf = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                professor = new Professor();
                professor.setNome(rs.getString("nome"));
                professor.setIdentificacaoCPF(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setTitulo(rs.getString("titulo"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }

    @Override
    public List<Professor> listar() {
        List<Professor> professores = new ArrayList<Professor>();
        try {
            abreConexao();
            String sql = "SELECT * FROM professor;";

            ResultSet rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                Professor professor = new Professor();
                professor.setNome(rs.getString("nome"));
                professor.setIdentificacaoCPF(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setTitulo(rs.getString("titulo"));
                professores.add(professor);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return professores;
    }
}
