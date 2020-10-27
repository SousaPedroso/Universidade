package br.ufmt.ic.alg3.universidade.utils;

import br.ufmt.ic.alg3.universidade.persistencia.*;
import br.ufmt.ic.alg3.universidade.persistencia.arquivo.*;

public class DAOFactory {
    public static AlunoDAO createAlunoDAO(){
        return new AlunoDAOImplArq();
    }

    public static CursoDAO createCursoDAO() {
        return new CursoDAOImplArq();
    }

    public static DepartamentoDAO createDepartamentoDAO() {
        return new DepartamentoDAOImplArq();
    }

    public static DisciplinaDAO createDisciplinaDAO(){
        return new DisciplinaDAOImplArq();
    }

    public static ProfessorDAO createProfessorDAO(){
        return new ProfessorDAOImplArq();
    }

     public static ProjetoDAO createPreojetoDAO(){
        return new ProjetoDAOImplArq();
     }
}
