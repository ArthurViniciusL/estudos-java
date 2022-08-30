package si.arthur.p3.questoes;

import arthur.p3.exceptions.ValorInvalidoException;

public class MyRow {
	private int alocInicial;

	public MyRow(int inicial) {
		this.alocInicial = inicial;
	}
	
	private Object[] arrayInterno = new Object[alocInicial];
	private int inseridos;
	
	private int comprimento = Math.round( (alocInicial*60)/100 );
	
	public void enqueue(Object elemento) throws  ValorInvalidoException {
		
		if (elemento == null) {
			throw new ValorInvalidoException("Valor inválido");
		}
		
		else if (inseridos == arrayInterno.length) {
			
			Object[] novoArray = new Object[comprimento];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				novoArray[i] = arrayInterno[i];
			}
			
			arrayInterno = novoArray;
		}
		
		arrayInterno[inseridos] = elemento;
		inseridos++;
	}
	
	public Object dequeue() {
		
		Object valor = arrayInterno[0];
		
		for (int i = 0; i < arrayInterno.length -1; i++) {
			arrayInterno[i -1] = arrayInterno[i];
		}
		
		return valor;
	}
	
	public int size() {
		return inseridos;
	}
	
	public void clear() {
		arrayInterno = new Object[alocInicial];
		inseridos = 0;
	}
}
