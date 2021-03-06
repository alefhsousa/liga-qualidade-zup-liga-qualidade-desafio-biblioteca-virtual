package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ValidarUsuarioPesquisador {

    private BancoEmprestimos bancoEmprestimos;

    public ValidarUsuarioPesquisador(BancoEmprestimos bancoEmprestimos) {
        this.bancoEmprestimos = bancoEmprestimos;
    }

    public void process(Set<DadosUsuario> usuarios, LocalDate dataParaSerConsideradaNaExpiracao, DadosEmprestimo dadosEmprestimo, DadosExemplar dadosExemplar) {
        Set<EmprestimoConcedido> empreestimosConcedidos =  new HashSet<EmprestimoConcedido>();

        if (dadosEmprestimo.tempo <= 60 && usuarios.stream().anyMatch(dadosUsuario -> dadosUsuario.idUsuario == dadosEmprestimo.idUsuario && dadosUsuario.padrao == TipoUsuario.PESQUISADOR)) {
            bancoEmprestimos.adiciona(new EmprestimoConcedido(dadosEmprestimo.idUsuario, dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao.minusDays(1)));
        }
    }
}
