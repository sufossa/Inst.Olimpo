package Presentacion;

import BussinessObject.Area;
import BussinessObject.Autor;
import BussinessObject.Editorial;
import BussinessObject.Libros;
import DataSource.conexion;
import TransferObject.AreaDTO;
import TransferObject.AutorDTO;
import TransferObject.EditorialDTO;
import TransferObject.LibroDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class libros extends javax.swing.JInternalFrame {

    private Area area;
    private Editorial editorial; // Agregado: declaración de editorial
    private Autor autor; // Agregado: declaración de autor
    private Libros libros; // Agregado: declaración de libros
    private DefaultTableModel modelo;
    private int ID_AREA;
    private PreparedStatement ps;
    private ResultSet rs;
    private conexion conex;
    private JSpinner spinnerStock; // Declaración del campo en la clase


    public libros() {
        try {
            initComponents();
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
            ui.setNorthPane(null);
            area = new Area();
            editorial = new Editorial(); // Inicialización de editorial
            autor = new Autor(); // Inicialización de autor
            libros = new Libros(); // Inicialización de libros
            modelo = new DefaultTableModel();
            listarAreas();
            listarEditoriales();
            listarAutor();
            listarLibros();
            conex = new conexion();
            spinnerStock = new JSpinner(); // O utiliza el que has creado en el diseño gráfico
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        spinnerStock.setModel(spinnerModel);
 
           cargarAutor(cbxautor, txtautor);
           cargarEditorial(cbxeditorial, txteditorial);
           cargarArea(cbxarea, txtarea);
           cargarBarea(buscarArea);
           cargarBeditorial(buscarEditorial);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al inicializar la ventana de libros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Imprime la traza de la excepción para depuración
        }
    }        
    
    
    private void listarAreas() {
        List<AreaDTO> lista = area.listar();
        modelo = (DefaultTableModel) tarea.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        for (AreaDTO areaDTO : lista) {
            modelo.addRow(new Object[]{areaDTO.getID_AREA(), areaDTO.getNOMBRE()});
        }
        
    }

    private void listar() {
        try {
            modelo = (DefaultTableModel) tarea.getModel();
            modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
            Object[] ob = new Object[2]; // Dos columnas: ID_AREA y NOMBRE
            List<AreaDTO> lista = area.listar();
            for (AreaDTO p : lista) {
                ob[0] = p.getID_AREA();
                ob[1] = p.getNOMBRE();
                modelo.addRow(ob);
            }
            tarea.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al listar áreas: " + e.getMessage());
        }
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tarea.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged(); // Notificar al modelo que los datos han cambiado
    }

    private void limpiarTexto() {
        txtregistroarea.setText("");
    }

  
    int ID_EDITORIAL;



    private void listarEditorial() {
        List<EditorialDTO> lista = editorial.listar();
        modelo = (DefaultTableModel)teditorial.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        for (EditorialDTO editorialDTO : lista) {
            modelo.addRow(new Object[]{editorialDTO.getID_EDITORIAL(), editorialDTO.getNOMBRE()});
        }
    }
    private void limpiarTabla1() {
        modelo = (DefaultTableModel) teditorial.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    private void limpiarTexto1() {
        txtregistroeditorial.setText("");
    }
    
    private void listarEditoriales() {
    try {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID_EDITORIAL");
        modelo.addColumn("NOMBRE");

        List<EditorialDTO> lista = editorial.listar();

        for (EditorialDTO e : lista) {
            modelo.addRow(new Object[]{e.getID_EDITORIAL(), e.getNOMBRE()});
        }

        teditorial.setModel(modelo); // Actualizar la tabla con el nuevo modelo
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al listar editoriales: " + ex.getMessage());
    }
    }
    

    int ID_AUTOR; 
    
    private void listarAutor() {
        List<AutorDTO> lista = autor.listar();
        modelo = (DefaultTableModel)tautor.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        for (AutorDTO autorDTO : lista) {
            modelo.addRow(new Object[]{autorDTO.getID_AUTOR(), autorDTO.getNOMBRE()});
        }
    }
    
     private void limpiarTabla2() {
        modelo = (DefaultTableModel) tautor.getModel();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
    }

    private void limpiarTexto2() {
        txtregistroautor.setText("");
    }
    
    private void listarAutores() {
    try {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID_AUTOR");
        modelo.addColumn("NOMBRE");

        List<AutorDTO> lista = autor.listar();

        for (AutorDTO e : lista) {
            modelo.addRow(new Object[]{e.getID_AUTOR(), e.getNOMBRE()});
        }

        tautor.setModel(modelo); // Actualizar la tabla con el nuevo modelo
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al listar autores: " + ex.getMessage());
    }
    }

  
    int ID_LIBROS; 
    
private void listarLibros() {
    List<LibroDTO> lista = libros.listar();
    modelo = (DefaultTableModel) tlibros.getModel();
    modelo.setRowCount(0); // Limpiar la tabla
    for (LibroDTO libroDTO : lista) {
        modelo.addRow(new Object[]{
            libroDTO.getID_LIBRO(),
            libroDTO.getNOMBRE(),
            libroDTO.getID_AUTOR(),
            libroDTO.getID_EDITORIAL(),
            libroDTO.getID_AREA(),
            libroDTO.getSTOCK(),
            libroDTO.getANOEDICION()
        });
    }
}

private void limpiarTablaLibros() {
    modelo = (DefaultTableModel) tlibros.getModel();
    modelo.getDataVector().removeAllElements();
    modelo.fireTableDataChanged();
}

private void limpiarTextoLibro() {
    txttitulo.setText("");
    cbxautor.setSelectedIndex(-0);
    cbxeditorial.setSelectedIndex(-0);
    cbxarea.setSelectedIndex(-0);
    spinnerstock.setValue(0);
    jdcaedicion.setDate(null);
    txtautor.setText("");
    txteditorial.setText("");
    txtarea.setText("");
}


     
     
  // CARGAR LISTA DE AUTORES//   
     
    private void cargarAutor(JComboBox<String> cbxautor, JTextField txtautor) throws SQLException {
        try {
            cbxautor.removeAllItems(); // Limpiar items previos si es necesario
            cbxautor.addItem("");
            ps = conex.conectar().prepareStatement("SELECT ID, AUTOR FROM autor");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreAutor = rs.getString("AUTOR");
                String idAutor = rs.getString("ID");
                cbxautor.addItem(nombreAutor);
                // Opcional: Asociar el ID del autor como client property del item del combo
                cbxautor.putClientProperty(nombreAutor, idAutor);
            }

            // Agregar ActionListener al JComboBox para manejar la selección
            cbxautor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el nombre seleccionado
                    String nombreSeleccionado = (String) cbxautor.getSelectedItem();
                    // Obtener el ID del autor asociado al nombre seleccionado
                    String idAutorSeleccionado = (String) cbxautor.getClientProperty(nombreSeleccionado);
                    // Mostrar el ID en el JTextField txtautor
                    txtautor.setText(idAutorSeleccionado);
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conex.cerrarConexion();
        }
    }

    
      // CARGAR LISTA DE EDITORIAL//   
     
    private void cargarEditorial(JComboBox<String> cbxeditorial, JTextField txteditorial) throws SQLException {
        try {
            cbxeditorial.removeAllItems(); // Limpiar items previos si es necesario
            cbxeditorial.addItem("");
            ps = conex.conectar().prepareStatement("SELECT ID, EDITORIAL FROM editorial");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreEditorial = rs.getString("EDITORIAL");
                String idEditorial = rs.getString("ID");
                cbxeditorial.addItem(nombreEditorial);
                cbxeditorial.putClientProperty(nombreEditorial, idEditorial);
            }

            // Agregar ActionListener al JComboBox para manejar la selección
            cbxeditorial.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el nombre seleccionado
                    String nombreSeleccionado = (String) cbxeditorial.getSelectedItem();
                    // Obtener el ID del autor asociado al nombre seleccionado
                    String idEditorialSeleccionado = (String) cbxeditorial.getClientProperty(nombreSeleccionado);
                    // Mostrar el ID en el JTextField txtautor
                    txteditorial.setText(idEditorialSeleccionado);
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conex.cerrarConexion();
        }
    }
    
     // CARGAR LISTA DE AREA//   
     
    private void cargarArea(JComboBox<String> cbxarea, JTextField txtarea) throws SQLException {
        try {
            cbxarea.removeAllItems(); // Limpiar items previos si es necesario
            cbxarea.addItem("");
            ps = conex.conectar().prepareStatement("SELECT ID, AREA FROM area");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombreArea = rs.getString("AREA");
                String idArea = rs.getString("ID");
                cbxarea.addItem(nombreArea);
                cbxarea.putClientProperty(nombreArea, idArea);
            }

            // Agregar ActionListener al JComboBox para manejar la selección
            cbxarea.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el nombre seleccionado
                    String nombreSeleccionado = (String) cbxarea.getSelectedItem();
                    // Obtener el ID del autor asociado al nombre seleccionado
                    String idAreaSeleccionado = (String) cbxarea.getClientProperty(nombreSeleccionado);
                    // Mostrar el ID en el JTextField txtautor
                    txtarea.setText(idAreaSeleccionado);
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conex.cerrarConexion();
        }
    }
    
    
    // CARGAR LISTA DE BUSCAR AREA//   
     
