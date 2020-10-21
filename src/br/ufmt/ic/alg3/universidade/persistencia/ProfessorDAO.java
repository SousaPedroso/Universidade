package br.ufmt.ic.alg3.universidade.persistencia;

import br.ufmt.ic.alg3.universidade.entidades.Professor;
import java.util.List;

public interface ProfessorDAO {

    public void inserir(Professor professor);

    public void editar (Professor professor);

    public boolean remover(String cpf);

    public Professor getById (String cpf);

    public List<Professor> listar();


}
