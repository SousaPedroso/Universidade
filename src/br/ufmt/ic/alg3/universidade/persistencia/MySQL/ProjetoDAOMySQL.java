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

import br.ufmt.ic.alg3.universidade.entidades.Projeto;
import br.ufmt.ic.alg3.universidade.persistencia.ProjetoDAO;


/**
 *
 * @author gsous
 */
public class ProjetoDAOMySQL implements ProjetoDAO {

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
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Projeto projeto) {
        try{
            abreConexao();

            String sql = "INSERT INTO projeto (nome, id) VALUES (";
            sql += "'" + projeto.getNome() + "', ";
            sql += "'" + projeto.getId() + "'";
            sql += ");";

            con.createStatement().execute(sql);
            System.out.println("Dados do projeto salvos com sucesso");
            System.out.println(sql);
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Projeto projeto) {
        try {
            abreConexao();
            String sql = "UPDATE projeto SET nome = ?, id = ? WHERE id = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, projeto.getNome());
            pstm.setInt(2, projeto.getId());


            pstm.execute();

            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            abreConexao();
            String sql = "DELETE FROM projeto WHERE id = " + id;
            con.createStatement().executeUpdate(sql);
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Projeto getById(int id) {
        Projeto projeto = null;
        try {
            abreConexao();
            String sql = "SELECT * FROM projeto WHERE id = ?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                projeto = new Projeto();
                projeto.setNome(rs.getString("nome"));
                projeto.setId(rs.getInt("id"));
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projeto;
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetos = new ArrayList<Projeto>();
        try {
            abreConexao();
            String sql = "SELECT * FROM projeto;";

            ResultSet rs = con.createStatement().executeQuery(sql);

            while(rs.next()){
                Projeto projeto = new Projeto();
                projeto.setNome(rs.getString("nome"));
                projeto.setId(rs.getInt("id"));
                projetos.add(projeto);
            }
            rs.close();
            fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projetos;
    }

}