private void cargarBarea(JComboBox<String> buscarArea) {
    try {
        buscarArea.removeAllItems();
        buscarArea.addItem(""); // Agregar un ítem vacío por defecto

        String sql = "SELECT DISTINCT l.ID_AREA, a.AREA FROM libro l JOIN area a ON l.ID_AREA = a.ID";
        ps = conex.conectar().prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            int idArea = rs.getInt("ID_AREA");
            String nombreArea = rs.getString("AREA");
            buscarArea.addItem(nombreArea);
            buscarArea.putClientProperty(nombreArea, idArea);
        }

        // Agregar ActionListener al JComboBox para manejar la selección
        buscarArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) buscarArea.getSelectedItem();

                if (nombreSeleccionado.isEmpty()) {
                    limpiarTablaLibros(); // Limpiar la tabla si se selecciona el ítem vacío
                    listarLibros(); // Listar todos los libros si se selecciona el ítem vacío
                } else {
                    int idAreaSeleccionado = (int) buscarArea.getClientProperty(nombreSeleccionado);

                    limpiarTablaLibros(); // Limpiar la tabla de libros antes de mostrar los resultados filtrados
                    DefaultTableModel modelo = (DefaultTableModel) tlibros.getModel();
                    Libros libros = new Libros();
                    for (LibroDTO libro : libros.buscarPorArea(idAreaSeleccionado)) {
                        modelo.addRow(new Object[]{
                                libro.getID_LIBRO(),
                                libro.getNOMBRE(),
                                libro.getID_AUTOR(),
                                libro.getID_EDITORIAL(),
                                libro.getID_AREA(),
                                libro.getSTOCK(),
                                libro.getANOEDICION()
                        });
                    }
                    tlibros.setModel(modelo); // Establecer el modelo actualizado en la tabla
                }
            }
        });

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conex.cerrarConexion();
    }
}
 // CARGAR LISTA DE BUSCAR EDITORIAL//
