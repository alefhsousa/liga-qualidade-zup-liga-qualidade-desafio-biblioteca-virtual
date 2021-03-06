package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;

import java.util.HashSet;

public class BancoEmprestimos {

    private HashSet<EmprestimoConcedido> emprestimoConcedidos = new HashSet<>();


    public void adiciona(EmprestimoConcedido emprestimoConcedido) {
        emprestimoConcedidos.add(emprestimoConcedido);
    }

    public HashSet<EmprestimoConcedido> getEmprestimoConcedidos() {
        return emprestimoConcedidos;
    }
}
