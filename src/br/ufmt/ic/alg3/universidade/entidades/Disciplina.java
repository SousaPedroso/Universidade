/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmt.ic.alg3.universidade.entidades;


import java.util.List;

public class Disciplina {
    private String nome;
    private int identificacao;
    private List<Disciplina> preRequisito;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public List<Disciplina> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(List<Disciplina> preRequisito) {
        this.preRequisito = preRequisito;
    }
}
