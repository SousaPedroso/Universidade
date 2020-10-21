package br.ufmt.ic.alg3.universidade.persistencia;
import java.util.List;
import br.ufmt.ic.alg3.universidade.entidades.Curso;

public interface CursoDAO {

    public void inserir(Curso curso);

    public void editar (Curso curso);

    public Curso getId(int id);

    public boolean remover(int id);

    public List<Curso> listar();

}