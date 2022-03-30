package edd.src.Automata;

import java.util.Random;
import edd.src.Estructuras.*;

public class Mondrian2 extends AC {

    int[][] Maux2 = new int[Imagen.numCells][Imagen.numCells];
    int[][] MauxCopia = new int[Imagen.numCells][Imagen.numCells];
    int[][] CopiaM = new int[Imagen.numCells][Imagen.numCells];


    int color=0;
    /*
     * Metodo que pinta una matriz inicial de Blanco y le da valores aleatorios a las
     * casillas.
     *
     */
    @Override
    public int[][] getAutomata() {
        int aux1;
        //Inicializo dos matrices en blanco
        for (int i = 0; i < Maux2.length; i++) {
            for (int j = 0; j < Maux2.length; j++) {
                Maux2[i][j] = 0;
                MauxCopia[i][j] = 0;
            }
        }
        //----------NAVES------------

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

        //cuadrado del centro
        for(int k=29; k<=51; k++){
            for(int l=29; l<=49;l++){
                if(k%2==0 && l%2==0){
                    Maux2[k][l]=2;
                }else if(k%2==1 && l%2==0){
                    Maux2[k][l]=16;
                }
            }
        }

        //linea esquina arriba izquierda
        for(int k=0; k<=29; k++){
            for(int l=0; l<=30;l++){
                if(k==l){
                    Maux2[k][l]=1;
                }
            }
        }
        //linea esquina arriba derecha
        for(int k=79; k>=49; k--){
            for(int l=0; l<=29;l++){
                if(k+l==79){
                    Maux2[k][l]=1;
                }
            }
        }
        //linea esquina abajo izquierda
        for(int k=0; k<=29; k++){
            for(int l=50; l<=79;l++){
                if(k+l==79){
                    Maux2[k][l]=1;
                }
            }
        }
        //primera seccion abajo
        for(int k=0; k<=29; k++){
            for(int l=50; l<=79;l++){
                for(int p=0; p<=20;p++){
                    if(p<=4){
                        if(k+l==79){
                            Maux2[k+p][l]=8;
                        }
                    }
                    else if(p>=5 && p<=9){
                        if(k+l==79){
                            Maux2[k+p][l]=9;
                        }
                    }
                    else if(p>=10 && p<=14){
                        if(k+l==79){
                            Maux2[k+p][l]=10;
                        }
                    }
                    else if(p>=15 && p<=20){
                        if(k+l==79){
                            Maux2[k+p][l]=11;
                        }
                    }
                }
            }
        }

        //triangulo primera mitad
        for(int k=0; k<=19;k++){
            for(int l=0;l<=k; l++){
                if(k>= 0 && k<=4){
                    Maux2[20+k][79-l]=12;
                }else if(k>=5 && k<= 9){
                    Maux2[20+k][79-l]=13;
                }else if(k>=10 && k<= 14){
                    Maux2[20+k][79-l]=14;
                }else if(k>=15 && k<= 19){
                    Maux2[20+k][79-l]=15;
                }
            }
        }
        //triangulo segunda mitad
        for(int k=0; k<=19;k++){
            for(int l=0;l<=(19-k);l++){
                if(k>= 0 && k<=4){
                    Maux2[40+k][79-l]=8;
                }else if(k>=5 && k<= 9){
                    Maux2[40+k][79-l]=9;
                }else if(k>=10 && k<=14){
                    Maux2[40+k][79-l]=10;
                }else if(k>=15 && k<= 19){
                    Maux2[40+k][79-l]=11;
                }
            }
        }

        //segunda seccion abajo
        for(int k=79; k>=50; k--){
            for(int l=79; l>=49;l--){
                for(int p=0; p<=20;p++){
                    if(p>=0 && p<=4){
                        if(k==l){
                            Maux2[k-p][l]=12;
                        }
                    }
                    if(p>=5 && p<=9){
                        if(k==l){
                            Maux2[k-p][l]=13;
                        }
                    }
                    if(p>=10 && p<=14){
                        if(k==l){
                            Maux2[k-p][l]=14;
                        }
                    }
                    if(p>=15 && p<=19){
                        if(k==l){
                            Maux2[k-p][l]=15;
                        }
                    }
                }
            }
        }
        //seccion de arriba
        for(int k=0; k<=29; k++){
            for(int l=k; l<=79-k; l++){
                switch(l%12){
                    case 0:
                        Maux2[l][k]= 2;break;
                    case 1:
                        Maux2[l][k]= 3;break;
                    case 2:
                        Maux2[l][k]= 4;break;
                    case 3:
                        Maux2[l][k]= 5;break;
                    case 4:
                        Maux2[l][k]= 6;break;
                    case 5:
                        Maux2[l][k]= 7;break;
                    case 6:
                        Maux2[l][k]= 7;break;
                    case 7:
                        Maux2[l][k]= 6;break;
                    case 8:
                        Maux2[l][k]= 5;break;
                    case 9:
                        Maux2[l][k]= 4;break;
                    case 10:
                        Maux2[l][k]= 3;break;
                    case 11:
                        Maux2[l][k]= 2;break;
                }
            }
        }
        return Maux2;
    }

