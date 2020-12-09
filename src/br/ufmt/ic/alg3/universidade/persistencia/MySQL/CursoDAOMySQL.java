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

import br.ufmt.ic.alg3.universidade.entidades.Curso;
import br.ufmt.ic.alg3.universidade.persistencia.CursoDAO;

/**
 *
 * @author jean
 */
public class CursoDAOMySQL implements CursoDAO {

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
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void inserir(Curso curso) {
        try {
            abreConexao();

            String sql = "INSERT INTO curso (nome) VALUES (";
            sql += "'" + curso.getNome() + "'";
            sql += ");";

            con.createStatement().execute(sql);
            System.out.println("Salvo com Sucesso!");
            System.out.println(sql);
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Curso curso) {
        try {
            abreConexao();
            String sql = "UPDATE curso SET nome = ? WHERE identificacao = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, curso.getNome());
            pstm.setInt(2, curso.getIdentificacao());

            pstm.execute();

            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public Curso getIdentificacao(int identificacao) {
        Curso c = null;
        try {
            abreConexao();
            String sql = "SELECT * FROM curso WHERE identificacao = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, identificacao);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                c = new Curso();
                c.setNome(rs.getString("nome"));
                c.setIdentificacao(rs.getInt("identificacao"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;    }

    @Override
    public boolean remover(int identificacao) {
        try {
            abreConexao();
            String sql = "DELETE FROM curso WHERE identificacao = " + identificacao;
            con.createStatement().executeUpdate(sql);
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    }

    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<Curso>();
        try {
            abreConexao();
            String sql = "SELECT * FROM curso;";

            ResultSet rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                Curso c = new Curso();
                c.setNome(rs.getString("nome"));
                c.setIdentificacao(rs.getInt("identificacao"));
                lista.add(c);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
