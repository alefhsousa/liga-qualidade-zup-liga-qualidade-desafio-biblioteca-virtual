package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class ValidadeUsuarioPadrao {

    public static Set<EmprestimoConcedido> process(Set<DadosUsuario> usuarios, LocalDate dataParaSerConsideradaNaExpiracao, DadosEmprestimo dadosEmprestimo, DadosExemplar dadosExemplar) {

        Set<EmprestimoConcedido> empreestimosConcedidos =  new HashSet<EmprestimoConcedido>();

        if (dadosEmprestimo.tempo <= 60 && dadosEmprestimo.tipoExemplar == TipoExemplar.LIVRE && usuarios.stream().anyMatch(dadosUsuario -> dadosUsuario.idUsuario == dadosEmprestimo.idUsuario && dadosUsuario.padrao == TipoUsuario.PADRAO)) {
            empreestimosConcedidos.add(new EmprestimoConcedido(dadosEmprestimo.idUsuario, dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao.minusDays(1)));
        }

        return empreestimosConcedidos;
    }
}
