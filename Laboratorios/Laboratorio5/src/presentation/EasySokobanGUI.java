package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class EasySokobanGUI extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenuItem itemNuevo, itemAbrir, itemSalvar, itemSalir;
    private JMenu menuConfiguracion;
    private JMenuItem itemChangeSize, itemChangeColor;

    private JPanel panelTop;
    private JPanel panelLeft;
    private JPanel panelCenter;
    private JPanel panelRight;

    private JLabel colorCajasLabel;
    private JLabel colorDestinoLabel;

    public EasySokobanGUI() {
        super("EasySokoban");
        prepareElements();
        prepareElementsMenu();
        prepareActions();
        prepareActionsMenu();
    }

    /**
     * Método main para realizar la ejecución del programa
     * 
     * @param args
     */
    public static void main(String[] args) {
        EasySokobanGUI sokoban = new EasySokobanGUI();
        sokoban.setVisible(true);
    }

    /**
     * Preparar los elementos para mostrar.
     */
    public void prepareElements() {

        Dimension SSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = SSize.width / 4;
        int height = SSize.height / 4;

        setSize(width, height + 150);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new BorderLayout());

        TopBorder();
        LeftBorder();
        prepareElementsBoard();
        RightPanel();
    }

    public void prepareElementsMenu() {
        menuBar = new JMenuBar();
        menuArchivo = new JMenu("File");
        menuConfiguracion = new JMenu("Settings");

        itemNuevo = new JMenuItem("New Game");
        itemAbrir = new JMenuItem("Open Game");
        itemSalvar = new JMenuItem("Save Game");
        itemSalir = new JMenuItem("Exit");
        itemChangeSize = new JMenuItem("Change Size");
        itemChangeColor = new JMenuItem("Change Color");

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.addSeparator();

        menuArchivo.add(itemSalvar);
        menuArchivo.add(itemSalir);

        menuBar.add(menuArchivo);

        menuBar.add(menuConfiguracion);
        menuConfiguracion.add(itemChangeSize);
        menuConfiguracion.add(itemChangeColor);
        setJMenuBar(menuBar);
    }

    /**
     * Acciones de los botones del menú.
     */
    public void prepareActionsMenu() {

        // Botones de File
        // Accion del boton Salir
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        // Accion del boton Nuevo juego
        itemNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EasySokobanGUI.this, "Nuevo Juego");
            }
        });

        // Accion del boton Abrir archivo.
        itemAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int resultado = chooser.showOpenDialog(EasySokobanGUI.this);

                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = chooser.getSelectedFile();
                    JOptionPane.showMessageDialog(EasySokobanGUI.this,
                            "Abrir se encuentra en construcción. \nNombre del archivo:\n" + archivo.getName());
                }
            }
        });

        // Accion del boton Guardar archivo
        itemSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int resultado = chooser.showSaveDialog(EasySokobanGUI.this);

                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = chooser.getSelectedFile();
                    JOptionPane.showMessageDialog(EasySokobanGUI.this,
                            "Salvar se encuentra en construcción. \nNombre del archivo:\n" + archivo.getName());
                }
            }
        });

        // Accion de botones de Settings

        // Accion del boton Change Size

        // Necesito ajustar la dimension del tablero con ancho y altura
        itemChangeSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(EasySokobanGUI.this, "Cambiar Dimensiones del Tablero", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(EasySokobanGUI.this);
                dialog.setLayout(new BorderLayout());

                JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
                panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                JLabel lblAncho = new JLabel("Nuevo Ancho:");
                JTextField txtAncho = new JTextField();

                JLabel lblAltura = new JLabel("Nueva Altura:");
                JTextField txtAltura = new JTextField();

                JButton btnAceptar = new JButton("Aceptar");
                btnAceptar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        // Aquí puedes procesar o guardar los valores ingresados
                        // String nuevoAncho = txtAncho.getText();
                        // String nuevaAltura = txtAltura.getText();
                        dialog.dispose();
                    }
                });

                panel.add(lblAncho);
                panel.add(txtAncho);
                panel.add(lblAltura);
                panel.add(txtAltura);
                panel.add(new JLabel("")); // Espacio en blanco para alinear el botón a la derecha
                panel.add(btnAceptar);

                dialog.add(panel, BorderLayout.CENTER);

                dialog.setVisible(true);
            }
        });

        // Accion del boton Change Color
        itemChangeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opciones = { "Cajas", "Destino" }; // Piezas que puedes cambiar de color
                int seleccion = JOptionPane.showOptionDialog(EasySokobanGUI.this,
                        "¿A qué pieza le deseas cambiar el color?",
                        "Cambiar Color",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (seleccion >= 0) {
                    Color color = JColorChooser.showDialog(EasySokobanGUI.this,
                            "Seleccionar color para " + opciones[seleccion], Color.WHITE); // Selector de color

                    if (color != null) {
                        String colorName = "RGB(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue()
                                + ")"; // Muestra el valor RGB del color
                        if (seleccion == 0) { // Si selecciono cajas
                            colorCajasLabel.setText("Color de cajas: " + colorName);
                            colorCajasLabel.setForeground(color);
                        } else { // Si selecciono destino
                            colorDestinoLabel.setText("Color de destino: " + colorName);
                            colorDestinoLabel.setForeground(color);
                        }
                        refresh();
                    }
                }
            }
        });
    }

    // Acciones de los botones de la ventana
    public void prepareActions() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
    }

    /**
     * Método que cierra el programa.
     */
    public void exit() {
        int cerrar = JOptionPane.showConfirmDialog(this, "¿Vas a cerrar Sokoban?", "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (cerrar == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Método que refresca el tablero.
     */
    public void refresh() {
        panelCenter.repaint();
    }

    // Panel Superior
    private void TopBorder() {
        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(0, 20));
        panelTop.setBorder(BorderFactory.createMatteBorder(0, 15, 0, 0, Color.DARK_GRAY));
        add(panelTop, BorderLayout.NORTH);
    }

    // Panel Izquierdo
    private void LeftBorder() {
        panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(20, 0));
        panelLeft.setBorder(BorderFactory.createMatteBorder(0, 15, 0, 0, Color.DARK_GRAY));
        add(panelLeft, BorderLayout.WEST);
    }

    // Panel Central
    private void prepareElementsBoard() {
        panelCenter = new JPanel();
        panelCenter.setBackground(Color.WHITE);
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(panelCenter, BorderLayout.CENTER);
    }

    // Panel Derecho
    private void RightPanel() {
        panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        // Cajas en destino
        JLabel cajasLabel = new JLabel("Cajas en destino: 3/6");
        panelRight.add(cajasLabel);
        panelRight.add(Box.createRigidArea(new Dimension(0, 10)));

        // Tamaño del mapa
        JLabel mapaLabel = new JLabel("Altura 9 bloques, \nAncho 7 bloques");
        panelRight.add(mapaLabel);
        panelRight.add(Box.createRigidArea(new Dimension(0, 15)));

        // Separador
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        panelRight.add(separator);
        panelRight.add(Box.createRigidArea(new Dimension(0, 15)));

        // Sección Colores
        JLabel coloresTitle = new JLabel("Colores");
        coloresTitle.setFont(new Font(coloresTitle.getFont().getName(), Font.BOLD, 14));
        panelRight.add(coloresTitle);
        panelRight.add(Box.createRigidArea(new Dimension(0, 10)));

        colorCajasLabel = new JLabel("Color de cajas: Blanco");
        panelRight.add(colorCajasLabel);
        panelRight.add(Box.createRigidArea(new Dimension(0, 5)));

        colorDestinoLabel = new JLabel("Color de destino: Rojo");
        panelRight.add(colorDestinoLabel);

        // Segundo Separador
        JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
        separator2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        panelRight.add(separator2);
        panelRight.add(Box.createRigidArea(new Dimension(0, 15)));

        // Adición del botón de Refresh
        JButton refresh = new JButton("Refresh");
        panelRight.add(refresh);
        panelRight.add(Box.createRigidArea(new Dimension(0, 10)));

        add(panelRight, BorderLayout.EAST);
    }

}