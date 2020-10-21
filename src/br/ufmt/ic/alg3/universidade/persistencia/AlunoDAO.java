package br.ufmt.ic.alg3.universidade.persistencia;
import br.ufmt.ic.alg3.universidade.entidades.Aluno;
import java.util.List;

public interface AlunoDAO {

    public void inserir(Aluno aluno);

    public void editar(Aluno aluno);

    public boolean remover(String rga);

    public  Aluno getByRga(String rga);

    public List<Aluno> listar();
}