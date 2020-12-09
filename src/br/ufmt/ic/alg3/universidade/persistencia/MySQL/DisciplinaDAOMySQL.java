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

import br.ufmt.ic.alg3.universidade.entidades.Disciplina;
import br.ufmt.ic.alg3.universidade.persistencia.DisciplinaDAO;


/**
 *
 * @author George
 */
public class DisciplinaDAOMySQL implements DisciplinaDAO {


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
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Disciplina disciplina) {

        try {
            abreConexao();

            String sql = "INSERT INTO disciplina (nome) VALUES (";
            sql += "'" + disciplina.getNome() + "'";
            sql += ");";

            con.createStatement().execute(sql);
            System.out.println("Salvo com Sucesso!");
            System.out.println(sql);
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Disciplina disciplina) {

        try {
            abreConexao();
            String sql = "UPDATE disciplina SET nome = ? WHERE identificação = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, disciplina.getNome());
            pstm.setInt(2, disciplina.getIdentificacao());

            pstm.execute();

            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int identificacao) {
        try {
            abreConexao();
            String sql = "DELETE FROM disciplina WHERE identificação = " + identificacao;
            con.createStatement().executeUpdate(sql);
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Disciplina getIdentificacao(int identificacao) {
        Disciplina d = null;
        try {
            abreConexao();
            String sql = "SELECT * FROM disciplina WHERE identificação = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, identificacao);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                d = new Disciplina();
                d.setNome(rs.getString("nome"));
                d.setIdentificacao(rs.getInt("identificação"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public List<Disciplina> listar() {
        List<Disciplina> lista = new ArrayList<Disciplina>();
        try {
            abreConexao();
            String sql = "SELECT * FROM disciplina;";

            ResultSet rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                Disciplina d = new Disciplina();
                d.setNome(rs.getString("nome"));
                d.setIdentificacao(rs.getInt("identificação"));
                lista.add(d);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}

