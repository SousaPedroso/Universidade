package br.ufmt.ic.alg3.universidade.persistencia.arquivo;

import br.ufmt.ic.alg3.universidade.entidades.Aluno;
import br.ufmt.ic.alg3.universidade.persistencia.AlunoDAO;
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


public class AlunoDAOImplArq implements AlunoDAO {
    private final String filename = "aluno.dat";
    private List<Aluno> alunos = new ArrayList<Aluno>();

    private void salvarArquivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(alunos);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlunoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlunoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadArquivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            alunos = (List<Aluno>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlunoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlunoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void inserir(Aluno aluno) {
        loadArquivo();
        boolean existe = false;

        for (Aluno a : alunos) {
            if (a.getRga().equals(aluno.getRga())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            alunos.add(aluno);
            salvarArquivo();
            System.out.println("Cadastro efetuado com Sucesso!");
        } else {
            System.out.println("Aluno já cadastrado!");
        }


    }

    @Override
    public void editar(Aluno aluno) {
        loadArquivo();
        for (int i = 0; i < alunos.size(); i++) {
            Aluno c = alunos.get(i);
            if (c.getRga().equals(aluno.getRga())) {
                alunos.set(i, aluno);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean remover(String rga) {
        loadArquivo();
        for (int indice = 0; indice < alunos.size(); indice++) {
            Aluno aluno = alunos.get(indice);
            if (aluno.getRga().equals(rga)) {
                alunos.remove(indice);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Aluno getByRga(String rga) {
        loadArquivo();
        for (Aluno aluno : alunos) {
            if (aluno.getRga().equals(rga)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> listar() {
        loadArquivo();
        return alunos;
    }
}
