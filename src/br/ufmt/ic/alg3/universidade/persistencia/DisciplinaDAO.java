package br.ufmt.ic.alg3.universidade.persistencia;

import br.ufmt.ic.alg3.universidade.entidades.Disciplina;
import java.util.List;


public interface DisciplinaDAO {

    public void inserir (Disciplina disciplina);

    public void editar (Disciplina disciplina);

    public boolean remover (int identificacao);

    public Disciplina getbyId (int identificacao);

    public List<Disciplina> listar();

}
