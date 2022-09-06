import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaProcesadorTexto extends JFrame {
    public VentanaProcesadorTexto() {
        panelTexto = new PanelTexto();

        setTitle("Procesador de texto");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add(new PanelTexto(), BorderLayout.CENTER);
        add(panelTexto);
        setJMenuBar(new BarraProcesador(panelTexto));

        setVisible(true);
    }
    private class BarraProcesador extends JMenuBar{
        PanelTexto panelTexto;
        String fontFamily;
        int fontStyle, fontSize;
        public BarraProcesador(PanelTexto panelTexto){
            this.panelTexto = panelTexto;

            fontFamily = "Arial";
            fontStyle = Font.PLAIN;
            fontSize = 11;
            panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));

            add(new MenuFuentes());
            add(new MenuEstilos());
            add(new MenuSize());
        }

        private class MenuFuentes extends JMenu{
            JMenuItem arial, verdana, courier;
            public MenuFuentes(){
                super("Fuentes");
                arial = new JMenuItem("Arial");
                arial.addActionListener(new MenuAcciones());
                verdana = new JMenuItem("Verdana");
                verdana.addActionListener(new MenuAcciones());
                courier = new JMenuItem("Courier");
                courier.addActionListener(new MenuAcciones());

                add(arial);
                add(verdana);
                add(courier);
            }
            private class MenuAcciones implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == arial){
                        fontFamily = "Arial";
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                    if (e.getSource() == verdana){
                        fontFamily = "Verdana";
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                    if (e.getSource() == courier){
                        fontFamily = "Courier";
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                }
            }
        }

        private class MenuEstilos extends JMenu{
            JMenuItem negrita, cursiva;
            public MenuEstilos(){
                super("Estilos");
                negrita = new JMenuItem("Negrita");
                negrita.addActionListener(new MenuAcciones());
                cursiva = new JMenuItem("Cursiva");
                cursiva.addActionListener(new MenuAcciones());

                add(negrita);
                add(cursiva);
            }

            private class MenuAcciones implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e){
                    if (e.getSource() == negrita){
                        fontStyle = Font.BOLD;
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                    if (e.getSource() == cursiva){
                        fontStyle = Font.ITALIC;
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                }
            }
        }

        private class MenuSize extends JMenu{
            JMenuItem size11, size12;
            public MenuSize(){
                super("Tamaño");
                size11 = new JMenuItem("11");
                size11.addActionListener(new MenuAcciones());
                size12 = new JMenuItem("12");
                size12.addActionListener(new MenuAcciones());

                add(size11);
                add(size12);
            }

            private class MenuAcciones implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e){
                    if (e.getSource() == size11){
                        fontSize = 11;
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                    if (e.getSource() == size12){
                        fontSize = 12;
                        panelTexto.setFont(new Font(fontFamily, fontStyle, fontSize));
                    }
                }
            }
        }
    }
    PanelTexto panelTexto;
    private class PanelTexto extends JTextPane{

    }
}


