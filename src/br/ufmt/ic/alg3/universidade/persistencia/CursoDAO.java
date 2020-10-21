package br.ufmt.ic.alg3.universidade.persistencia;
import br.ufmt.ic.alg3.universidade.entidades.Curso;
import java.util.List;

public interface CursoDAO {

    public void inserir(Curso curso);

    public void editar (Curso curso);

    public Curso getIdentificacao(int identificacao);

    public boolean remover(int identificacao);

    public List<Curso> listar();

}