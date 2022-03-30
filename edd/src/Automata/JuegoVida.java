package edd.src.Automata;
import java.util.Random;
public class JuegoVida extends AC {

	int[][] Maux2=new int[Imagen.numCells][Imagen.numCells];
	int[][] MauxCopia=new int [Imagen.numCells][Imagen.numCells];

	/**
	*Metodo que regresa la matriz con cada evolucion.
	*
	*/
    public int[][] getAutomata2() {
 		return Maux2;
    }

   	/*
   	*Metodo que pinta una matriz de Blanco y le da valores aleatorios a las casillas.
   	*
   	*/
	 @Override
    public int[][] getAutomata() {
    	for (int i=0;i<Maux2.length ;i++ ) {
    		for (int j=0;j<Maux2.length ;j++ ) {
    		Maux2[i][j]=0;
    		}
    	}



		// //Modifico cada valor de la matriz Maux de forma aleatoria.
		// 	for (int i=0;i<Maux2.length;i++) {
		// 		for (int j=0;j<Maux2.length;j++) {
		// 			Maux2[i][j] = (int) ( Math.random() * 2 + 1);
		// 		}
		// 	}

		//nave 1 izquierda arriba
		for(int i=0; 26-i>=0;i+=7){
			for(int j=0; 30-j>=0; j+=7){
				Maux2[27-i][32-j]=1;
				Maux2[26-i][31-j]=1;
				Maux2[26-i][30-j]=1;
				Maux2[27-i][30-j]=1;
				Maux2[28-i][30-j]=1;
			}
		}

		//nave 1 derecha arriba
		for(int i=0; 54+i<=79; i+=7){
			for(int j=0; 30-j>=0; j+=7){
				Maux2[53+i][32-j]=1;
				Maux2[54+i][31-j]=1;
				Maux2[52+i][30-j]=1;
				Maux2[53+i][30-j]=1;
				Maux2[54+i][30-j]=1;
			}
		}

		//nave 1 izquierda abajo

		for(int i=0; 26-i>=0;i+=7){
			for(int j=0; 48+j<=79; j+=7){
				Maux2[27-i][46+j]=1;
				Maux2[26-i][47+j]=1;
				Maux2[26-i][48+j]=1;
				Maux2[27-i][48+j]=1;
				Maux2[28-i][48+j]=1;
			}
		}

		//nave 1 derecha abajo

		for(int i=0; 54+i<=79; i+=7){
			for(int j=0; 48+j<=79; j+=7){
				Maux2[53+i][46+j]=1;
				Maux2[54+i][47+j]=1;
				Maux2[52+i][48+j]=1;
				Maux2[53+i][48+j]=1;
				Maux2[54+i][48+j]=1;
			}
		}

		//nave2 izquierda
		for(int i=0; 23-i>=0;i+=9){
			Maux2[24-i][40]=1;
			Maux2[27-i][40]=1;
			Maux2[27-i][38]=1;
			Maux2[26-i][37]=1;
			Maux2[25-i][37]=1;
			Maux2[24-i][37]=1;
			Maux2[23-i][37]=1;
			Maux2[23-i][38]=1;
			Maux2[23-i][39]=1;
		}

		//nave2 derecha
		for(int i=0; 56+i<=79; i+=9){
			Maux2[52+i][40]=1;
			Maux2[55+i][40]=1;
			Maux2[52+i][38]=1;
			Maux2[53+i][37]=1;
			Maux2[54+i][37]=1;
			Maux2[55+i][37]=1;
			Maux2[56+i][37]=1;
			Maux2[56+i][38]=1;
			Maux2[56+i][39]=1;
		}

    	return Maux2;
    }
    /*
    *Metodo para evolucionar el automata.
	*
	*/
	 @Override
	public void evoluciona(){

		//Se crea una matriz copia para reemplazar los Valores.
		int[][] CopiaM=new int [Imagen.numCells][Imagen.numCells];
	    //System.out.println("entre"); SOP que ayuda a verificar cuando se efectuaba un evoluciona.


		// super.estado++; // Operacion que aumentaba el contador en una unidad.
		int vivos; //Contador de casillas vecindad vivas.
		int muertos; //Contador de casillas vecindad muertas.

		//For que escanea toda la matriz.
		for (int i=0;i<Maux2.length;i++) {
			for (int j=0;j<Maux2.length;j++) {
				vivos=0; //Reiniciar contador de vivos.
				muertos=0; //Reiniciar contador de muertos.

				//System.out.println("Revisando " + i  + ","  + j  ); SOP que ayuda a checar que se realize correctamente el for.
				for (int k=i-1;k<=i+1;k++) {
					for (int l=j-1;l<=j+1;l++) {
						//Analisis de casillas vecindad.
						if (k>=0&&l>=0&&k<Maux2.length&&l<Maux2.length&&(k!=i|| l!=j)) {
							//System.out.println("    Analizando " + k  + ","  + l  + "  --> " + Maux2[k][l]     ); SOP que ayuda a checar los for.
							if ( Maux2[k][l] == 1	) { vivos++; } else { muertos++; }
						}
					}
				}
				if(  Maux2[i][j] == 1 ){           //Si la casilla esta viva,
					if ( vivos==2 || vivos==3  ){  //Y tiene dos o tres vecinos vivos
					 CopiaM[i][j]=1;				//entonces la casilla vivira.
					}else {
					 	CopiaM[i][j]=0;				//De otra forma muere.
						}
				}
				else{ 							//Si la casilla esta muerta,
					if ( vivos == 3 ) {			//Y tiene 3 vecinos vivos
						CopiaM[i][j]=1; 		//La casilla muerta vivira.
					}
					else {
						CopiaM[i][j]=0;			//De otro modo seguira muerta.
					}
				}
				//SOP que cuenta las casillas vecinas muertas y vivas y dice como cambiara el estado de la casilla.
				//System.out.println("      Muertos " + muertos + "  Vivos-> " + vivos   + " -----> " + CopiaM[i][j]   );
			}
		}
		for (int i=0;i<Maux2.length;i++) { 			//Fors que arreglan la matriz a regresar en la copia.
			for (int j=0;j<Maux2.length;j++) {
				Maux2[i][j]=CopiaM[i][j];
			}
		}
		//System.out.println("Termine");//SOP que ayuda a saber cuando acaba una evolucion.
	}
}
