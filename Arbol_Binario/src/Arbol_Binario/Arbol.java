package Arbol_Binario;

public class Arbol {

	/* Atributos */
	private Nodo raiz;
	int altura, cantidad;

	/* Contructores */
	public Arbol(int valor) {
		this.raiz = new Nodo(valor);
	}

	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	/* Setters y Getters */
	public Nodo getRaiz() {
		return raiz;
	}

	public int peso() {
		cantidad = 0;
		peso(raiz);
		return cantidad;

	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	private void addNodo(Nodo nodo, Nodo raiz) {
		if (raiz == null) {
			this.setRaiz(nodo);
			raiz.setPadre(null);
		} else {
			if (nodo.getValor() < raiz.getValor()) {
				if (raiz.getHojaIzquierda() == null) {
					raiz.setHojaIzquierda(nodo);
					raiz.getHojaIzquierda().setPadre(raiz);//
				} else {
					addNodo(nodo, raiz.getHojaIzquierda());
				}
			} else {
				if (raiz.getHojaDerecha() == null) {
					raiz.setHojaDerecha(nodo);
					raiz.getHojaDerecha().setPadre(raiz);
				} else {
					addNodo(nodo, raiz.getHojaDerecha());
				}
			}
		}
	}

	public void addNodo(Nodo nodo) {
		this.addNodo(nodo, this.getRaiz());
	}

	private void recorridoInorden(Nodo nodo) {
		if (nodo.getHojaIzquierda() != null) {
			recorridoInorden(nodo.getHojaIzquierda());
		}
		System.out.print(nodo.getValor() + " ");

		if (nodo.getHojaDerecha() != null) {
			recorridoInorden(nodo.getHojaDerecha());
		}
	}

	public void inorden() {
		recorridoInorden(this.getRaiz());
	}

	private void recorridoPreorden(Nodo nodo) {
		System.out.print(nodo.getValor() + " ");
		if (nodo.getHojaIzquierda() != null) {
			recorridoPreorden(nodo.getHojaIzquierda());
		}

		if (nodo.getHojaDerecha() != null) {
			recorridoPreorden(nodo.getHojaDerecha());
		}
	}

	public void Preorden() {
		recorridoPreorden(this.getRaiz());
	}

	private void recorridoPostorden(Nodo nodo) {
		if (nodo.getHojaIzquierda() != null) {
			recorridoPostorden(nodo.getHojaIzquierda());
		}

		if (nodo.getHojaDerecha() != null) {
			recorridoPostorden(nodo.getHojaDerecha());
		}
		System.out.print(nodo.getValor() + " ");
	}

	private void peso(Nodo reco) {
		if (reco != null) {
			cantidad++;
			peso(reco.getHojaIzquierda());
			peso(reco.getHojaDerecha());
		}

	}

	public void Postorden() {
		recorridoPostorden(this.getRaiz());
	}

	public boolean buscar(int valor) {
		return buscarNodo(this.raiz, valor);
	}

	private boolean buscarNodo(Nodo reco, int valor) {
		if (reco != null) {
			if (valor == reco.getValor()) {
				return true; // encontrado
			}
			if (valor < reco.getValor()) {
				return buscarNodo(reco.getHojaIzquierda(), valor);
			} else {
				return buscarNodo(reco.getHojaDerecha(), valor);
			}
		}
		return false; // no encontrado
	}

	/*-------------ELIMINAR UN NODO----------------------------------*/
	public boolean removeNodo(Nodo nodo) {
		/* Creamos variables para saber si tiene hijos izquierdo y derecho */
		boolean tieneNodoDerecha = nodo.getHojaDerecha() != null ? true : false;
		boolean tieneNodoIzquierda = nodo.getHojaIzquierda() != null ? true : false;
		/* Verificamos los 3 casos diferentes y llamamos a la funcion correspondiente */
		/* Caso 1: No tiene hijos */
		if (!tieneNodoDerecha && !tieneNodoIzquierda) {
			return removeNodoCaso1(nodo);
		}
		/* Caso 2: Tiene un hijo a la derecha y el otro no */
		if (tieneNodoDerecha && !tieneNodoIzquierda) {
			return removeNodoCaso2(nodo);
		}
		/* Caso 2: Tiene un hijo a la izquierda y el otro no */
		if (!tieneNodoDerecha && tieneNodoIzquierda) {
			return removeNodoCaso2(nodo);
		}
		/* Caso 3: Tiene ambos hijos */
		if (tieneNodoDerecha && tieneNodoIzquierda) {
			return removeNodoCaso3(nodo);
		}
		return false;
	}

	private boolean removeNodoCaso1(Nodo nodo) {
		/*
		 * lo que hay que hacer es borrar el nodo y establecer el apuntador de su padre
		 * a nulo. Guardemos los hijos del padre temporalmente para saber cual de sus
		 * hijos hay que eliminar
		 */
		Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
		Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
		if (hijoIzquierdo == nodo) {
			nodo.getPadre().setHojaIzquierda(null);// Eliminar nodo izquierda.
			return true;
		}
		if (hijoDerecho == nodo) {
			nodo.getPadre().setHojaDerecha(null);
			return true;
		}
		return false;
	}

	private boolean removeNodoCaso2(Nodo nodo) {
		/*
		 * Borrar el Nodo y el subarbol que tenia pasa a ocupar su lugar. Guardemos los
		 * hijos del padre temporalmente para saber cual de sus hijos hay que eliminar
		 */
		Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
		Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
		/* Buscamos el hijo existente del nodo que queremos eliminar */
		Nodo hijoActual = nodo.getHojaIzquierda() != null ? nodo.getHojaIzquierda() : nodo.getHojaDerecha();
		if (hijoIzquierdo == nodo) {
			nodo.getPadre().setHojaIzquierda(hijoActual);
			/* Eliminando todas las referencias hacia el nodo */
			hijoActual.setPadre(nodo.getPadre());
			nodo.setHojaDerecha(null);
			nodo.setHojaIzquierda(null);
			return true;
		}
		if (hijoDerecho == nodo) {
			nodo.getPadre().setHojaDerecha(hijoActual);// Se elimina la relacion entre el padre y el hijo.
			/* Eliminando todas las referencias hacia el nodo */
			hijoActual.setPadre(nodo.getPadre());/**/
			nodo.setHojaDerecha(null);
			nodo.setHojaIzquierda(null);
			return true;
		}
		return false;
	}

	private boolean removeNodoCaso3(Nodo nodo) {
		/* Tomar el hijo derecho del Nodo que queremos eliminar */
		Nodo nodoMasALaIzquierda = recorrerIzquierda(nodo.getHojaDerecha());
		if (nodoMasALaIzquierda != null) {
			/*
			 * Reemplazamos el valor del nodo que queremos eliminar por el nodo que
			 * encontramos
			 */
			nodo.setValor(nodoMasALaIzquierda.getValor());
			/* Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) */
			removeNodo(nodoMasALaIzquierda);
			return true;
		}
		return false;
	}

	/* Recorrer de forma recursiva hasta encontrar el nodo mas a la izquierda */
	private Nodo recorrerIzquierda(Nodo nodo) {
		if (nodo.getHojaIzquierda() != null) {
			return recorrerIzquierda(nodo.getHojaIzquierda());
		}
		return nodo;
	}

	/* Buscar un nodo por su valor y eliminarlo */
	public boolean removedValor(int valor, Nodo raiz) {
		// Se busca el nodo dentro del árbol que tenga el valor indicado
		Nodo nodoEncontrado = buscarNodoo(raiz, valor);

		// Si el nodo existe (no es null), se procede a eliminarlo
		if (nodoEncontrado != null) {
			return removeNodo(nodoEncontrado);
			// Aquí se llama a otra función (removeNodo) que se encarga de la eliminación
		}

		return false;
	}

	/* Función recursiva para recorrer el árbol y buscar el nodo */
	private Nodo buscarNodoo(Nodo nodo, int valor) {
		// Caso base: si el nodo actual es null, significa que llegamos al final de una
		if (nodo == null) {
			return null;
		}

		// Si el valor del nodo actual coincide con el valor buscado, se devuelve este
		if (nodo.getValor() == valor) {
			return nodo;
		}

		// Se busca recursivamente en la rama izquierda
		Nodo encontradoIzq = buscarNodoo(nodo.getHojaIzquierda(), valor);

		// Si se encontró en la izquierda, se devuelve directamente
		if (encontradoIzq != null) {
			return encontradoIzq;
		}

		// Si no se encontró en la izquierda, se busca en la rama derecha
		return buscarNodoo(nodo.getHojaDerecha(), valor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arbol arbolito = new Arbol(12);

		Nodo n = new Nodo(12);
		Nodo n1 = new Nodo(8);
		Nodo n2 = new Nodo(7);
		Nodo n3 = new Nodo(16);
		Nodo n4 = new Nodo(14);

		Arbol arboletos = new Arbol(n);
		arboletos.addNodo(n1);
		arboletos.addNodo(n2);
		arboletos.addNodo(n3);
		arboletos.addNodo(n4);

		Nodo raiz = arboletos.getRaiz();
		boolean eliminado = arboletos.removedValor(16, raiz);

		if (eliminado) {
			System.out.println("Nodo 16 ELIMINADO");
		} else {
			System.out.println("No se encontró el nodo con valor 16.");
		}

		// System.out.println("Se encuentra el 16: " + arboletos.buscar(20));

		// CREAR FUNCION QUE IMPRIMA EL ARBOL de forma INORDEN
		/*
		 * System.out.println("INORDEN: "); arboletos.inorden();
		 * System.out.println("\nPREORDEN: "); arboletos.Preorden();
		 * System.out.println("\nPOSTORDEN: "); arboletos.Postorden();
		 */
	}
}