private void cargarBeditorial(JComboBox<String> buscarEditorial) {
    try {
        buscarEditorial.removeAllItems();
        buscarEditorial.addItem(""); // Agregar un ítem vacío por defecto

        // Consulta SQL para obtener ID_EDITORIAL y su nombre asociado desde la tabla libro
        String sql = "SELECT DISTINCT l.ID_EDITORIAL, e.EDITORIAL FROM libro l JOIN editorial e ON l.ID_EDITORIAL = e.ID";
        ps = conex.conectar().prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            int idEditorial = rs.getInt("ID_EDITORIAL");
            String nombreEditorial = rs.getString("EDITORIAL");
            buscarEditorial.addItem(nombreEditorial);
            buscarEditorial.putClientProperty(nombreEditorial, idEditorial);
        }

        // Agregar ActionListener al JComboBox para manejar la selección
        buscarEditorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) buscarEditorial.getSelectedItem();

                if (nombreSeleccionado.isEmpty()) {
                    limpiarTablaLibros(); // Limpiar la tabla si se selecciona el ítem vacío
                    listarLibros(); // Listar todos los libros si se selecciona el ítem vacío
                } else {
                    int idEditorialSeleccionado = (int) buscarEditorial.getClientProperty(nombreSeleccionado);

                    limpiarTablaLibros(); // Limpiar la tabla de libros antes de mostrar los resultados filtrados
                    DefaultTableModel modelo = (DefaultTableModel) tlibros.getModel();
                    Libros libros = new Libros();
                    for (LibroDTO libro : libros.buscarPorEditorial(idEditorialSeleccionado)) {
                        modelo.addRow(new Object[]{
                                libro.getID_LIBRO(),
                                libro.getNOMBRE(),
                                libro.getID_AUTOR(),
                                libro.getID_EDITORIAL(),
                                libro.getID_AREA(),
                                libro.getSTOCK(),
                                libro.getANOEDICION()
                        });
                    }
                    tlibros.setModel(modelo); // Establecer el modelo actualizado en la tabla
                }
            }
        });

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conex.cerrarConexion();
    }
}

//QUERY DE LOS ID'S
    public String obtenerNombreAutor(int idAutor) {
    String nombre = "";
    String sql = "SELECT AUTOR FROM autor WHERE ID = ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setInt(1, idAutor);
        rs = ps.executeQuery();
        if (rs.next()) {
            nombre = rs.getString("AUTOR");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conex.cerrarConexion();
    }
    return nombre;
}

public String obtenerNombreEditorial(int idEditorial) {
    String nombre = "";
    String sql = "SELECT EDITORIAL FROM editorial WHERE ID = ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setInt(1, idEditorial);
        rs = ps.executeQuery();
        if (rs.next()) {
            nombre = rs.getString("EDITORIAL");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conex.cerrarConexion();
    }
    return nombre;
}

