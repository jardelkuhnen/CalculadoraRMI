package br.univel.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperacaoRMI extends Remote {

	public final static String NOME = "NomeOperacao";

	public Integer soma(int n1, int n2) throws RemoteException;

	public Integer subtracao(int n1, int n2) throws RemoteException;

	public Integer multipli(int n1, int n2) throws RemoteException;

	public Double divisao(int n1, int n2) throws RemoteException;

}
