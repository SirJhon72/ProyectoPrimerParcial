
package primerparcial;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;


public class MainPanel extends javax.swing.JFrame {
    protected BufferedImage Global = null;

    public MainPanel() {
        initComponents();

        TitledBorder LienzoImagen = BorderFactory.createTitledBorder("Imagen Original");
        TitledBorder Histograma = BorderFactory.createTitledBorder("Histograma");
        TitledBorder Piel = BorderFactory.createTitledBorder("Eliminacion de Piel");
        TitledBorder Binarizacion = BorderFactory.createTitledBorder("Binarizacion");
        TitledBorder Contraste = BorderFactory.createTitledBorder("Primer Resultado");
        TitledBorder Final = BorderFactory.createTitledBorder("Segundo Resultado");
        
        LienzoPrincipal.setBorder(LienzoImagen);
        LienzoSinPiel.setBorder(Piel);
        LienzoBinarizacion.setBorder(Binarizacion);
        LienzoContraste.setBorder(Contraste);
        ImagenFinalLienzo.setBorder(Final);
        this.setResizable(false);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JDesktopPane();
        LienzoPrincipal = new javax.swing.JPanel();
        LabelImagenPrincipal = new javax.swing.JLabel();
        loadimage = new javax.swing.JButton();
        ProcesoImagen = new javax.swing.JButton();
        LienzoSinPiel = new javax.swing.JPanel();
        LabelImagenSinPiel = new javax.swing.JLabel();
        LienzoBinarizacion = new javax.swing.JPanel();
        LabelBinarizacion = new javax.swing.JLabel();
        LienzoContraste = new javax.swing.JPanel();
        LabelImagenContraste = new javax.swing.JLabel();
        ImagenFinalLienzo = new javax.swing.JPanel();
        LabelImagenFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout LienzoPrincipalLayout = new javax.swing.GroupLayout(LienzoPrincipal);
        LienzoPrincipal.setLayout(LienzoPrincipalLayout);
        LienzoPrincipalLayout.setHorizontalGroup(
            LienzoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LabelImagenPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        LienzoPrincipalLayout.setVerticalGroup(
            LienzoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LabelImagenPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        loadimage.setText("Cargar Imagen");
        loadimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadimageActionPerformed(evt);
            }
        });

