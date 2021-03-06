package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique;

import br.com.zup.edu.ligaqualidade.desafiobiblioteca.DadosEmprestimo;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.EmprestimoConcedido;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.DadosUsuario;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoExemplar;
import br.com.zup.edu.ligaqualidade.desafiobiblioteca.pronto.TipoUsuario;

import java.time.LocalDate;
import java.util.Set;

public class ValidadeUsuarioPadrao {

    private BancoEmprestimos bancoEmprestimos;

    public ValidadeUsuarioPadrao(BancoEmprestimos bancoEmprestimos) {
        this.bancoEmprestimos = bancoEmprestimos;
    }

    public void process(Set<DadosUsuario> usuarios, LocalDate dataParaSerConsideradaNaExpiracao,
                        DadosEmprestimo dadosEmprestimo,
                        DadosExemplar dadosExemplar) {

        boolean usuarioTemPedidoExpirado = bancoEmprestimos.getEmprestimoConcedidos()
                .stream()
                .filter(emprestimoConcedido -> emprestimoConcedido.idUsuario == dadosEmprestimo.idUsuario)
                .anyMatch(emprestimoConcedido -> dataParaSerConsideradaNaExpiracao.isAfter(emprestimoConcedido.dataPrevistaDevolucao));

        if (dadosEmprestimo.tempo <= 60 &&
                dadosEmprestimo.tipoExemplar == TipoExemplar.LIVRE &&
                usuarios.stream().anyMatch(dadosUsuario -> dadosUsuario.idUsuario == dadosEmprestimo.idUsuario && dadosUsuario.padrao == TipoUsuario.PADRAO) &&
                !usuarioTemPedidoExpirado
        ) {
            bancoEmprestimos.adiciona(new EmprestimoConcedido(dadosEmprestimo.idUsuario, dadosExemplar.idExemplar, dataParaSerConsideradaNaExpiracao.minusDays(1)));
        }
    }
}
