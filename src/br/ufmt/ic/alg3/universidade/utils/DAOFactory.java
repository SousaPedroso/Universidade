package br.ufmt.ic.alg3.universidade.utils;


import br.ufmt.ic.alg3.universidade.persistencia.*;
import br.ufmt.ic.alg3.universidade.persistencia.MySQL.*;

public class DAOFactory {

    public static AlunoDAO createAlunoDAO(){
        return new AlunoDAOMySQL();
    }

    public static CursoDAO createCursoDAO() {
        return new CursoDAOMySQL();
    }

    public static DepartamentoDAO createDepartamentoDAO() {
        return new DepartamentoDAOMySQL();
    }

    public static DisciplinaDAO createDisciplinaDAO(){
        return new DisciplinaDAOMySQL();
    }
    public static ProfessorDAO createProfessorDAO(){
        return new ProfessorDAOMySQL();
    }
    public static ProjetoDAO createProjetoDAO(){
        return new ProjetoDAOMySQL();
    }

}