public String obtenerNombreArea(int idArea) {
    String nombre = "";
    String sql = "SELECT AREA FROM area WHERE ID = ?";
    try {
        ps = conex.conectar().prepareStatement(sql);
        ps.setInt(1, idArea);
        rs = ps.executeQuery();
        if (rs.next()) {
            nombre = rs.getString("AREA");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conex.cerrarConexion();
    }
    return nombre;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        controllibros = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtautor = new javax.swing.JTextField();
        txteditorial = new javax.swing.JTextField();
        txtarea = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxautor = new javax.swing.JComboBox<>();
        cbxeditorial = new javax.swing.JComboBox<>();
        cbxarea = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spinnerstock = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jdcaedicion = new com.toedter.calendar.JDateChooser();
        btnguardar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlibros = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        buscarTITULO = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        buscarArea = new javax.swing.JComboBox<>();
        buscarEditorial = new javax.swing.JComboBox<>();
        controlautores = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtregistroautor = new javax.swing.JTextField();
        btnguardar1 = new javax.swing.JButton();
        btneditar1 = new javax.swing.JButton();
        btnlimpiar1 = new javax.swing.JButton();
        btneliminar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tautor = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        buscarNOMBREAUTOR = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        controleditoriales = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtregistroeditorial = new javax.swing.JTextField();
        btnguardar2 = new javax.swing.JButton();
        btneditar2 = new javax.swing.JButton();
        btnlimpiar2 = new javax.swing.JButton();
        btneliminar2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        teditorial = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        buscarNOMBREEDITORIAL = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        controlareas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtregistroarea = new javax.swing.JTextField();
        btnguardar3 = new javax.swing.JButton();
        btneditar3 = new javax.swing.JButton();
        btnlimpiar3 = new javax.swing.JButton();
        btneliminar3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tarea = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        buscarNOMBREAREA = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1250, 630));

        controllibros.setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Libros ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Título");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buscar");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Buscar");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Buscar");

        txtautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtautorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("ID_AUTOR");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("ID_EDITORIAL");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ID_ÁREA");

        cbxautor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxautorMousePressed(evt);
            }
        });
        cbxautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxautorActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vaso.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vaso.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vaso.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Año Edición");

        spinnerstock.setToolTipText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Stock");

        btnguardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 51, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneditar.setForeground(new java.awt.Color(0, 153, 0));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(153, 0, 153));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(204, 0, 0));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtarea, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(65, 65, 65))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txttitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxautor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxeditorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txteditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spinnerstock, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdcaedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxautor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txteditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcaedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tlibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "ID_AUTOR", "ID_EDITORIAL", "ID_AREA", "STOCK", "AÑO_EDICION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tlibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tlibrosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tlibros);

        jLabel20.setText("🔎");

        buscarTITULO.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        buscarTITULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTITULOActionPerformed(evt);
            }
        });
        buscarTITULO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTITULOKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 204));
        jLabel21.setText("(Buscar por Nombre)");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 204));
        jLabel22.setText("(Buscar por Área)");

        jLabel23.setText("🔎");

        jLabel24.setText("🔎");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 204));
        jLabel25.setText("(Buscar por Editorial)");

        buscarArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        buscarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAreaActionPerformed(evt);
            }
        });

        buscarEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout controllibrosLayout = new javax.swing.GroupLayout(controllibros);
        controllibros.setLayout(controllibrosLayout);
        controllibrosLayout.setHorizontalGroup(
            controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllibrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controllibrosLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(controllibrosLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(controllibrosLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(105, 105, 105)))
                        .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controllibrosLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel25))
                            .addComponent(buscarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(controllibrosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        controllibrosLayout.setVerticalGroup(
            controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllibrosLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controllibrosLayout.createSequentialGroup()
                        .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(controllibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", controllibros);

        controlautores.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Registro de Autor ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nombre");

        btnguardar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardar1.setForeground(new java.awt.Color(0, 51, 255));
        btnguardar1.setText("Guardar");
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });

        btneditar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneditar1.setForeground(new java.awt.Color(0, 153, 0));
        btneditar1.setText("Editar");
        btneditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar1ActionPerformed(evt);
            }
        });

        btnlimpiar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlimpiar1.setForeground(new java.awt.Color(153, 0, 153));
        btnlimpiar1.setText("Limpiar");
        btnlimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar1ActionPerformed(evt);
            }
        });

        btneliminar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneliminar1.setForeground(new java.awt.Color(204, 0, 0));
        btneliminar1.setText("Eliminar");
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btneditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(149, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtregistroautor, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(122, 122, 122))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtregistroautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btneditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnlimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        tautor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tautor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tautorMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tautor);

        jLabel26.setText("🔎");

        buscarNOMBREAUTOR.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        buscarNOMBREAUTOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNOMBREAUTORActionPerformed(evt);
            }
        });
        buscarNOMBREAUTOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarNOMBREAUTORKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 204));
        jLabel27.setText("(Buscar por Nombre)");

        javax.swing.GroupLayout controlautoresLayout = new javax.swing.GroupLayout(controlautores);
        controlautores.setLayout(controlautoresLayout);
        controlautoresLayout.setHorizontalGroup(
            controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlautoresLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlautoresLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarNOMBREAUTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(controlautoresLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel27)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        controlautoresLayout.setVerticalGroup(
            controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlautoresLayout.createSequentialGroup()
                .addGroup(controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlautoresLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(controlautoresLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(controlautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarNOMBREAUTOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Autores", controlautores);

        controleditoriales.setBackground(new java.awt.Color(0, 153, 153));
        controleditoriales.setForeground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Registro de Editorial ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Nombre");

        btnguardar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardar2.setForeground(new java.awt.Color(0, 51, 255));
        btnguardar2.setText("Guardar");
        btnguardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar2ActionPerformed(evt);
            }
        });

        btneditar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneditar2.setForeground(new java.awt.Color(0, 153, 0));
        btneditar2.setText("Editar");
        btneditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar2ActionPerformed(evt);
            }
        });

        btnlimpiar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlimpiar2.setForeground(new java.awt.Color(153, 0, 153));
        btnlimpiar2.setText("Limpiar");
        btnlimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar2ActionPerformed(evt);
            }
        });

        btneliminar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneliminar2.setForeground(new java.awt.Color(204, 0, 0));
        btneliminar2.setText("Eliminar");
        btneliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btneditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(149, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtregistroeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(122, 122, 122))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtregistroeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btneditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnlimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        teditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        teditorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                teditorialMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(teditorial);

        jLabel28.setText("🔎");

        buscarNOMBREEDITORIAL.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        buscarNOMBREEDITORIAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNOMBREEDITORIALActionPerformed(evt);
            }
        });
        buscarNOMBREEDITORIAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarNOMBREEDITORIALKeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 204));
        jLabel29.setText("(Buscar por Nombre)");

        javax.swing.GroupLayout controleditorialesLayout = new javax.swing.GroupLayout(controleditoriales);
        controleditoriales.setLayout(controleditorialesLayout);
        controleditorialesLayout.setHorizontalGroup(
            controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controleditorialesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controleditorialesLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarNOMBREEDITORIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(controleditorialesLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel29)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        controleditorialesLayout.setVerticalGroup(
            controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controleditorialesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controleditorialesLayout.createSequentialGroup()
                        .addGroup(controleditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarNOMBREEDITORIAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Editoriales", controleditoriales);

        controlareas.setBackground(new java.awt.Color(0, 153, 153));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Registro de Área");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Nombre");

        txtregistroarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregistroareaActionPerformed(evt);
            }
        });

        btnguardar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardar3.setForeground(new java.awt.Color(0, 51, 255));
        btnguardar3.setText("Guardar");
        btnguardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar3ActionPerformed(evt);
            }
        });

        btneditar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneditar3.setForeground(new java.awt.Color(0, 153, 0));
        btneditar3.setText("Editar");
        btneditar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar3ActionPerformed(evt);
            }
        });

        btnlimpiar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlimpiar3.setForeground(new java.awt.Color(153, 0, 153));
        btnlimpiar3.setText("Limpiar");
        btnlimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar3ActionPerformed(evt);
            }
        });

        btneliminar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btneliminar3.setForeground(new java.awt.Color(204, 0, 0));
        btneliminar3.setText("Eliminar");
        btneliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btneditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(149, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtregistroarea, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(122, 122, 122))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtregistroarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btneditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnlimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        tarea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tareaMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tarea);

        jLabel30.setText("🔎");

        buscarNOMBREAREA.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        buscarNOMBREAREA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNOMBREAREAActionPerformed(evt);
            }
        });
        buscarNOMBREAREA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarNOMBREAREAKeyReleased(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 204));
        jLabel31.setText("(Buscar por Nombre)");

        javax.swing.GroupLayout controlareasLayout = new javax.swing.GroupLayout(controlareas);
        controlareas.setLayout(controlareasLayout);
        controlareasLayout.setHorizontalGroup(
            controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlareasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlareasLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarNOMBREAREA, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(controlareasLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel31)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        controlareasLayout.setVerticalGroup(
            controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlareasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlareasLayout.createSequentialGroup()
                        .addGroup(controlareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarNOMBREAREA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Áreas", controlareas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    // Obtener los valores de los campos y controles
    String nombreLibro = txttitulo.getText().trim();
    int idAutor = Integer.parseInt(txtautor.getText().trim());
    int idEditorial = Integer.parseInt(txteditorial.getText().trim());
    int idArea = Integer.parseInt(txtarea.getText().trim());
int stock = (int) spinnerstock.getValue();  // Obtener el valor del spinner como un entero
String stockStr = String.valueOf(stock);   

    // Obtener la fecha de edición
    Date fechaEdicionDate = jdcaedicion.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    String fechaEdicion = dateFormat.format(fechaEdicionDate);

    // Validar que los campos no estén vacíos
    if (nombreLibro.isEmpty() || fechaEdicion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios: Nombre, Stock y Fecha de Edición");
    } else {
        try {
            // Preparar la consulta SQL para insertar el nuevo libro
            String query = "INSERT INTO libro (NOMBRE, ID_AUTOR, ID_EDITORIAL, ID_AREA, STOCK, FECHA_EDICION) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conex.conectar().prepareStatement(query);
            ps.setString(1, nombreLibro);
            ps.setInt(2, idAutor);
            ps.setInt(3, idEditorial);
            ps.setInt(4, idArea);
            ps.setString(5, stockStr); // Insertar el valor del stock
            ps.setString(6, fechaEdicion);

            // Ejecutar la consulta
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                System.out.println("Valor del Spinner Stock: " + spinnerStock.getValue());

                JOptionPane.showMessageDialog(this, "Libro guardado exitosamente en la base de datos");
                // Limpiar los campos después de guardar
                limpiarTextoLibro();
                // Refrescar la tabla de libros si es necesario
                // listarLibros(); // Descomenta si necesitas actualizar una tabla después de guardar
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el libro en la base de datos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el libro en la base de datos: " + ex.getMessage());
        } finally {
            // Cerrar la conexión después de usarla
            conex.cerrarConexion();
        }
    }
  
    listarLibros();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
              String mensaje;
        String nombreAutor = txtregistroautor.getText().trim();
        if (nombreAutor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para guardar el Autor");
        } else {
            mensaje = autor.agregar(nombreAutor);
            JOptionPane.showMessageDialog(this, mensaje);
            limpiarTabla2();
            listarAutor();
            limpiarTexto2();
        }
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void btnguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar2ActionPerformed
           String mensaje;
        String nombreEditorial = txtregistroeditorial.getText().trim();
        if (nombreEditorial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la editorial");
        } else {
            mensaje = editorial.agregar(nombreEditorial);
            JOptionPane.showMessageDialog(this, mensaje);
            limpiarTabla1();
            listarEditoriales();
            limpiarTexto1();
        }
    }//GEN-LAST:event_btnguardar2ActionPerformed

    private void btnguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar3ActionPerformed
        String nombre = txtregistroarea.getText();
      

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String mensaje = area.agregar(nombre);
            limpiarTabla();
            listar();
            limpiarTexto();
            
        }
        
    }//GEN-LAST:event_btnguardar3ActionPerformed

    private void buscarTITULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTITULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarTITULOActionPerformed

    private void buscarTITULOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTITULOKeyReleased
       if (!buscarTITULO.getText().isEmpty()) {
        limpiarTablaLibros();
        DefaultTableModel modelo = (DefaultTableModel) tlibros.getModel();
        Libros libros = new Libros();
        for (LibroDTO e : libros.buscarPorNombre(buscarTITULO.getText())) {
            Object[] ob = new Object[7]; // Ajustar el tamaño del array a 7
            ob[0] = e.getID_LIBRO();
            ob[1] = e.getNOMBRE();
            ob[2] = e.getID_AUTOR();
            ob[3] = e.getID_EDITORIAL();
            ob[4] = e.getID_AREA();
            ob[5] = e.getSTOCK();
            ob[6] = e.getANOEDICION();
            modelo.addRow(ob);
        }
        tlibros.setModel(modelo);
    } else {
        limpiarTablaLibros();
        listarLibros(); // Llamar al método para listar todos los libros si el campo de búsqueda está vacío
    }
    }//GEN-LAST:event_buscarTITULOKeyReleased

    private void buscarNOMBREAUTORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNOMBREAUTORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarNOMBREAUTORActionPerformed

    private void buscarNOMBREAUTORKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarNOMBREAUTORKeyReleased
       if (!buscarNOMBREAUTOR.getText().isEmpty()) {
        limpiarTabla2();
        DefaultTableModel modelo = (DefaultTableModel) tautor.getModel();
        Object[] ob = new Object[2];    
        Autor autor = new Autor();
        for (AutorDTO e : autor.buscarPorNombre(buscarNOMBREAUTOR.getText())) {
            ob[0] = e.getID_AUTOR();
            ob[1] = e.getNOMBRE();
            modelo.addRow(ob);
        }
        tautor.setModel(modelo);
    } else {
        limpiarTabla2();
        listarAutor(); // Asumiendo que listarEditoriales() lista todas las editoriales si el campo de búsqueda está vacío
    }

        
        
        
        
    }//GEN-LAST:event_buscarNOMBREAUTORKeyReleased

    private void buscarNOMBREEDITORIALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNOMBREEDITORIALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarNOMBREEDITORIALActionPerformed

    private void buscarNOMBREEDITORIALKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarNOMBREEDITORIALKeyReleased
  if (!buscarNOMBREEDITORIAL.getText().isEmpty()) {
        limpiarTabla1();
        DefaultTableModel modelo = (DefaultTableModel) teditorial.getModel();
        Object[] ob = new Object[2];
        Editorial editorial = new Editorial();
        for (EditorialDTO e : editorial.buscarPorNombre(buscarNOMBREEDITORIAL.getText())) {
            ob[0] = e.getID_EDITORIAL();
            ob[1] = e.getNOMBRE();
            modelo.addRow(ob);
        }
        teditorial.setModel(modelo);
    } else {
        limpiarTabla1();
        listarEditoriales(); // Asumiendo que listarEditoriales() lista todas las editoriales si el campo de búsqueda está vacío
    }

    }//GEN-LAST:event_buscarNOMBREEDITORIALKeyReleased

    private void buscarNOMBREAREAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNOMBREAREAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarNOMBREAREAActionPerformed

    private void buscarNOMBREAREAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarNOMBREAREAKeyReleased
        if (!buscarNOMBREAREA.getText().isEmpty()) {
       limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) tarea.getModel();
        Object[] ob = new Object[2];
        Area area = new Area();
        for (AreaDTO a : area.buscarPorNOMBRE(buscarNOMBREAREA.getText())) {
            ob[0] = a.getID_AREA();
            ob[1] = a.getNOMBRE();
            modelo.addRow(ob);
        }
        tarea.setModel(modelo);
    } else {
        limpiarTabla();
        listarAreas();
        }
    }//GEN-LAST:event_buscarNOMBREAREAKeyReleased

    private void txtregistroareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregistroareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregistroareaActionPerformed

    private void btnlimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar3ActionPerformed
   limpiarTexto();
   tarea.clearSelection();
    }//GEN-LAST:event_btnlimpiar3ActionPerformed
