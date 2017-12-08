package br.ufc.servidor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ufc.model.Mensagem;

public class ServiodorDespachante {

	public String invoke(Mensagem msg) {
		Class<?> objRef = null;
		Method method = null;
		String resposta = null;
		try {
			objRef = Class.forName("br.ufc.servidor."
					+ msg.getObjReference());
			String methodName = msg.getMetodo();
			System.out.println("Executando: " + methodName);
			method = objRef.getMethod(methodName, String.class);
			resposta = (String) (method.invoke(objRef.newInstance(),
					msg.getArgumentos()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		return resposta;
		/*
		ServicoBolao bolao = new ServicoBolao();
		Rodada rodada = bolao.jogosDaRodada();
		
		Mensagem mensagem = new Mensagem();
		mensagem.setArgumentos(rodada);
		mensagem.setRequest(1);
		
		Gson gson = new Gson();
		String str = gson.toJson(mensagem);
		return str;
		*/
	}
}
