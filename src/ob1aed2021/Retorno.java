package ob1aed2021;

public class Retorno {
	enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
        boolean valorbooleano;
	Resultado resultado;
        NodoCiudad unNodoCiudad;
        NodoVuelo unNodoVuelo;
        NodoServicio unNodoServicio;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
