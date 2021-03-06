package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosDevolucao;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class ValidadeUsuarioPadrao {

    public static void process(Set<DadosUsuario> usuarios, Set<DadosDevolucao> devolucoes, LocalDate dataParaSerConsideradaNaExpiracao, Set<EmprestimoConcedido> empreestimosConcedidos, DadosEmprestimo dadosEmprestimo, DadosExemplar dadosExemplar) {
        if (dadosEmprestimo.tempo <= 60 && dadosEmprestimo.tipoExemplar == TipoExemplar.LIVRE && usuarios.stream().anyMatch(dadosUsuario -> dadosUsuario.idUsuario == dadosEmprestimo.idUsuario && dadosUsuario.padrao == TipoUsuario.PADRAO)) {
            empreestimosConcedidos.add(new EmprestimoConcedido(dadosEmprestimo.idUsuario, dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao.minusDays(1)));
        }
    }
}
