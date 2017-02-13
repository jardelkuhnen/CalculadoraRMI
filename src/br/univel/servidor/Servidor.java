package br.univel.servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.comum.OperacaoRMI;

public class Servidor implements OperacaoRMI {

	public static void main(String[] args) {

		OperacaoRMI operacao;
		Servidor servidor = new Servidor();

		try {

			operacao = (OperacaoRMI) UnicastRemoteObject.exportObject(servidor, 0);

			Registry registry = LocateRegistry.createRegistry(2020);
			registry.rebind(OperacaoRMI.NOME, operacao);

			System.out.println("Serviço iniciado");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Integer soma(int n1, int n2) throws RemoteException {

		return n1 + n2;
	}

	@Override
	public Integer subtracao(int n1, int n2) throws RemoteException {
		return n1 - n2;
	}

	@Override
	public Integer multipli(int n1, int n2) throws RemoteException {
		return n1 * n2;
	}

	@Override
	public Double divisao(int n1, int n2) throws RemoteException {
		return (double) (n1 / n2);
	}

}