//AQUI ES PARA CUANDO SE SELECIONA SE MUESTRE EN EL CUADRO DE TEXTO
    private void tareaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tareaMouseReleased
  int fila = tarea.getSelectedRow();
        if (evt.getClickCount() == 1) {
            if (fila < 0) {
                JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
            } else {
                ID_AREA = Integer.parseInt(tarea.getValueAt(fila, 0).toString());
                txtregistroarea.setText(tarea.getValueAt(fila, 1).toString());
             
            }
        }
        try {
            if (evt.getClickCount() == 2) {
                if (fila < 0) {
                    JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
                } else {
                    this.dispose();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tareaMouseReleased

    private void btneliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar3ActionPerformed
     String mensaje = "";
    int fila = tarea.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
    } else {
        // Obtén el ID_AREA de la fila seleccionada
        int ID_AREA = Integer.parseInt(tarea.getValueAt(fila, 0).toString());  // Suponiendo que la columna 0 tiene el ID_AREA

        // Llama al método eliminar del área
        mensaje = area.eliminar(ID_AREA);
        
        // Actualiza la tabla y limpia los campos
        limpiarTabla();
        listar();
        btnlimpiar3ActionPerformed(evt);  // Limpia los campos, si es necesario
    }
    }//GEN-LAST:event_btneliminar3ActionPerformed

    private void btneditar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar3ActionPerformed
            String mensaje = "";
        int fila = tarea.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Fila");
        } else {
            mensaje = area.actualizar(ID_AREA, txtregistroarea.getText());
        }
        limpiarTabla();
        listar();
        btnlimpiar3ActionPerformed(evt);
    }//GEN-LAST:event_btneditar3ActionPerformed

    private void btneliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar2ActionPerformed
   String mensaje = "";
    int fila = teditorial.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
    } else {
        // Obtén el ID_AREA de la fila seleccionada
        int ID_EDITORIAL = Integer.parseInt(teditorial.getValueAt(fila, 0).toString());  // Suponiendo que la columna 0 tiene el ID_AREA

        // Llama al método eliminar del área
        mensaje = editorial.eliminar(ID_EDITORIAL);
        
        // Actualiza la tabla y limpia los campos
       limpiarTabla1();
       listarEditoriales();
       limpiarTexto1();
        btnlimpiar2ActionPerformed(evt);
    }// Limpia los campos, si es necesario
    }//GEN-LAST:event_btneliminar2ActionPerformed
    
    private void btneditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar2ActionPerformed
           String mensaje = "";
        int fila = teditorial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Fila");
        } else {
            mensaje = editorial.actualizar(ID_EDITORIAL, txtregistroeditorial.getText());
        }
       limpiarTabla1();
       listarEditoriales();
       limpiarTexto1();
        btnlimpiar2ActionPerformed(evt);
    }//GEN-LAST:event_btneditar2ActionPerformed

    private void btnlimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar2ActionPerformed
          limpiarTexto1();
   teditorial.clearSelection();
    }//GEN-LAST:event_btnlimpiar2ActionPerformed

    private void teditorialMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teditorialMouseReleased
     int fila = teditorial.getSelectedRow();
    if (evt.getClickCount() == 1) {
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
        } else {
            ID_EDITORIAL = Integer.parseInt(teditorial.getValueAt(fila, 0).toString());
            txtregistroeditorial.setText(teditorial.getValueAt(fila, 1).toString());
        }
    }
    try {
        if (evt.getClickCount() == 2) {
            if (fila < 0) {
                JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
            } else {
                this.dispose();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_teditorialMouseReleased

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed
      String mensaje = "";
    int fila = tautor.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
    } else {
        // Obtén el ID_AREA de la fila seleccionada
        int ID_EDITORIAL = Integer.parseInt(tautor.getValueAt(fila, 0).toString());  // Suponiendo que la columna 0 tiene el ID_AREA

        // Llama al método eliminar del área
        mensaje = autor.eliminar(ID_EDITORIAL);
        
        // Actualiza la tabla y limpia los campos
       limpiarTabla2();
            listarAutor();
            limpiarTexto2();
        btnlimpiar2ActionPerformed(evt);
    }// Limpia los campos, si es necesario
    }//GEN-LAST:event_btneliminar1ActionPerformed

    private void btnlimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar1ActionPerformed
              limpiarTexto2();
   tautor.clearSelection();
    }//GEN-LAST:event_btnlimpiar1ActionPerformed

    private void tautorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tautorMouseReleased
       
     int fila = tautor.getSelectedRow();
    if (evt.getClickCount() == 1) {
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
        } else {
            ID_AUTOR = Integer.parseInt(tautor.getValueAt(fila, 0).toString());
            txtregistroautor.setText(tautor.getValueAt(fila, 1).toString());
        }
    }
    try {
        if (evt.getClickCount() == 2) {
            if (fila < 0) {
                JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
            } else {
                this.dispose();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_tautorMouseReleased

    private void btneditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar1ActionPerformed
        String mensaje = "";
        int fila = tautor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Fila");
        } else {
            mensaje = autor.actualizar(ID_AUTOR,txtregistroautor.getText());
        }
       limpiarTabla2();
       listarAutor();
       limpiarTexto2();
        btnlimpiar3ActionPerformed(evt);
    }//GEN-LAST:event_btneditar1ActionPerformed

    private void txtautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtautorActionPerformed

    }//GEN-LAST:event_txtautorActionPerformed

    private void cbxautorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxautorMousePressed

    }//GEN-LAST:event_cbxautorMousePressed

    private void cbxautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxautorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxautorActionPerformed

    private void buscarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAreaActionPerformed
