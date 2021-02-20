package primerparcial;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import static javax.swing.Spring.width;


public class RecortarOjo {
    int RadioGlobal = 0;
    int DistanciaSuperior = 0;
    
    //Cargar la imagen del seleccionador de archivos
    protected BufferedImage CargadoDeImagen(){
        BufferedImage img = null;
        try {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        
        //Obtenemos la copia para el buffer
        img = ImageIO.read(file);
              
            
        } catch (Exception e) {
            System.out.println("Erro de lectura");
        }
        
        return img;
    }
    
    
    //Copiar la imagen 
    protected BufferedImage CopyImage(BufferedImage original){
        BufferedImage clone = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics2D g2d = clone.createGraphics();
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();
        return clone;
    }

    //Eliminacion de la piel de la imagen 
    protected BufferedImage EliminacionPiel(BufferedImage original){
        int Pixel;
        double Red, Green, Blue, Alpha;
        double H, S, V; 
        Color color; 
        Color blank = Color.white;
        HSV hsv_data; 
        
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                
                //Obtenemos los datos necesarios para la comprobacion de la piel
                Pixel = original.getRGB(i, j);
                color = new Color(Pixel, true);
                Red = color.getRed();
                Green = color.getGreen();
                Blue = color.getBlue();
                Alpha = color.getAlpha();
                hsv_data = Conversion_HSV_RGB(Red, Green, Blue);
                H = hsv_data.getH();
                S = hsv_data.getS();
                V = hsv_data.getV();
                //Comprobamos si el pixel es cuestion en piel 
                if(esPiel(H, S, V, Red, Green, Blue, Alpha)){
                    //Si el pixel en cuestion es piel, se coloca de color_Copia blanco
                    original.setRGB(i, j, blank.getRGB());
                }else{
                    //Si el pixel en cuestion no es piel, deja su color_Copia original
                    original.setRGB(i, j, color.getRGB());
                }
            }
        }
        return original;
    }

    //Detectar si un pixel es piel 
    protected boolean esPiel(double H, double S, double V, double Red, double Green, double Blue, double Alpha){
        boolean flag = false;
        if(H >= 0 && H <= 50){
            if(S >= 23 && S <= 68){
       
                if(Red > 95 && Green > 40 && Blue > 20){
                    if(Red > Green && Red > Blue){
                        if(Math.abs(Red - Green) > 15 && Alpha > 15){
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }
    
    //Conversion de RGB a HSV
    protected HSV Conversion_HSV_RGB(double Red, double Green, double Blue){
    Red = Red / 255.0;
    Green = Green / 255.0;
    Blue = Blue / 255.0;
    
    //H, S, V --> Matiz, Saturacion, Valor
    double CMax = Math.max(Red, Math.max(Green, Blue));
    double CMin = Math.min(Red, Math.min(Green, Blue));
    double diff = CMax - CMin;
    double H = -1; 
    double S = -1;
    
    //Si Cmax and Cmin son iguales entonces h = 0
    if(CMax == CMin){
        H = 0;
    }
    
    //SI CMax es igual a R entonces H
    else if(CMax == Red){
        H = (60 * ((Green - Blue) / diff) + 360) % 360;
    }

    //Si CMax es igual a G entonces H
    else if(CMax == Green){
        H = (60 * ((Blue - Red) / diff) + 120) % 360;
    }

    //Si CMax es igual a B entonces 
    else if(CMax == Blue){
        H = (60 * ((Red - Green) / diff) + 240) % 360;
    }
    
    //Si CMAx == 0 
    if(CMax == 0){
       S = 0;
    }else{
        S = (diff / CMax) * 100;
    }
    
    double V = CMax * 100;
    HSV HSV_Data = new HSV(H, S, V);
    //System.out.println("Matiz: " + H + " Satuacion: " + S + " Valor: " + V);
    return HSV_Data;
    }

    //Binarizar imagen para eliminar colores blancos puros - ROJO -
    protected BufferedImage BinarizarImagenRojo(BufferedImage original, int Punto){
        int Pixel; 
        double Red, Green, Blue;
        Color color;
        Color red = Color.red;
        double Prom;
        
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                Pixel = original.getRGB(i, j);
                color = new Color(Pixel, true);
                Red = color.getRed();
                Green = color.getGreen();
                Blue = color.getBlue();
                Prom = (Red + Green + Blue) / 3;
                if(Prom < Punto){
                    original.setRGB(i, j, color.getRGB());
                }else{
                    original.setRGB(i, j, red.getRGB());
                }
            }
        }
        return original;
    }

        //Binarizar imagen para eliminar colores blancos puros
    protected BufferedImage BinarizarImagenBlanco(BufferedImage original, int Punto){
        int Pixel; 
        double Red, Green, Blue;
        Color color;
        Color white = Color.white;
        double Prom;
        
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                Pixel = original.getRGB(i, j);
                color = new Color(Pixel, true);
                Red = color.getRed();
                Green = color.getGreen();
                Blue = color.getBlue();
                Prom = (Red + Green + Blue) / 3;
                if(Prom < Punto){
                    original.setRGB(i, j, color.getRGB());
                }else{
                    original.setRGB(i, j, white.getRGB());
                }
                
            }
        }
        
        return original;
    }


    
    //Protected detectar colores de la imagen 
    protected BufferedImage DetectarColorIris(BufferedImage original){
        int Pixel;
        double Red, Green, Blue;
        Color color;
        Color blank = Color.white;
        HSV hsv_data; 
        double H, S, V;
        
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                Pixel = original.getRGB(i, j);
                color = new Color(Pixel, true);
                Red = color.getRed();
                Green = color.getGreen();
                Blue = color.getBlue();
                hsv_data = Conversion_HSV_RGB(Red, Green, Blue);
                H = hsv_data.getH();
                S = hsv_data.getS();
                V = hsv_data.getV();
                
                if(DetectarColor(H, S, V)){
                    original.setRGB(i, j, color.getRGB());
                }else{
                    original.setRGB(i, j, blank.getRGB());
                }
                
            }
        }
        
        return original;
    }
    
    //Detectar color_Copia azul 
    protected boolean DetectarColor(double H, double S, double V){
        boolean flag = false;
        if((H > 20 && H < 300) ){
            flag = true;
        }
        return flag;
    }
    
    //Proceso para eliminar las pestanas 
    protected BufferedImage EliminarPestanas(BufferedImage original){
        int Pixel_Original;
        double Red, Green, Blue;
        double H, S, V;
        HSV hsv_data;
        Color color;
        Color blank = Color.white;
        
     
        //Vamos a verificar si el proceso debe de realizarse para ojos de color_Copia o cafe 
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                //Sacamos el pixel de la copia y el original
                Pixel_Original = original.getRGB(i, j);
                
                //Sacamos el color del pixel del original y la copia
                color = new Color(Pixel_Original, true);
                
                Red = color.getRed();
                Green = color.getGreen();
                Blue = color.getBlue();
                hsv_data = Conversion_HSV_RGB(Red, Green, Blue);
                H = hsv_data.getH();
                S = hsv_data.getS();
                V = hsv_data.getV();
                                
                if(DetectarColor(H, S, V) == true){
                    original.setRGB(i, j, color.getRGB());
                }else{
                    original.setRGB(i, j, blank.getRGB());

                }
            }
        }
        
        return original;
    }
    
    //Aumentamos el brillo y diminuimos el contraste de la imagen 
    protected BufferedImage BrilloContrasteImage(BufferedImage original){
        //Aumentamos el contraste de la imagen 
        /*
        @Params
            Brillo, Contraste, null            
        */
        RescaleOp rescaleOp = new RescaleOp(1.2f, 1f, null);
        return rescaleOp.filter(original, original);   
    }
    
    //Aumentar el brillo de la imagen 
    protected BufferedImage AumentarBrillo(BufferedImage original){
        RescaleOp rescaleOp = new RescaleOp(2f, 2f, null);
        return rescaleOp.filter(original, original); 
    }
    
    //Inverso de una imagen 
    protected BufferedImage InversorImagen(BufferedImage original){
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                int Pixel = original.getRGB(i, j);
                Color color = new Color(Pixel, true);
                Color InvertColor = new Color(255 - color.getRed(), 255 - color.getBlue(), 255 - color.getGreen());
                original.setRGB(i, j, InvertColor.getRGB());
            }
        }        
        
        return original;
        
    }
    
    //Metodo que calcula el radio del iris
    protected double DetectarRadioIris(BufferedImage original){
        System.out.println("");
        int Pixel;
        double Red, Green, Blue;
        int CoorX = 0;
        int CoorY = 0;
        Color color;
        Coordenadas coordenadas_Izquierdas = null;
        Coordenadas coordenadas_Derechas = null;
        Coordenadas coordenadas_inferiores = null;
        Coordenadas centrales = null;
        
        //Cordenadas del centro 
        int CentroHorizontal = (original.getWidth())/2;
        int CentroVertical = (original.getHeight())/2;
        centrales = new Coordenadas(CentroHorizontal, CentroVertical);
        
        /*
        Tenemos que realizar 4 recorridos
            1 - Primer recorrido, del centro a la izquierda
            2 - Segundo recorrido, del centro a la derecha
            3 - Tercer recorrido, del centro hacia abajo
            4 - Cuarto recorrido, del centro hacia arriba
        */
        
        //Primero Recorrido
        int i = CentroVertical;
        for(int j = CentroHorizontal; j >= 0; j--){
            Pixel = original.getRGB(i, j);
            color = new Color(Pixel, true);
            
            if(color.getRed() == 255){
                CoorX = i;
                CoorY = j;
                //Salimos del ciclo for
                break;
            }
        }
        
        coordenadas_Izquierdas = new Coordenadas(CoorX, CoorY);
        
        //Segundo recorrido
        i = CentroVertical;
        for(int j = CentroHorizontal; j < original.getWidth(); j++){
            Pixel = original.getRGB(i, j);
            color = new Color(Pixel, true);
            
            if(color.getRed() == 255){
                CoorX = i;
                CoorY = j;
                break;
            }
        }
        coordenadas_Derechas =  new Coordenadas(CoorX, CoorY);
        
        //tercer recorrido
        i = CentroHorizontal;
        for(int j = CentroVertical; j < original.getHeight(); j++){
            Pixel = original.getRGB(i, j);
            color = new Color(Pixel, true);
            
            if(color.getRed() == 255){
                CoorX = i;
                CoorY = j;
                break;
            }
        }
        coordenadas_inferiores = new Coordenadas(CoorX, CoorY);

        //Cuarto Recorrido
        i = CentroHorizontal;
        for(int j = CentroVertical; j < original.getHeight(); j--){
            Pixel = original.getRGB(i, j);
            color = new Color(Pixel, true);
            
            if(color.getRed() == 255){
                /* Guardamos la distancia superior para eliminar las pestanas mas tarde */
                DistanciaSuperior = j;
                break;
            }
        }
        

        int Radio = DistanciaMayor(coordenadas_Izquierdas, coordenadas_Derechas, coordenadas_inferiores, centrales);
        return Radio;
    }
    
   
    
    //Funcion que retorna la coordenada mayor 
    protected int DistanciaMayor(Coordenadas Izquierda, Coordenadas Derecha, Coordenadas Inf, Coordenadas Central){
        //Calculamos la distancia mayor
        double Distancia_Izquierda = Math.abs(Central.getCoordenadaX() - Izquierda.getCoordenadaX());
        double Distancia_Derecha = Math.abs(Central.getCoordenadaX() - Derecha.getCoordenadaX());
        double Distancia_Inferior = Math.abs(Central.getCoordenadaY() - Derecha.getCoordenadaY());
        double X = Math.max(Distancia_Izquierda, Math.max(Distancia_Derecha, Distancia_Inferior));
        
        //Redondeamos la distancia
        //int distancia = (int)Math.round(X);
        
        double DistanciaPromedio = (Distancia_Izquierda + Distancia_Derecha + Distancia_Inferior) / 3;
        int distancia = (int)Math.round(DistanciaPromedio);
        
        return distancia;
    }
    
   
    //Recortar Imagen 
    protected BufferedImage RecortarOjo(BufferedImage original, double Radio){
        int Pixel_Original;
        int CentroX = original.getWidth()/2;
        int CentroY = original.getHeight()/2;
        
        Color Color_Original;
        Color blank = Color.white;
        
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                Pixel_Original = original.getRGB(i, j);
                Color_Original = new Color(Pixel_Original, true);
                if(CalcularDistancia(CentroX, CentroY, i, j) <= Radio){
                    original.setRGB(i, j, Color_Original.getRGB());
                }else{
                    original.setRGB(i, j, blank.getRGB());
                }
            }
        }
        return original;
    }
    
    //Calcula la distancia 
    protected double CalcularDistancia(int CenterX, int CenterY, int PointX, int PointY){
        double Parte_1 = PointX - CenterX;
        double Parte_2 = PointY - CenterY;
        
        Parte_1 = Math.pow(Parte_1, 2);
        Parte_2 = Math.pow(Parte_2, 2);
        
        double Parte_3 = Math.sqrt(Parte_1 + Parte_2);
        return Parte_3;        
    }
    
    //Eliminar la pestana superior
    protected BufferedImage EliminarPestanasSuperiores(BufferedImage original){

        Color blank = Color.white;
        
        //Aqui solo pintaremos de blanco las pestanas que estan por encima de 
        //de la distancia superior que calculamos anteriormente
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < DistanciaSuperior; j++){
                original.setRGB(i, j, blank.getRGB());                
            }
        }
        
        return original;
    }
    
    //Contar Pixeles finales 
    protected int ContarPixelesFinales(BufferedImage original){
        int No_Pixeles_Final = 0;
        int Pixel; 
        Color color; 
        Color blank = Color.white;
        
        //Contamos los pixeles diferentes del blanco
        for(int i = 0; i < original.getWidth(); i++){
            for(int j = 0; j < original.getHeight(); j++){
                Pixel = original.getRGB(i, j);
                color = new Color(Pixel, true);
                
                if(color.getRGB() != blank.getRGB()){
                    No_Pixeles_Final++;
                }
            }
        }
        return No_Pixeles_Final;
    }
    
    
    //GuardarImageb como un jpge
    protected void GuardarImagen(BufferedImage Img, String nombre){
        try {
            ImageIO.write(Img, "jpg", new File(nombre + ".jpg"));
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
    }
    
}
