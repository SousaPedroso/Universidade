package br.ufmt.ic.alg3.universidade.persistencia;

import br.ufmt.ic.alg3.universidade.entidades.Departamento;
import java.util.List;

public interface DepartamentoDAO {

    public void inserir(Departamento departamento);

    public void editar(Departamento departamento);

    public  Departamento getIdentificacao(int identificacao);

    public boolean remover(int identificacao);

    public List<Departamento> listar();
}