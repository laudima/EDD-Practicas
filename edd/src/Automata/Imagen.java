package edd.src.Automata;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Clase que representa una imagen en donde se va a pintar el automata celular.
 * @author Manuel
 */
public class Imagen extends JPanel {

    /**
     * Tamanio de la celda para cada celula.
     */
    public static final int sizeCell = 7;
    /**
     * Numero de celdas que contendra la malla. Este valor se aplica tanto para altura como para anchura.
     * Es decir la malla tendra numCellsxnumCell numero de celdas.
     */
    public static final int numCells = 80;
    /**
     * Tamanio real que debe de tener la malla considerando una linea divisoria entre las celdas, y el taminio de cada una.
     */
    private static final int tam = numCells * sizeCell + numCells + 1;
    /**
     * Objeto en donde se va a pintar.
     */
    private BufferedImage imagen;

    /**
     * Constructor de la clase.
     */
    public Imagen() {
        setSize(tam, tam);
        imagen = new BufferedImage(tam, tam, BufferedImage.TYPE_INT_RGB);
        createGrid();
    }

    /**
     * Metodo que dibuja las lineas en la imagen en color gris, para dar la apariencia de que es un entramado.
     */
    private void createGrid() {
        Graphics2D gc = imagen.createGraphics();
        //Rectangulo Blanco POR VALOR DE PENCIL DEFAULT.
        gc.fillRect(0,0,tam,tam);
        gc.setColor(Color.GRAY);
        for (int i=0;i<=numCells;i++) {
            gc.drawLine((sizeCell*i)+i,0,(sizeCell*i)+i,tam);
            gc.drawLine(0,(sizeCell*i)+i,tam,(sizeCell*i)+i);
        }
    }

    /**
     * Metodo que mapea la matriz del automata a su representacion grafica. Este metodo considera
     * el tamanio de cada celda para poderla pintar. Se le pasa como parametro un arreglo de colores,
     * para que cada vez que vea un valor en la matriz este lo busque en el arreglo de colores y pinte la celda de ese color.
     * Es necesario que la longitud del arreglo sea igual al maximo de los valores que se encuentran en la matriz.
     * @param matriz Representa la malla del automata con sus posibles estados.
     * @param colores Se mapean a cada estado de la matriz para pintarlo de su respectivo color.
     */
    public void pinta(int[][] matriz, Color[] colores) {
	   Graphics2D gc = imagen.createGraphics();
    for (int i=1;i<matriz.length+1;i++) {
            for (int j=1;j<matriz.length+1;j++) {
                int aux1i = (sizeCell*(i-1)+i);
                int aux1j = (sizeCell*(j-1)+j);

                Color Azul1 = new Color(1,27,45);
                Color Azul2 = new Color(4,31,50);
                Color Azul3 = new Color(0,37,56);
                Color Azul4 = new Color(1,50,68);
                Color Azul5 = new Color(27,61,76);
                Color Azul6 = new Color(35,69,74);

                Color Morado = new Color(103, 3, 252);
                Color Rojo = new Color(252, 3, 3);
                Color Rosa = new Color(252, 3, 219);
                Color Naranja = new Color(252, 107, 3);
                Color Amarillo = new Color(252, 231, 3);
                Color Verde = new Color(24, 252, 3);
                Color Azul = new Color(3, 61, 252);
                Color Fiusha = new Color(252, 3, 173);

                Color Gris = new Color(250,250,250);

                Color Cafe = new Color(162, 144, 166);

               switch (matriz [i-1][j-1]) {
                    case 0:
                        gc.setColor(Cafe); break;
                    case 1:
                        gc.setColor(Color.BLACK); break;
                    case 2:
                        gc.setColor(Azul1); break;
                    case 3:
                        gc.setColor(Azul2); break;
                    case 4:
                        gc.setColor(Azul3); break;
                    case 5:
                        gc.setColor(Azul4); break;
                    case 6:
                        gc.setColor(Azul5); break;
                    case 7:
                        gc.setColor(Azul6); break;
                        //
                    case 8:
                        gc.setColor(Morado); break;
                    case 9:
                        gc.setColor(Rojo); break;
                    case 10:
                        gc.setColor(Rosa); break;
                    case 11:
                        gc.setColor(Naranja); break;
                    case 12:
                        gc.setColor(Amarillo); break;
                    case 13:
                        gc.setColor(Verde); break;
                    case 14:
                        gc.setColor(Azul); break;
                    case 15:
                        gc.setColor(Fiusha); break;
                    case 16:
                        gc.setColor(Gris); break;
                }
                gc.fillRect(aux1i,aux1j,sizeCell,sizeCell);
            }
       }
        updateUI();
    }

    @Override
    public void paint(Graphics g) {
        try{
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(imagen, null, 0, 0);
        }catch(NullPointerException e){}
    }
}
