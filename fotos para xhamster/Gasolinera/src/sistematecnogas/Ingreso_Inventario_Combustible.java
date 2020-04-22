/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematecnogas;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import servicios.conexion;

/**
 *
 * @author Wilfredo Serrano
 */
public class Ingreso_Inventario_Combustible extends javax.swing.JFrame {

   String oll="";
   
     conexion cc = new conexion();
     Connection cn = cc.conexion();
        
    
    //valores_conection
     public void limitar(){
    
    RestrictedTextField limitar1 =new RestrictedTextField(caja_recibido_diesel);
    limitar1.setLimit(18);
    RestrictedTextField limitar2 =new RestrictedTextField(caja_invinicial_diesel);
    limitar2.setLimit(18);
    RestrictedTextField limitar3 =new RestrictedTextField(caja_despa_diesel);
    limitar3.setLimit(18);
    RestrictedTextField limitar4 =new RestrictedTextField(caja_invfinal_diesel);
    limitar4.setLimit(18);
    RestrictedTextField limitar5 =new RestrictedTextField(caja_litfaltantes_diesel);
    limitar5.setLimit(18);
    
    }
    public void Valida(){
        if (caja_recibido_diesel.getText().isEmpty()) {
            error11.setText("*");
        } else {
            error1.setText("");
        }
        if (caja_invinicial_diesel.getText().isEmpty()) {
            error12.setText("*");
        } else {
            error12.setText("");
        }
        
        if (caja_despa_diesel.getText().isEmpty()) {
            error13.setText("*");
        } else {
            error13.setText("");
        }
        if (caja_invfinal_diesel.getText().isEmpty()) {
            error14.setText("*");
        } else {
            error14.setText("");
        }
        if (caja_litfaltantes_diesel.getText().isEmpty()) {
            error15.setText("*");
        } else {
            error15.setText("");
        }
    } 
     void mostrartipoproducto(){
       String sql="SELECT * FROM `tipo_combustible`";
        try {
            Statement st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                iidtipocomb.addItem(rs.getString("id_tipo_combustible"));
            }
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
   
    public Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    void cargar(String valor){
    /*String mostrar="SELECT * FROM `categoria` WHERE '%"+valor+"%'";*/
    String mostrar="SELECT `id_inventario`, `recibido`, `recibido_plg3`, `inventario_inicial`, `inventario_inicial_plg3`, `litros_faltantes`, `litros_faltantes_plg3`, `despacho`, `despacho_plg3`, `inventario_final`, `inventario_final_plg3`, `id_usuario`, `id_tipo_combustible` FROM `inventario_combustible` WHERE `id_inventario` LIKE '%"+valor+"%'";
    String []titulos={"Id de inventario","Recibido","Pulgadas cubicas","Inventario inicial","Pulgas cubicas iniciales","Litros faltantes","Litros faltantes cubicas","Despacho","Inventario final","Inventario final cubico","Inventario final cubica","ID tabla","ID combustible"};
    String []Registros=new String[14];
    DefaultTableModel model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              java.sql.ResultSet rs = st.executeQuery(mostrar);
              
              while(rs.next())
              {
                  Registros[0]= rs.getString("id_inventario");
                  Registros[1]= rs.getString("recibido");
                  Registros[2]= rs.getString("recibido_plg3");
                  Registros[3]= rs.getString("inventario_inicial");
                  Registros[4]= rs.getString("inventario_inicial_plg3");
                  Registros[5]= rs.getString("litros_faltantes");
                  Registros[6]= rs.getString("litros_faltantes_plg3");
                  Registros[7]= rs.getString("despacho");
                  Registros[8]= rs.getString("despacho_plg3");
                  Registros[9]= rs.getString("inventario_final");
                  Registros[10]= rs.getString("inventario_final_plg3");
                  Registros[11]= rs.getString("id_usuario");
                  Registros[12]= rs.getString("id_tipo_combustible");
                  
                           
                  model.addRow(Registros);
              }
              tabla_inventario.setModel(model);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }
    
   
    
    public void limpiarcajas1(){
    //limpiar cajas diesel
    caja_recibido_diesel.setText(null);
    caja_invinicial_diesel.setText(null);
    caja_despa_diesel.setText(null);
    caja_invfinal_diesel.setText(null);
    caja_litfaltantes_diesel.setText(null);
    recibido_litro_diesel.setText(null);
    invinicial_litro_diesel.setText(null);
    despachado_litro_diesel.setText(null);
    invfinal_litro_diesel.setText(null);
    litfaltantes_litro_diesel.setText(null);
    caja_plg_recibido.setText(null);
    caja_plg_invinicial.setText(null);
    caja_plg_despachado.setText(null);
    caja_plg_invfinal.setText(null);
    caja_plg_litfaltantes.setText(null);
    
    };
    
    
    
    
    /**
     * Creates new form Ingreso_Inventario_Combustible
     */
    public Ingreso_Inventario_Combustible() {
        initComponents();
         mostrartipoproducto();
        setTitle("Inventario de combustible");
        limitar();
        Valida();
        cargar("");
        //setIconImage(new ImageIcon(getClass().getResource("/Imagen/logo_tecnogas_transp.png")).getImage());
        fecha_pantalla1.setText(fecha());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField31 = new java.awt.TextField();
        jLabel12 = new javax.swing.JLabel();
        fecha_pantalla = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        modificar_insert = new java.awt.Button();
        ingresar_diesel = new java.awt.Button();
        atras = new java.awt.Button();
        Conversion_button = new java.awt.Button();
        jLabel13 = new javax.swing.JLabel();
        fecha_pantalla1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();
        cargar_tabla = new java.awt.Button();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        tipocom = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        idcom = new javax.swing.JLabel();
        iidtipocomb = new javax.swing.JComboBox();
        error1 = new javax.swing.JLabel();
        error2 = new javax.swing.JLabel();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        error5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        caja_plg_recibido = new javax.swing.JLabel();
        recibido_litro_diesel = new javax.swing.JLabel();
        invinicial_litro_diesel = new javax.swing.JLabel();
        caja_plg_invinicial = new javax.swing.JLabel();
        despachado_litro_diesel = new javax.swing.JLabel();
        caja_plg_despachado = new javax.swing.JLabel();
        litfaltantes_litro_diesel = new javax.swing.JLabel();
        caja_plg_invfinal = new javax.swing.JLabel();
        invfinal_litro_diesel = new javax.swing.JLabel();
        caja_plg_litfaltantes = new javax.swing.JLabel();
        caja_recibido_diesel = new javax.swing.JTextField();
        caja_invinicial_diesel = new javax.swing.JTextField();
        caja_despa_diesel = new javax.swing.JTextField();
        caja_invfinal_diesel = new javax.swing.JTextField();
        caja_litfaltantes_diesel = new javax.swing.JTextField();
        error11 = new javax.swing.JLabel();
        error15 = new javax.swing.JLabel();
        error12 = new javax.swing.JLabel();
        error13 = new javax.swing.JLabel();
        error14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        textField31.setText("textField31");

        jLabel12.setText("Fecha:");

        fecha_pantalla.setText("dd-MM-YYYY");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo1.setForeground(new java.awt.Color(0, 51, 153));
        titulo1.setText("Inventario ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Galon");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Litros");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Pulgadas cubicas");

        jLabel6.setText("Inv. Inicial");

        jLabel7.setText("Despachado");

        jLabel9.setText("Recibido     ");

        jLabel8.setText("Lts. Faltantes");

        jLabel10.setText("Inv. Final");

        modificar_insert.setLabel("Modificar");
        modificar_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_insertActionPerformed(evt);
            }
        });

        ingresar_diesel.setLabel("Ingresar");
        ingresar_diesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresar_dieselActionPerformed(evt);
            }
        });

        atras.setLabel("Atras");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        Conversion_button.setLabel("Conversion");
        Conversion_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Conversion_buttonActionPerformed(evt);
            }
        });

        jLabel13.setText("Fecha:");

        fecha_pantalla1.setText("dd-MM-YYYY");

        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Galones Recibidos", "Recibidos in³", "Inventario Inicial", "Inventario Inicial in³", "Litros Faltantes", "Litros Faltantes in³", "Despachado", "Despachado in³", "Inventario Final", "Inventario Final in³", "ID Usuario", "Tipo Combustible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_inventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_inventario);

        cargar_tabla.setLabel("Cargar Tabla");
        cargar_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_tablaActionPerformed(evt);
            }
        });

        jLabel14.setText("ID  de usuario:");

        jLabel15.setText("Tipo de combustible: ");

        id.setText("...");

        tipocom.setText("...");

        jLabel16.setText("ID combustible:");

        idcom.setText("...");

        iidtipocomb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione.." }));
        iidtipocomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iidtipocombActionPerformed(evt);
            }
        });
        iidtipocomb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iidtipocombKeyPressed(evt);
            }
        });

        error1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 0, 51));
        error1.setText("...");

        error2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        error2.setForeground(new java.awt.Color(255, 0, 51));
        error2.setText("...");

        error3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("...");

        error4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("...");

        error5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        error5.setForeground(new java.awt.Color(255, 0, 51));
        error5.setText("...");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tipo de combustible");

        caja_plg_recibido.setText("...");
        caja_plg_recibido.setPreferredSize(new java.awt.Dimension(10, 21));

        recibido_litro_diesel.setText("...");
        recibido_litro_diesel.setPreferredSize(new java.awt.Dimension(10, 21));

        invinicial_litro_diesel.setText("...");

        caja_plg_invinicial.setText("...");

        despachado_litro_diesel.setText("...");

        caja_plg_despachado.setText("...");

        litfaltantes_litro_diesel.setText("...");

        caja_plg_invfinal.setText("...");

        invfinal_litro_diesel.setText("...");

        caja_plg_litfaltantes.setText("...");

        caja_recibido_diesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja_recibido_dieselActionPerformed(evt);
            }
        });
        caja_recibido_diesel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caja_recibido_dieselKeyTyped(evt);
            }
        });

        caja_despa_diesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caja_despa_dieselActionPerformed(evt);
            }
        });

        error11.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        error11.setForeground(new java.awt.Color(255, 0, 51));
        error11.setText("...");

        error15.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        error15.setForeground(new java.awt.Color(255, 0, 51));
        error15.setText("...");

        error12.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        error12.setForeground(new java.awt.Color(255, 0, 51));
        error12.setText("...");

        error13.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        error13.setForeground(new java.awt.Color(255, 0, 51));
        error13.setText("...");

        error14.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        error14.setForeground(new java.awt.Color(255, 0, 51));
        error14.setText("...");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("1. Super");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("2. Diesel");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Tipo");

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Buscar: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(error3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Conversion_button, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(caja_litfaltantes_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(invfinal_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(caja_plg_litfaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(caja_plg_despachado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(caja_invfinal_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(litfaltantes_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(caja_plg_invfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(error14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(error15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(error13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(error4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ingresar_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tipocom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(idcom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(error1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(error2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(caja_invinicial_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(invinicial_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(caja_plg_invinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(error12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4)
                                                        .addGap(46, 46, 46))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(caja_recibido_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(recibido_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(25, 25, 25))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(caja_despa_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(despachado_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(caja_plg_recibido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(error11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel5))))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(iidtipocomb, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cargar_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(modificar_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(titulo1)
                                .addGap(321, 321, 321)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_pantalla1)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fecha_pantalla1)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jLabel20)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(caja_plg_recibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(recibido_litro_diesel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(caja_recibido_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(error11)
                                            .addComponent(iidtipocomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(caja_invinicial_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invinicial_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(caja_plg_invinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(error12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(error1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(error2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(caja_despa_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(despachado_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(caja_plg_despachado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(error3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(caja_invfinal_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(litfaltantes_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(caja_plg_invfinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(error14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(error4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(caja_litfaltantes_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invfinal_litro_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(caja_plg_litfaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(error15)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(id))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(tipocom))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(idcom))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(error5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel18)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Conversion_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21)))
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar_insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cargar_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ingresar_diesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String fecha(){
    Date fecha = new Date();
    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
           return formatofecha.format(fecha);
    }
    
    private void ingresar_dieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresar_dieselActionPerformed

        Valida();
        limitar();
        
        conexion cc = new conexion();
        Connection cn = cc.conexion();
        
        
        
       try{
          
           String a = System.getProperty("user.name");
           String  consulta = "INSERT INTO `inventario_combustible` (`id_inventario`, `recibido`, `recibido_plg3`, `inventario_inicial`, `inventario_inicial_plg3`, `litros_faltantes`, `litros_faltantes_plg3`, `despacho`, `despacho_plg3`, `inventario_final`, `inventario_final_plg3`, `id_usuario`, `id_tipo_combustible`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
           ps = cn.prepareStatement(consulta);
          
           ps.setString(1, caja_recibido_diesel.getText()); //1-
           ps.setString(2, caja_plg_recibido.getText()); //3-
           ps.setString(3, caja_invinicial_diesel.getText()); //4-
           
           ps.setString(4, caja_plg_invinicial.getText()); // 5-
           ps.setString(5, caja_litfaltantes_diesel.getText()); // 6-
           ps.setString(6, caja_plg_litfaltantes.getText()); // 7-
           ps.setString(7, caja_despa_diesel.getText()); // 8-
           
           ps.setString(8, caja_plg_despachado.getText()); // 9-
           ps.setString(9, caja_invfinal_diesel.getText()); // 10-
           
           ps.setString(10, caja_plg_invfinal.getText());
           ps.setString(11, "1"); 
           ps.setInt(12, iidtipocomb.getSelectedIndex());//tipo_combustible 2: diesel
           
           
           
           int resultado = ps.executeUpdate(); //ejecutamos
           if (resultado > 0){
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente.");
                limpiarcajas1();
                
            }else{
                    JOptionPane.showMessageDialog(null, "Error al insertar el registro.");}
           
           
           
       }catch(Exception ex){
       System.err.println("Error. "+ex);
       
       }
        
    }//GEN-LAST:event_ingresar_dieselActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atrasActionPerformed

    private void Conversion_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Conversion_buttonActionPerformed
       
        
        //convertir plg
        Double a = Double.parseDouble(caja_recibido_diesel.getText());
                
        String convert1= Double.toString(a/61.024);
        
        caja_plg_recibido.setText(convert1);
        
        //2
        
        Double b = Double.parseDouble(caja_invinicial_diesel.getText());
                
        String convert2= Double.toString(b/61.024);
        
        caja_plg_invinicial.setText((convert2));
        
        //3
        
        Double c = Double.parseDouble(caja_despa_diesel.getText());
                
        String convert3= Double.toString(c/61.024);
        
        caja_plg_despachado.setText((convert3));
        
        //4
        
        Double d = Double.parseDouble(caja_invfinal_diesel.getText());
                
        String convert4= Double.toString(d/61.024);
        
        caja_plg_invfinal.setText((convert4));
        
        //5
        
        Double e = Double.parseDouble(caja_litfaltantes_diesel.getText());
                
        String convert5= Double.toString(e/61.024);
        
        caja_plg_litfaltantes.setText((convert5));
        
       
        // convertir litros 3.78541
        
        Double f = Double.parseDouble(caja_litfaltantes_diesel.getText());
                
        String convert6= Double.toString(f/3.78541);
        
        recibido_litro_diesel.setText((convert6));
        
        //2
        Double g = Double.parseDouble(caja_invinicial_diesel.getText());
                
        String convert7= Double.toString(g/3.78541);
        
        invinicial_litro_diesel.setText((convert7));
        
        //3
        Double h = Double.parseDouble(caja_despa_diesel.getText());
                
        String convert8= Double.toString(h/3.78541);
        
        despachado_litro_diesel.setText((convert8));
        
        
        //4
        Double i = Double.parseDouble(caja_invfinal_diesel.getText());
                
        String convert9= Double.toString(i/3.78541);
        
        invfinal_litro_diesel.setText((convert9));
        
        
        //5
        Double j = Double.parseDouble(caja_litfaltantes_diesel.getText());
                
        String convert10= Double.toString(j/3.78541);
        
        litfaltantes_litro_diesel.setText((convert10));
        
        
        
        
        
    }//GEN-LAST:event_Conversion_buttonActionPerformed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        Control_Combustible_Diario boton_Control_Combustible_Diario = new Control_Combustible_Diario();
        boton_Control_Combustible_Diario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasMouseClicked

    private void cargar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_tablaActionPerformed
     String mostrar="SELECT `id_inventario`, `recibido`, `recibido_plg3`, `inventario_inicial`, `inventario_inicial_plg3`, `litros_faltantes`, `litros_faltantes_plg3`, `despacho`, `despacho_plg3`, `inventario_final`, `inventario_final_plg3`, `id_usuario`, `id_tipo_combustible` FROM `inventario_combustible` WHERE 1";
    String []titulos={"Id inventario","recibido","recibido plg","inventario inicial","inventario inicial plg3","litros faltantes","litros faltantes plg3","despacho","despacho plg","inventario final","inventario final plg3","id_usuario","id_tipo_combustible" };
    String []Registros=new String[14];
    DefaultTableModel model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              java.sql.ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("id_inventario");
                  Registros[1]= rs.getString("recibido");
                  Registros[2]= rs.getString("recibido_plg3");
                  Registros[3]= rs.getString("inventario_inicial");
                  Registros[4]= rs.getString("inventario_inicial_plg3");
                  Registros[5]= rs.getString("litros_faltantes");
                  Registros[6]= rs.getString("litros_faltantes_plg3");
                  Registros[7]= rs.getString("despacho");
                  Registros[8]= rs.getString("despacho_plg3");
                  Registros[9]= rs.getString("inventario_final");
                  Registros[10]= rs.getString("inventario_final_plg3");
                  Registros[11]= rs.getString("id_usuario");
                  Registros[12]= rs.getString("id_tipo_combustible");
                       
                  model.addRow(Registros);
              }
              tabla_inventario.setModel(model);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        
    }//GEN-LAST:event_cargar_tablaActionPerformed

    private void modificar_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_insertActionPerformed
        // TODO add your handling code here:
        try {
            //String sql= "`proveedores` SET `id_proveedores`='"+idproveedor.getText()+"',`nombre`='"+descripcion.getText()+"',`telefono`='"+telefono.getText()+"',`direccion_correo`='"+correo.getText()+"',`direccion`='"+direccion.getText()+"',`id_categoria_productos`='"+idcategoria.getSelectedIndex()+"' WHERE `id_proveedores` ='"+idproveedor.getText()+"'";
            //String consulta="UPDATE `proveedores` SET `id_proveedores` = '"+idproveedor.getText()+"', `nombre` = '"+descripcion.getText()+"', `telefono` = '"+telefono.getText()+"', `direccion_correo` = '"+correo.getText()+"', `direccion` = '"+direccion.getText()+"', `id_categoria_productos` = '"+idcategoria.getSelectedIndex()+"' WHERE `proveedores`.`id_proveedores` = "+idproveedor.getText()+"";
            String consulta = "UPDATE `inventario_combustible` SET `recibido`='"+caja_recibido_diesel.getText()+"',`recibido_plg3`='"+recibido_litro_diesel.getText()+"',`inventario_inicial`='"+caja_invinicial_diesel.getText()+"',`inventario_inicial_plg3`='"+invinicial_litro_diesel.getText()+"',`litros_faltantes`='"+caja_litfaltantes_diesel.getText()+"',`litros_faltantes_plg3`='"+caja_plg_litfaltantes.getText()+"',`despacho`='"+caja_despa_diesel.getText()+"',`despacho_plg3`='"+despachado_litro_diesel.getText()+"',`inventario_final`='"+caja_invfinal_diesel.getText()+"',`inventario_final_plg3`='"+caja_plg_invfinal.getText()+"',`id_usuario`='"+id.getText()+"',`id_tipo_combustible`='"+tipocom.getText()+"' WHERE `inventario_combustible`.`id_inventario` = '"+idcom.getText()+"'";
            PreparedStatement pst  = cn.prepareStatement(consulta);
           
            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
            cargar("");
            
           
        } catch (java.sql.SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        
        } 
    }//GEN-LAST:event_modificar_insertActionPerformed

    private void tabla_inventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_inventarioMouseClicked
        // TODO add your handling code here:
        int seleccionar = tabla_inventario.rowAtPoint(evt.getPoint());
        idcom.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,0)));
        caja_recibido_diesel.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,1)));
        caja_plg_recibido.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,2)));
        
        
        caja_invinicial_diesel.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,3)));
        caja_plg_invinicial.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,4)));
        
        caja_litfaltantes_diesel.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,5)));
        caja_plg_litfaltantes.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,6)));
        
        caja_despa_diesel.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,7)));
        caja_plg_despachado.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,8)));
        
        caja_invfinal_diesel.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,9)));
        caja_plg_invfinal.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,10)));
        
        id.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,11)));
        tipocom.setText(String.valueOf(tabla_inventario.getValueAt(seleccionar,12)));
        iidtipocomb.setSelectedItem(String.valueOf(tabla_inventario.getValueAt(seleccionar,12)));
        
        
        
    }//GEN-LAST:event_tabla_inventarioMouseClicked

    private void iidtipocombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iidtipocombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iidtipocombActionPerformed

    private void iidtipocombKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iidtipocombKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_iidtipocombKeyPressed

    private void caja_recibido_dieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja_recibido_dieselActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja_recibido_dieselActionPerformed

    private void caja_despa_dieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caja_despa_dieselActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caja_despa_dieselActionPerformed

    private void caja_recibido_dieselKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caja_recibido_dieselKeyTyped
        // TODO add your handling code here:
           char validar =evt.getKeyChar();
        
        if(Character.isLetter(validar)||Character.isSpaceChar(validar)){
        getToolkit().beep();
        evt.consume();
        error5.setText("Solo numeros y sin espacios");
        }
        if(!Character.isDigit(evt.getKeyChar())&& evt.getKeyChar()!='.' ){
            evt.consume();
  }        if(evt.getKeyChar()=='.'&&caja_litfaltantes_diesel.getText().contains(".")){
          evt.consume(); }
    }//GEN-LAST:event_caja_recibido_dieselKeyTyped

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        // TODO add your handling code here:
        cargar(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Inventario_Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Inventario_Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Inventario_Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso_Inventario_Combustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso_Inventario_Combustible().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Conversion_button;
    private java.awt.Button atras;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField caja_despa_diesel;
    private javax.swing.JTextField caja_invfinal_diesel;
    private javax.swing.JTextField caja_invinicial_diesel;
    private javax.swing.JTextField caja_litfaltantes_diesel;
    private javax.swing.JLabel caja_plg_despachado;
    private javax.swing.JLabel caja_plg_invfinal;
    private javax.swing.JLabel caja_plg_invinicial;
    private javax.swing.JLabel caja_plg_litfaltantes;
    private javax.swing.JLabel caja_plg_recibido;
    private javax.swing.JTextField caja_recibido_diesel;
    private java.awt.Button cargar_tabla;
    private javax.swing.JLabel despachado_litro_diesel;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel error11;
    private javax.swing.JLabel error12;
    private javax.swing.JLabel error13;
    private javax.swing.JLabel error14;
    private javax.swing.JLabel error15;
    private javax.swing.JLabel error2;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel error5;
    private javax.swing.JLabel fecha_pantalla;
    private javax.swing.JLabel fecha_pantalla1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idcom;
    private javax.swing.JComboBox iidtipocomb;
    private java.awt.Button ingresar_diesel;
    private javax.swing.JLabel invfinal_litro_diesel;
    private javax.swing.JLabel invinicial_litro_diesel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel litfaltantes_litro_diesel;
    private java.awt.Button modificar_insert;
    private javax.swing.JLabel recibido_litro_diesel;
    private javax.swing.JTable tabla_inventario;
    private java.awt.TextField textField31;
    private javax.swing.JLabel tipocom;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
