package br.ufmt.ic.alg3.universidade.persistencia.arquivo;

import br.ufmt.ic.alg3.universidade.entidades.Departamento;
import br.ufmt.ic.alg3.universidade.persistencia.DepartamentoDAO;

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

public class DepartamentoDAOImplArq implements DepartamentoDAO {
    private final String filename = "departamento.dat";
    private List<Departamento> departamentos = new ArrayList<Departamento>();

    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(departamentos);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DepartamentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lerArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            departamentos = (List<Departamento>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DepartamentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DepartamentoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inserir(Departamento departamento) {
        lerArquivo();
        boolean existe = false;

        int ident = departamento.getIdentificacao();
        for (Departamento d : departamentos) {
            if(d.getIdentificacao() == ident) {
                existe = true;
                break;
            }
        }
        if(existe == false){
            departamentos.add(departamento);
            salvarArquivo();
            System.out.println("O Departamento foi cadastrado.");
        }else{
            System.out.println("Departamento já cadastrado.");
        }

    }

    @Override
    public void editar(Departamento departamento) {
        lerArquivo();

        for (int i = 0; i < departamentos.size(); i++) {
            Departamento d = departamentos.get(i);
            if(departamento.getIdentificacao() == d.getIdentificacao()){
                departamentos.set(i, departamento);
                salvarArquivo();
                System.out.println("O departamento foi editado");
                break;
            }
        }
    }

    @Override
    public Departamento getIdentificacao(int identificacao) {
        lerArquivo();
        for (int i = 0;i< departamentos.size(); i++){
            Departamento d = departamentos.get(i);

            if(d.getIdentificacao() == identificacao){
                return d;
            }
        }
        return null;

    }

    @Override
    public boolean remover(int identificacao) {
        lerArquivo();
        for (int i = 0; i < departamentos.size(); i++) {
            Departamento d = departamentos.get(i);
            if(d.getIdentificacao() == identificacao){
                departamentos.remove(i);
                salvarArquivo();
                System.out.println("O departamento foi removido");
                return true;
            }
        }
        System.out.println("O departamento nao foi encontrado para ser removido");
        return false;
    }


    @Override
    public List<Departamento> listar() {
        lerArquivo();
        return departamentos;
    }


}