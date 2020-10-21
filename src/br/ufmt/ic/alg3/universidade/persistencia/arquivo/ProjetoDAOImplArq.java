package br.ufmt.ic.alg3.universidade.persistencia.arquivo;

import br.ufmt.ic.alg3.universidade.entidades.Projeto;
import br.ufmt.ic.alg3.universidade.persistencia.ProjetoDAO;

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

public class ProjetoDAOImplArq implements ProjetoDAO {
	
	  private final String filename = "projeto.dat";
	  private List<Projeto> projetos = new ArrayList<Projeto>();
	    
	    private void salvarArquivo(){
	        try {
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
	            oos.writeObject(projetos);
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
	            projetos = (List<Projeto>) ois.readObject();
	            ois.close();
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    @Override
	    public void inserir(Projeto projeto) {
	        loadArquivo();
	        boolean existe = false;
	        
	        for (Projeto d : projetos) {
	            if(d.getId() == projeto.getId()){
	                existe = true;
	                break;
	            }
	        }
	        if(existe == false){
	        	projetos.add(projeto);
	            salvarArquivo();
	            System.out.println("Projeto cadastrado com Sucesso!");
	        }if(existe == true){
	            System.out.println("Projeto já cadastrado!");
	        }
	    }
	    
	    @Override
	    public void editar(Projeto projeto) {
	        loadArquivo();
	        for (int i = 0; i < projetos.size(); i++) {
	        	Projeto c = projetos.get(i);
	            if(c.getId() == projeto.getId()){
	            	projetos.set(i, projeto);
	                salvarArquivo();
	                System.out.println("Projeto editado com sucesso.");
	                break;
	            }
	        }
	    }

	    @Override
	    public boolean remover(int identificacao) {
	        loadArquivo();

	        for (int i = 0; i < projetos.size(); i++) {
	        	Projeto c = projetos.get(i);
	            if(c.getId() == identificacao){
	            	projetos.remove(i);
	                salvarArquivo();
					System.out.println("O Projeto foi removido");
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public Projeto getById(int id) {
	        loadArquivo();
	        for (Projeto c : projetos) {
	            if(c.getId() == id){
	                return c;
	            }
	        }
	        
	        return null;
	    }

	    @Override
	    public List<Projeto> listar() {
	        loadArquivo();
	        return projetos;
	    }


}
