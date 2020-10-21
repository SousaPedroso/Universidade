package br.ufmt.ic.alg3.universidade.persistencia;

import br.ufmt.ic.alg3.universidade.entidades.Projeto;
import java.util.List;

public interface ProjetoDAO {

    public void inserir(Projeto projeto);

    public void editar (Projeto projeto);

    public boolean remover(int id);

    public Projeto getById (int id);

    public List<Projeto> listar();

}
