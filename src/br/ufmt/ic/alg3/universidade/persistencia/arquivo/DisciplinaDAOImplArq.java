package br.ufmt.ic.alg3.universidade.persistencia.arquivo;

import br.ufmt.ic.alg3.universidade.entidades.Disciplina;
import br.ufmt.ic.alg3.universidade.persistencia.DisciplinaDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAOImplArq implements DisciplinaDAO {
    private final String filename = "disciplina.dat";
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(disciplinas);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            disciplinas = (List<Disciplina>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void inserir(Disciplina disciplina) {
        loadArquivo();
        boolean existe = false;

        for (Disciplina d : disciplinas) {
            if(d.getIdentificacao() == disciplina.getIdentificacao()){
                existe = true;
                break;
            }
        }
        if(existe == false){
            disciplinas.add(disciplina);
            salvarArquivo();
            System.out.println("Disciplina cadastrado com Sucesso!");
        }if(existe == true){
            System.out.println("Disciplina já cadastrada!");
        }
    }


    public void editar(Disciplina disciplina) {
        loadArquivo();
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina c = disciplinas.get(i);
            if(c.getIdentificacao() == disciplina.getIdentificacao()){
                disciplinas.set(i, disciplina);
                System.out.println("A disciplina foi editada");
                salvarArquivo();
                break;
            }
        }
    }


    public boolean remover(int identificacao) {
        loadArquivo();

        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina c = disciplinas.get(i);
            if(c.getIdentificacao() == identificacao){
                disciplinas.remove(i);
                System.out.println("A disciplina foi removida");

                salvarArquivo();
                return true;
            }
        }
        System.out.println("A disciplina nao foi encontrada para ser removida");
        return false;
    }


    public Disciplina getIdentificacao(int id) {
        loadArquivo();
        for (Disciplina c : disciplinas) {
            if(c.getIdentificacao() == id){
                return c;
            }
        }

        return null;
    }

    @Override
    public List<Disciplina> listar() {
        loadArquivo();
        return disciplinas;
    }


    public Disciplina getById(int identificacao) {
        // TODO Auto-generated method stub
        return null;
    }

}