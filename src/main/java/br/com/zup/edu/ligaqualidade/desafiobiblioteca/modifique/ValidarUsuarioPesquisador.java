package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.time.LocalDate;
import java.util.Set;

public class ValidarUsuarioPesquisador {

    public  static void process(Set<DadosUsuario> usuarios, LocalDate dataParaSerConsideradaNaExpiracao, Set<EmprestimoConcedido> empreestimosConcedidos, DadosEmprestimo dadosEmprestimo, DadosExemplar dadosExemplar) {
        if (dadosEmprestimo.tempo <= 60 && usuarios.stream().anyMatch(dadosUsuario -> dadosUsuario.idUsuario == dadosEmprestimo.idUsuario && dadosUsuario.padrao == TipoUsuario.PESQUISADOR)) {
            empreestimosConcedidos.add(new EmprestimoConcedido(dadosEmprestimo.idUsuario, dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao.minusDays(1)));
        }
    }
}