String idAreaSeleccionado = (String) buscarArea.getSelectedItem(); // Obtener el ID del área seleccionado
    
    if (idAreaSeleccionado != null && !idAreaSeleccionado.isEmpty()) {
        try {
            int idArea = Integer.parseInt(idAreaSeleccionado); // Convertir el ID del área a entero
            
            // Limpiar la tabla de libros
            limpiarTablaLibros();
            
            // Obtener la lista de libros por el ID_AREA
            Libros libros = new Libros();
            List<LibroDTO> listaLibros = libros.buscarPorArea(idArea);
            
            // Obtener el modelo de la tabla de libros
            DefaultTableModel modelo = (DefaultTableModel) tlibros.getModel();
            
            // Agregar los libros al modelo de la tabla
            for (LibroDTO libro : listaLibros) {
                modelo.addRow(new Object[]{
                    libro.getID_LIBRO(),
                    libro.getNOMBRE(),
                    libro.getID_AUTOR(),
                    libro.getID_EDITORIAL(),
                    libro.getID_AREA(),
                    libro.getSTOCK(),
                    libro.getANOEDICION()
                });
            }
            tlibros.setModel(modelo);
            
        } catch (NumberFormatException ex) {
           // JOptionPane.showMessageDialog(this, "El ID de área debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Si no se ha seleccionado ningún área, limpiar la tabla y listar todos los libros
        limpiarTablaLibros();
        listarLibros();
    }
    }//GEN-LAST:event_buscarAreaActionPerformed

    private void tlibrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlibrosMouseReleased
    int fila = tlibros.getSelectedRow();
    if (evt.getClickCount() == 1) {
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
        } else {
            ID_LIBROS = Integer.parseInt(tlibros.getValueAt(fila, 0).toString());
            txttitulo.setText(tlibros.getValueAt(fila, 1).toString());
            int idAutor = Integer.parseInt(tlibros.getValueAt(fila, 2).toString());
            int idEditorial = Integer.parseInt(tlibros.getValueAt(fila, 3).toString());
            int idArea = Integer.parseInt(tlibros.getValueAt(fila, 4).toString());
            cbxautor.setSelectedItem(obtenerNombreAutor(idAutor));
            cbxeditorial.setSelectedItem(obtenerNombreEditorial(idEditorial));
            cbxarea.setSelectedItem(obtenerNombreArea(idArea));
            spinnerstock.setValue(Integer.parseInt(tlibros.getValueAt(fila, 5).toString()));
            

            // Validación y asignación de jdcaedicion
            try {
                jdcaedicion.setDate(new SimpleDateFormat("yyyy").parse(tlibros.getValueAt(fila, 6).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "La fecha de edición no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    try {
        if (evt.getClickCount() == 2) {
            if (fila < 0) {
                JOptionPane.showMessageDialog(this, "No hay filas para seleccionar");
            } else {
                this.dispose();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    
    }
    }//GEN-LAST:event_tlibrosMouseReleased

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
   limpiarTextoLibro();
   tlibros.clearSelection();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
   // Obtener los valores de los campos y controles
    String nombreLibro = txttitulo.getText().trim();
    int idAutor = Integer.parseInt(txtautor.getText().trim());
    int idEditorial = Integer.parseInt(txteditorial.getText().trim());
    int idArea = Integer.parseInt(txtarea.getText().trim());
    int stock = (int) spinnerstock.getValue();
    String stockStr = String.valueOf(stock);

    // Obtener la fecha de edición
    Date fechaEdicionDate = jdcaedicion.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    String fechaEdicion = dateFormat.format(fechaEdicionDate);

    // Validar que los campos no estén vacíos
    if (nombreLibro.isEmpty() || fechaEdicion.isEmpty() || txtautor.getText().trim().isEmpty()
            || txteditorial.getText().trim().isEmpty() || txtarea.getText().trim().isEmpty() || stockStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios: Nombre, Autor, Editorial, Área, Stock y Fecha de Edición");
    } else {
        try {
            // Preparar la consulta SQL para actualizar el libro
            String query = "UPDATE libro SET NOMBRE=?, ID_AUTOR=?, ID_EDITORIAL=?, ID_AREA=?, STOCK=?, FECHA_EDICION=? WHERE ID=?";
            PreparedStatement ps = conex.conectar().prepareStatement(query);
            ps.setString(1, nombreLibro);
            ps.setInt(2, idAutor);
            ps.setInt(3, idEditorial);
            ps.setInt(4, idArea);
            ps.setString(5, stockStr);
            ps.setString(6, fechaEdicion);

            // Obtener el ID del libro seleccionado para la actualización
            int idLibro = obtenerIdLibroSeleccionado(); // Debes implementar esta función para obtener el ID del libro seleccionado

            ps.setInt(7, idLibro);

            // Ejecutar la consulta
            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(this, "Libro actualizado exitosamente en la base de datos");

                // Limpiar los campos después de la actualización
                limpiarTextoLibro();
                btnlimpiar1ActionPerformed(evt);

                // Actualizar la tabla de libros
                limpiarTablaLibros();
                listarLibros();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el libro en la base de datos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el libro en la base de datos: " + ex.getMessage());
        } finally {
            // Cerrar la conexión después de usarla
            conex.cerrarConexion();
        }
    }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       String mensaje = "";
    int fila = tlibros.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
    } else {
        // Obtén el ID_AREA de la fila seleccionada
        int ID_LIBRO = Integer.parseInt(tlibros.getValueAt(fila, 0).toString());  // Suponiendo que la columna 0 tiene el ID_AREA

        // Llama al método eliminar del área
        mensaje = libros.eliminar(ID_LIBRO);
        
        // Actualiza la tabla y limpia los campos
       limpiarTablaLibros();
        listarLibros();
            limpiarTextoLibro();
            
        
        btnlimpiarActionPerformed(evt);
    }// Limpia los campos, si es necesario
    }//GEN-LAST:event_btneliminarActionPerformed
private int obtenerIdLibroSeleccionado() {
    // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = tlibros.getSelectedRow();

    // Verificar si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener el valor de la columna ID (suponiendo que es la primera columna)
        return (int) tlibros.getValueAt(filaSeleccionada, 0); // Ajusta el índice según la columna ID
    } else {
        // Si no hay fila seleccionada, mostrar un mensaje de error o manejar la situación según tu flujo
        JOptionPane.showMessageDialog(this, "Seleccione un libro para editar");
        return -1; // O devuelve un valor que indique que no se seleccionó ningún libro
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneditar1;
    private javax.swing.JButton btneditar2;
    private javax.swing.JButton btneditar3;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btneliminar2;
    private javax.swing.JButton btneliminar3;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar1;
    private javax.swing.JButton btnguardar2;
    private javax.swing.JButton btnguardar3;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnlimpiar1;
    private javax.swing.JButton btnlimpiar2;
    private javax.swing.JButton btnlimpiar3;
    private javax.swing.JComboBox<String> buscarArea;
    private javax.swing.JComboBox<String> buscarEditorial;
    private javax.swing.JTextField buscarNOMBREAREA;
    private javax.swing.JTextField buscarNOMBREAUTOR;
    private javax.swing.JTextField buscarNOMBREEDITORIAL;
    private javax.swing.JTextField buscarTITULO;
    private javax.swing.JComboBox<String> cbxarea;
    private javax.swing.JComboBox<String> cbxautor;
    private javax.swing.JComboBox<String> cbxeditorial;
    private javax.swing.JPanel controlareas;
    private javax.swing.JPanel controlautores;
    private javax.swing.JPanel controleditoriales;
    private javax.swing.JPanel controllibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcaedicion;
    private javax.swing.JSpinner spinnerstock;
    private javax.swing.JTable tarea;
    private javax.swing.JTable tautor;
    private javax.swing.JTable teditorial;
    private javax.swing.JTable tlibros;
    private javax.swing.JTextField txtarea;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txteditorial;
    private javax.swing.JTextField txtregistroarea;
    private javax.swing.JTextField txtregistroautor;
    private javax.swing.JTextField txtregistroeditorial;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables


}