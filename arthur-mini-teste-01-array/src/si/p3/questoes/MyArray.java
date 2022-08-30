package si.arthur.p3.questoes;

import arthur.p3.exceptions.PosicaoInvalidaException;
import arthur.p3.exceptions.ValorInvalidoException;

public class MyArray {
	private int alocInicial;

	public MyArray(int inicial) {
		this.alocInicial = inicial;
	}
	
	private Object[] arrayInterno = new Object[alocInicial];
	private int inseridos;
	
	private int comprimento = Math.round( (alocInicial*60)/100 );
	
	public void add(Object elemento) throws  ValorInvalidoException {
		
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
	
	public void add(int index, Object elemento) throws PosicaoInvalidaException {
		
		if (index < 0 && index > arrayInterno.length) {
			throw new PosicaoInvalidaException("Index inválido");
		}
		
		else if (inseridos == arrayInterno.length) {
			Object[] novoArray = new Object[comprimento];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				novoArray[i] = arrayInterno[i];
			}
			
			arrayInterno = novoArray;
		}
		
		arrayInterno[index] = elemento;
		inseridos++;
	}
	
	public Object get(int index) {
		return arrayInterno[index];
	}
	
	public int size() {
		return inseridos;
	}
	
	public void clear() {
		arrayInterno = new Object[alocInicial];
		inseridos = 0;
	}
}