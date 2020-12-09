package br.ufmt.ic.alg3.universidade.persistencia.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufmt.ic.alg3.universidade.entidades.Aluno;
import br.ufmt.ic.alg3.universidade.persistencia.AlunoDAO;


/**
 *
 * @author jean
 */
public class AlunoDAOMySQL implements AlunoDAO {

    private Connection con;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/universidadeTeste?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";


    private void abreConexao() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Aluno aluno) {
        try {
            abreConexao();

            String sql = "INSERT INTO aluno (nome, rga, email, cpf)  VALUES (";
            sql += "'" + aluno.getNome() + "', ";
            sql += "'" + aluno.getRga()+ "', ";
            sql += "'" + aluno.getEmail() + "', ";
            sql += "'" + aluno.getCpf() + "'";
            sql += ");";

            con.createStatement().execute(sql);
            System.out.println("Salvo com Sucesso!");
            System.out.println(sql);
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Aluno aluno) {
        try {
            abreConexao();
            String sql = "UPDATE aluno SET nome = ?, email = ?, cpf = ? WHERE rga = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, aluno.getNome());
            pstm.setString(4, aluno.getRga());
            pstm.setString(2, aluno.getEmail());
            pstm.setString(3, aluno.getCpf());


            pstm.execute();

            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(String rga) {
        try {
            abreConexao();

            String sql = "DELETE FROM aluno WHERE rga = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, rga);

            pstm.execute();
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Aluno getByRga(String rga) {
        Aluno a = null;
        try {
            abreConexao();
            String sql = "SELECT * FROM aluno WHERE rga = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, rga);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                a = new Aluno();
                a.setNome(rs.getString("nome"));
                a.setRga(rs.getString("rga"));
                a.setEmail(rs.getString("email"));
                a.setCpf(rs.getString("cpf"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public List<Aluno> listar() {
        List<Aluno> lista = new ArrayList<Aluno>();
        try {
            abreConexao();
            String sql = "SELECT * FROM aluno;";

            ResultSet rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                Aluno a = new Aluno();
                a.setNome(rs.getString("nome"));
                a.setRga(rs.getString("rga"));
                a.setEmail(rs.getString("email"));
                a.setCpf(rs.getString("cpf"));
                lista.add(a);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