    /*
     * Metodo para evolucionar el automata.
     *
     */
    @Override
    public void evoluciona() {

        // Se crea una matriz copia para reemplazar los Valores.
        int[][] CopiaM = new int[Imagen.numCells][Imagen.numCells];

        // Aqui empieza una evolucion.

        //Creamos una pila y una cola para que te diviertas joven Artista.
        Pila<Integer> azules = new Pila<Integer>();

        //Pila<Integer> colores = new Pila<Integer>();


        //numero random para los colores
        int min;
		int max;

		Random random = new Random();



        //La matriz Maux2 Contiene el estado actual de la matriz.
        //La matriz CopiaM es una matriz copia de Maux2 donde debes poner los nuevos valores

        // Aqui va tu codigo

        //-----------------CENTRO----------------------------------------
        for(int k=29; k<=51; k++){
            for(int l=29; l<=49;l++){
                if(k%2==0 && l%2==0){
                    CopiaM[k][l]= (color%2==0) ? 2:16;
                }else if(k%2==1 && l%2==0){
                    CopiaM[k][l]= (color%2==0) ? 16:2;
                }else{
                    CopiaM[k][l]= (color%2==0) ? 16:2;
                }
            }
        }



        //---- Trapecio de arriba---------------------------------------------
        for(int i=0; i<=29; i++){
            for(int j=i; j<=79-i; j++){
                min =2; max=7;
                int value = random.nextInt(max + min) + min;
                azules.push(value);
                switch(j%12){
                    case 0:
                        CopiaM[j][i]= azules.pop();break;
                    case 1:
                        CopiaM[j][i]= azules.pop();break;
                    case 2:
                        CopiaM[j][i]= azules.pop();break;
                    case 3:
                        CopiaM[j][i]= azules.pop();break;
                    case 4:
                        CopiaM[j][i]= azules.pop();break;
                    case 5:
                        CopiaM[j][i]= azules.pop();break;
                    case 6:
                        CopiaM[j][i]= azules.pop();break;
                    case 7:
                        CopiaM[j][i]= azules.pop();break;
                    case 8:
                        CopiaM[j][i]= azules.pop();break;
                    case 9:
                        CopiaM[j][i]= azules.pop();break;
                    case 10:
                        CopiaM[j][i]= azules.pop();break;
                    case 11:
                        CopiaM[j][i]= azules.pop();break;
                }
                azules.push(value);
            }
        }
        color++;

        //---Seccion de abajo-----------------------------------------------

        //Se alternan los colores de la primera seccion de abajo
        for(int k=0; k<=29; k++){
            for(int l=50; l<=79;l++){
                for(int p=0; p<=20;p++){
                    min=8; max=15;
                    int value = random.nextInt(max + min) + min;
                    if(p<=4){
                        if(k+l==79){
                            CopiaM[k+p][l]=value;
                        }
                    }
                    else if(p>=5 && p<=9){
                        if(k+l==79){
                            CopiaM[k+p][l]=value;
                        }
                    }
                    else if(p>=10 && p<=14){
                        if(k+l==79){
                            CopiaM[k+p][l]=value;
                        }
                    }
                    else if(p>=15 && p<=20){
                        if(k+l==79){
                            CopiaM[k+p][l]=value;
                        }
                    }
                }
            }
        }

        //triangulo primera mitad
        for(int k=0; k<=19;k++){
            for(int l=0;l<=k; l++){
                min=8; max=15;
                int value = random.nextInt(max + min) + min;
                if(k>= 0 && k<=4){
                    CopiaM[20+k][79-l]=value;
                }else if(k>=5 && k<= 9){
                    CopiaM[20+k][79-l]=value;
                }else if(k>=10 && k<= 14){
                    CopiaM[20+k][79-l]=value;
                }else if(k>=15 && k<= 19){
                    CopiaM[20+k][79-l]=value;
                }
            }
        }
        //triangulo segunda mitad
        for(int k=0; k<=19;k++){
            for(int l=0;l<=(19-k);l++){
                min=8; max=15;
                int value = random.nextInt(max + min) + min;
                if(k>= 0 && k<=4){
                    CopiaM[40+k][79-l]=value;
                }else if(k>=5 && k<= 9){
                    CopiaM[40+k][79-l]=value;
                }else if(k>=10 && k<=14){
                    CopiaM[40+k][79-l]=value;
                }else if(k>=15 && k<= 19){
                    CopiaM[40+k][79-l]=value;
                }
            }
        }

        //segunda seccion abajo
        for(int k=79; k>=50; k--){
            for(int l=79; l>=49;l--){
                for(int p=0; p<=20;p++){
                    min=8; max=15;
                    int value = random.nextInt(max + min) + min;
                    if(p>=0 && p<=4){
                        if(k==l){
                            CopiaM[k-p][l]=value;
                        }
                    }
                    if(p>=5 && p<=9){
                        if(k==l){
                            CopiaM[k-p][l]=value;
                        }
                    }
                    if(p>=10 && p<=14){
                        if(k==l){
                            CopiaM[k-p][l]=value;
                        }
                    }
                    if(p>=15 && p<=19){
                        if(k==l){
                            CopiaM[k-p][l]=value;
                        }
                    }
                }
            }
        }

        //---Juego de la vida---------------------------------------------------


        int vivos; //Contador de casillas vecindad vivas.
        int muertos;

        //For que escanea toda la matriz.
        for (int i=0;i<Maux2.length;i++) {
            for (int j=0;j<Maux2.length;j++) {
                vivos=0; //Reiniciar contador de vivos.
                muertos=0; //Reiniciar contador de muertos.

                for (int k=i-1;k<=i+1;k++) {
                    for (int l=j-1;l<=j+1;l++) {
                        //Analisis de casillas vecindad.
                        if (k>=0&&l>=0&&k<Maux2.length&&l<Maux2.length&&(k!=i|| l!=j)) {
                            //System.out.println("    Analizando " + k  + ","  + l  + "  --> " + Maux2[k][l]     ); SOP que ayuda a checar los for.
                            if ( Maux2[k][l] == 1) { vivos++; } else { muertos++; }
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
                else if(Maux2[i][j] == 0){ 							//Si la casilla esta muerta,
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

        for (int i = 0; i < Maux2.length; i++) { // Fors que arreglan la matriz a regresar en la copia.
            for (int j = 0; j < Maux2.length; j++) {
                Maux2[i][j] = CopiaM[i][j];
            }
        }
    }

    public void evoluciona2(){

    }

    public int[][] getAutomata2() {
        return Maux2;
    }
}
