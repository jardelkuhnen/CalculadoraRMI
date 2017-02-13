package br.univel.cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.comum.OperacaoRMI;

public class Cliente {

	public static void main(String[] args) {

		Registry registry;

		System.out.println("Conectando ao servidor");

		try {
			registry = LocateRegistry.getRegistry("192.168.101.24", 2020);
			OperacaoRMI operacao = (OperacaoRMI) registry.lookup(OperacaoRMI.NOME);

			Integer soma = operacao.soma(1, 3);
			Integer multpipli = operacao.multipli(2, 5);
			Integer subtracao = operacao.subtracao(4, 2);
			Double divisao = operacao.divisao(10, 2);

			System.out.println("Retorno Soma:....................." + soma);
			System.out.println("Retorno Multiplicação:............" + multpipli);
			System.out.println("Retorno Subtração:................" + subtracao);
			System.out.println("Retorno Divisão:.................." + divisao.intValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
