package br.ufmt.ic.alg3.universidade.persistencia.arquivo;

import br.ufmt.ic.alg3.universidade.entidades.Curso;
import br.ufmt.ic.alg3.universidade.persistencia.CursoDAO;

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

public class CursoDAOImplArq implements CursoDAO {
    private final String filename = "curso.dat";
    private List<Curso> cursos = new ArrayList<Curso>();

    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(cursos);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CursoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CursoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lerArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            cursos = (List<Curso>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CursoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CursoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //para adicionar um novo curso
    @Override
    public void inserir(Curso curso){
        lerArquivo();
        boolean existe = false;
        int ident = curso.getIdentificacao();
        for (Curso c: cursos){
            if (c.getIdentificacao() == ident){
                existe = true;
                break;
            }
        }
        if(existe == false){
            cursos.add(curso);
            salvarArquivo();
            System.out.println("Cadastro do curso efetuado");
        }else{
            System.out.println("Curso já foi cadastrado");
        }

    }

    @Override
    public void editar (Curso curso){
        lerArquivo();
        for (int i = 0; i < cursos.size(); i++) {
            Curso c = cursos.get(i);
            if(curso.getIdentificacao() == c.getIdentificacao()){
                cursos.set(i, curso);
                salvarArquivo();
                System.out.println("O curso foi editado");
                break;
            }
        }
    }

    @Override
    public boolean remover(int identificacao){
        lerArquivo();

        for (int i = 0; i < cursos.size(); i++) {
            Curso c = cursos.get(i);
            if(c.getIdentificacao() == identificacao){
                cursos.remove(i);
                salvarArquivo();
                System.out.println("O foi curso removido");
                return true;
            }
        }
        System.out.println("O curso não foi encontrado para ser removido");
        return false;
    }
    @Override
    public Curso getIdentificacao(int identificacao) {
        for(int i = 0; i < cursos.size(); i++){
            Curso c = cursos.get(i);
            if(c.getIdentificacao() == identificacao){
                return c;
            }
        }
        return null;
    }
    @Override
    public List<Curso> listar() {
        lerArquivo();
        return cursos;
    }

}