        ProcesoImagen.setText("Procesar Imagen");
        ProcesoImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesoImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LienzoSinPielLayout = new javax.swing.GroupLayout(LienzoSinPiel);
        LienzoSinPiel.setLayout(LienzoSinPielLayout);
        LienzoSinPielLayout.setHorizontalGroup(
            LienzoSinPielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoSinPielLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LabelImagenSinPiel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        LienzoSinPielLayout.setVerticalGroup(
            LienzoSinPielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoSinPielLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelImagenSinPiel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LienzoBinarizacionLayout = new javax.swing.GroupLayout(LienzoBinarizacion);
        LienzoBinarizacion.setLayout(LienzoBinarizacionLayout);
        LienzoBinarizacionLayout.setHorizontalGroup(
            LienzoBinarizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoBinarizacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LabelBinarizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        LienzoBinarizacionLayout.setVerticalGroup(
            LienzoBinarizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoBinarizacionLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LabelBinarizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LienzoContrasteLayout = new javax.swing.GroupLayout(LienzoContraste);
        LienzoContraste.setLayout(LienzoContrasteLayout);
        LienzoContrasteLayout.setHorizontalGroup(
            LienzoContrasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoContrasteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelImagenContraste, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        LienzoContrasteLayout.setVerticalGroup(
            LienzoContrasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LienzoContrasteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LabelImagenContraste, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ImagenFinalLienzoLayout = new javax.swing.GroupLayout(ImagenFinalLienzo);
        ImagenFinalLienzo.setLayout(ImagenFinalLienzoLayout);
        ImagenFinalLienzoLayout.setHorizontalGroup(
            ImagenFinalLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagenFinalLienzoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LabelImagenFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        ImagenFinalLienzoLayout.setVerticalGroup(
            ImagenFinalLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagenFinalLienzoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LabelImagenFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        PanelPrincipal.setLayer(LienzoPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(loadimage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(ProcesoImagen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(LienzoSinPiel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(LienzoBinarizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(LienzoContraste, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PanelPrincipal.setLayer(ImagenFinalLienzo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LienzoSinPiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(loadimage)
                                .addGap(18, 18, 18)
                                .addComponent(ProcesoImagen))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(LienzoBinarizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LienzoContraste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(ImagenFinalLienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(LienzoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LienzoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadimage)
                    .addComponent(ProcesoImagen))
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LienzoSinPiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LienzoBinarizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LienzoContraste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ImagenFinalLienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadimageActionPerformed
        RecortarOjo IMG = new RecortarOjo();
        Global = IMG.CargadoDeImagen();
        SetImagenPrincipal(Global);

        
        
    }//GEN-LAST:event_loadimageActionPerformed

    private void ProcesoImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesoImagenActionPerformed
        RecortarOjo IMG = new RecortarOjo();
        int No_Pixeles_Orig = Global.getWidth() * Global.getHeight();
        
        //Eliminamos la piel 
        BufferedImage SinPielPre = IMG.CopyImage(Global);
        BufferedImage ImagenSinPiel = IMG.EliminacionPiel(SinPielPre);
        SetImagenSinPiel(ImagenSinPiel);
        
        //Eliminacion binarizacion de la imagen para eliminar la parte blanca del ojo 
        BufferedImage Pre_ImagenBinarizada = IMG.CopyImage(ImagenSinPiel);
        BufferedImage ImagenBinarizadaRojo = IMG.BinarizarImagenRojo(Pre_ImagenBinarizada, 150);
        SetImagenBinarizacion(ImagenBinarizadaRojo);
        
        //Tomamos el radio
        double Radio = IMG.DetectarRadioIris(ImagenBinarizadaRojo);
        BufferedImage ImagenRoja = IMG.RecortarOjo(ImagenBinarizadaRojo, Radio);
        SetImagenContraste(ImagenRoja);
        
        //Recortamos con la imagen original y el radio conseguido
        BufferedImage Pre_RecorteImagen = IMG.CopyImage(Global);
        BufferedImage PreImagenRecortada = IMG.CopyImage(Pre_RecorteImagen);
        BufferedImage PreImagenFinalRecortada = IMG.RecortarOjo(PreImagenRecortada, Radio);
        SetImagenContraste(PreImagenFinalRecortada);
        
        //Recoramos las pestanas 
        BufferedImage Pre_ImagenFinal = IMG.CopyImage(PreImagenFinalRecortada);
        BufferedImage ImagenFinal = IMG.EliminarPestanasSuperiores(Pre_ImagenFinal);
        SetImagenFinal(ImagenFinal);

        
        //Imprimir mensaje de datos 
        int Pixeles_Resultado_1 = IMG.ContarPixelesFinales(PreImagenFinalRecortada);
        int Pixeles_Resultado_2 = IMG.ContarPixelesFinales(ImagenFinal);
        System.out.println("Pixeles Orig: " + No_Pixeles_Orig + " - Resultado 1: " + Pixeles_Resultado_1 + " - Resultado 2: " + Pixeles_Resultado_2);
        
    }//GEN-LAST:event_ProcesoImagenActionPerformed


    //Colocar la imagen original en el lienzo
    protected void SetImagenPrincipal(BufferedImage img){
        Image ScaledImage = img.getScaledInstance(LabelImagenPrincipal.getWidth(), LabelImagenPrincipal.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(ScaledImage);
        LabelImagenPrincipal.setIcon(Icon);
    }
    
    //Colocar la imagen sin piel 
    protected void SetImagenSinPiel(BufferedImage img){
        Image ScaledImage = img.getScaledInstance(LabelImagenSinPiel.getWidth(), LabelImagenSinPiel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(ScaledImage);
        LabelImagenSinPiel.setIcon(Icon);
    }
    
    //Colocar la imagen binarizada
    protected void SetImagenBinarizacion(BufferedImage img){
        Image ScaledImage = img.getScaledInstance(LabelBinarizacion.getWidth(), LabelBinarizacion.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(ScaledImage);
        LabelBinarizacion.setIcon(Icon);
    }
    
    
    //Colocar la imagen contraste
    protected void SetImagenContraste(BufferedImage img){
        Image ScaledImage = img.getScaledInstance(LabelImagenContraste.getWidth(), LabelImagenContraste.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(ScaledImage);
        LabelImagenContraste.setIcon(Icon);
    }
    
    //Colocar la imgen final
    protected void SetImagenFinal(BufferedImage img){
        Image ScaledImage = img.getScaledInstance(LabelImagenFinal.getWidth(), LabelImagenFinal.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(ScaledImage);
        LabelImagenFinal.setIcon(Icon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagenFinalLienzo;
    private javax.swing.JLabel LabelBinarizacion;
    private javax.swing.JLabel LabelImagenContraste;
    private javax.swing.JLabel LabelImagenFinal;
    private javax.swing.JLabel LabelImagenPrincipal;
    private javax.swing.JLabel LabelImagenSinPiel;
    private javax.swing.JPanel LienzoBinarizacion;
    private javax.swing.JPanel LienzoContraste;
    private javax.swing.JPanel LienzoPrincipal;
    private javax.swing.JPanel LienzoSinPiel;
    private javax.swing.JDesktopPane PanelPrincipal;
    private javax.swing.JButton ProcesoImagen;
    private javax.swing.JButton loadimage;
    // End of variables declaration//GEN-END:variables
}
