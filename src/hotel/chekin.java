/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import hotel.koneksi;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 *
 * @author ACER
 */
public class chekin extends javax.swing.JFrame {
    private Statement st;
    private Connection Con;
    private ResultSet Rs;
    private String Sql="";
    private String host;
    private String tanggal="";
    private ResultSet Rskamar;
    private ResultSet Rspelanggan;
    private ResultSet Rssewa;
   // chekin koneksi = new chekin();
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param= new HashMap();
    JasperDesign JasDes;

public String nomor, id, kode;
int tobar, bager, kembali, harga, tbayar, lama, tharga, bayar, jumlah;

    /**
     * Creates new form chekin
     */
    public chekin() {
        initComponents();
        koneksi();
        Tampil();
        //"select * from tb_chekin"
       pilihpelanggan();
        pilihkamar();

    }
private void koneksi(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhotel","root","");
            System.out.println("BERHASIL");
           JOptionPane.showMessageDialog(null, "KONEKSI BERHASIL");
           } catch (HeadlessException | ClassNotFoundException | SQLException e){
        System.out.println ("GAGAL KONEKSI");
        }
}

private void Tampil() {
DefaultTableModel grid=new DefaultTableModel();
grid.addColumn ("No");
grid.addColumn ("no_chekin");
grid.addColumn ("tanggal");
grid.addColumn ("id_kamar");
grid.addColumn ("id_pelanggan");
grid.addColumn ("lama_sewa");
grid.addColumn ("total_harga");
grid.addColumn ("jumlah_bayar");
grid.addColumn ("kembalian");
try {
	int i=1; 
	st=Con.createStatement();
	Rs=st.executeQuery("select * from tb_chekin");
	while (Rs.next()) {
		grid.addRow(new Object[]{
			(""+i++),Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),
                });      
		jTable2.setModel(grid);
		jTable2.enable(true);
		btnSimpan.requestFocus();
                txtnama.enable(false);
                 txttype.enable(false);
                  txtharga.enable(false);
                   txtbiaya.enable(false);
                    txtkembalian.enable(false);
                   
}
        
}catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, "Gagal Koneksi"+e);
        }
}

private void pilihkamar() {
	cmbidkam.removeAllItems();
	cmbidkam.addItem("Pilih");
	try {
		String Sql ="select * from tb_kamar";
		Statement st=Con.createStatement();
		Rskamar =st.executeQuery(Sql);
		while(Rskamar.next()) {
			String AliasKode;
                    AliasKode = Rskamar.getString("id_kamar");
			cmbidkam.addItem(AliasKode);

}
}catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, "Gagal Menampilkan Kode Kamar"+e);
        }
}
private void pilihpelanggan() {
	cmbidpel.removeAllItems();
	cmbidpel.addItem("Pilih");
	try {
		String Sql ="select * from tb_pelanggan";
		Statement st=Con.createStatement();
		Rspelanggan =st.executeQuery(Sql);
		while(Rspelanggan.next()) {
			String Kode = Rspelanggan.getString("id_pelanggan");
			cmbidpel.addItem(Kode);

}
}catch (HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, "Gagal Menampilkan Kode pelanggan"+e);
        }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtchekin = new javax.swing.JTextField();
        cmbidpel = new javax.swing.JComboBox<>();
        cmbidkam = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsewa = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txttype = new javax.swing.JTextField();
        txtbiaya = new javax.swing.JTextField();
        txtjmlhbyr = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        datetanggal = new com.toedter.calendar.JDateChooser();
        btnSimpan1 = new javax.swing.JButton();
        btncetak = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btncetak1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NO CHEKIN");

        jLabel2.setText("Tanggal Chekin");

        jLabel3.setText("Id Pelanggan");

        jLabel4.setText("No Kamar");

        cmbidpel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbidpel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidpelItemStateChanged(evt);
            }
        });
        cmbidpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbidpelActionPerformed(evt);
            }
        });

        cmbidkam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbidkam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbidkamItemStateChanged(evt);
            }
        });

        jLabel5.setText("Lama Sewa");

        jLabel6.setText("Nama Pelanggan");

        jLabel7.setText("Type");

        jLabel8.setText("Biaya");

        jLabel9.setText("Total Harga");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jTable2.setColumnSelectionAllowed(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel11.setText("Jumlah Bayar");

        jLabel12.setText("Kembalian");

        txtsewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsewaActionPerformed(evt);
            }
        });
        txtsewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsewaKeyReleased(evt);
            }
        });

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthargaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txthargaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthargaKeyTyped(evt);
            }
        });

        txtjmlhbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlhbyrActionPerformed(evt);
            }
        });
        txtjmlhbyr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjmlhbyrKeyReleased(evt);
            }
        });

        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jLabel14.setBackground(new java.awt.Color(0, 255, 204));
        jLabel14.setFont(new java.awt.Font("Blockletter", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText("DATA TRANSAKSI HOTEL MARIO BROSS");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamaKeyPressed(evt);
            }
        });

        datetanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datetanggalPropertyChange(evt);
            }
        });

        btnSimpan1.setText("KELUAR");
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });

        btncetak.setText("Cetak Kwitansi");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btncetak1.setText("Cetak Laporan");
        btncetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtkembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(txtjmlhbyr)))
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtsewa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbidkam, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbidpel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtchekin, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(datetanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttype, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtbiaya, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtharga, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(txtnama))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(btnSimpan1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncetak1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(btnSimpan1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtchekin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datetanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbidpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbidkam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtsewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjmlhbyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btncetak)
                    .addComponent(btnhapus)
                    .addComponent(btncetak1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        txtchekin.setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
        //datetanggal.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(),2).toString());
        //cmbidpel.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(),3).toString());
        //cmbidkam.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(),4).toString());
        //txtsewa.setText(jTable2.getValueAt(jTable2.getSelectedRow(),5).toString());
       // txtnama.setText(jTable2.getValueAt(jTable2.getSelectedRow(),6).toString());
        //txttype.setText(jTable2.getValueAt(jTable2.getSelectedRow(),7).toString());
        //txtbiaya.setText(jTable2.getValueAt(jTable2.getSelectedRow(),8).toString());
        //txtharga.setText(jTable2.getValueAt(jTable2.getSelectedRow(),9).toString());
        //txtjmlhbyr.setText(jTable2.getValueAt(jTable2.getSelectedRow(),10).toString());
        //txtkembalian.setText(jTable2.getValueAt(jTable2.getSelectedRow(),11).toString());
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2PropertyChange

    private void txtjmlhbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlhbyrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlhbyrActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void cmbidpelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidpelItemStateChanged
        // TODO add your handling code here:
        try { 
	Sql="select * from tb_pelanggan "
		+"where id_pelanggan='"+cmbidpel.getSelectedItem()+"'";
	st=Con.createStatement();
	Rspelanggan=st.executeQuery(Sql);
	while(Rspelanggan.next()){
		txtnama.setText(Rspelanggan.getString(2));
        }
} 
        catch (SQLException e) {
}
    }//GEN-LAST:event_cmbidpelItemStateChanged

    private void cmbidkamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbidkamItemStateChanged
        // TODO add your handling code here:
        try { 
	Sql="select * from tb_kamar "
		+"where id_kamar='"+cmbidkam.getSelectedItem()+"'";
	st=Con.createStatement();
	Rskamar=st.executeQuery(Sql);
	while(Rskamar.next()){
		txttype.setText(Rskamar.getString(2));
                  txtbiaya.setText(Rskamar.getString(3));
        }
} 
        catch (SQLException e) {
}
    }//GEN-LAST:event_cmbidkamItemStateChanged

    private void cmbidpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbidpelActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbidpelActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyPressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtnamaKeyPressed

    private void txtsewaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsewaKeyReleased
int biaya, lama, total ;
biaya = Integer.parseInt(txtbiaya.getText());
lama = Integer.parseInt(txtsewa.getText());
total = biaya * lama;

txtharga.setText(String.valueOf(total));  
// TODO add your handling code here:
    }//GEN-LAST:event_txtsewaKeyReleased

    private void txtsewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsewaActionPerformed

    private void txtjmlhbyrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjmlhbyrKeyReleased
        // TODO add your handling code here:
        int tbayar, bayar, kembali;
tbayar = Integer.parseInt(txtharga.getText());
bayar = Integer.parseInt(txtjmlhbyr.getText());
kembali = bayar - tbayar;
txtkembalian.setText(String.valueOf(kembali)); 
    }//GEN-LAST:event_txtjmlhbyrKeyReleased

    private void datetanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datetanggalPropertyChange
        // TODO add your handling code here:
        if (datetanggal.getDate() !=null) {
	SimpleDateFormat format = new SimpleDateFormat("YYY-MM-dd");
	tanggal=format.format(datetanggal.getDate());
}
    }//GEN-LAST:event_datetanggalPropertyChange

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
nomor = txtchekin.getText();
SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
tanggal = format.format(datetanggal.getDate());
kode = cmbidkam.getItemAt(cmbidkam.getSelectedIndex());
id = cmbidpel.getItemAt(cmbidpel.getSelectedIndex());
lama = Integer.parseInt(txtsewa.getText());
tharga = Integer.parseInt(txtharga.getText());
bayar = Integer.parseInt(txtjmlhbyr.getText());
kembali = Integer.parseInt(txtkembalian.getText());
try {
Sql = "insert into tb_chekin"
+"(no_chekin,tanggal,id_kamar,id_pelanggan,lama_sewa,total_harga,jumlah_bayar,kembalian)"
+"values ('"+nomor+"','"+tanggal+"',"
+"'"+kode+"','"+id+"',"
+"'"+lama+"','"+tharga+"',"
+"'"+bayar+"',"
+"'"+kembali+"')";
st = Con.createStatement();
st.execute(Sql);
Tampil();
//"select * from tb_chekin"
kosong();
JOptionPane.showMessageDialog(null, "data berhasil disimpan");

}catch (Exception e){
        JOptionPane.showMessageDialog(null, "Gagal Menyimpan data"+e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txthargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txthargaKeyReleased

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void txthargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaKeyPressed

    private void txthargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txthargaKeyTyped

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSimpan1ActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try {
            String namafile= "src/hotel/report2.jasper"; 
      File report = new File(namafile);
      JasperReport JasRep = (JasperReport)JRLoader.loadObject(report.getPath());
      JasperPrint JasPri = JasperFillManager.fillReport(JasRep,null, Con);
      JasperViewer.viewReport(JasPri,false);
     
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan","Cetak Laporan",JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_btncetakActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         id=txtchekin.getText();
        try
        {
            Sql="delete from tb_chekin " +
            "where no_chekin='"+id+"'";
            st=Con.createStatement();
            st.execute(Sql);
            kosong();
            Tampil();
            JOptionPane.showMessageDialog(null, "Delete Data Sukses");
        } 
        catch (HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Delete Data Gagal");
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetak1ActionPerformed
        // TODO add your handling code here:
         try {
            String namafile= "src/hotel/report1.jasper"; 
      File report = new File(namafile);
      JasperReport JasRep = (JasperReport)JRLoader.loadObject(report.getPath());
      JasperPrint JasPri = JasperFillManager.fillReport(JasRep,null, Con);
      JasperViewer.viewReport(JasPri,false);
     
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan","Cetak Laporan",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btncetak1ActionPerformed

    private void kosong(){
txtchekin.setText("");
datetanggal.setDate(null);
cmbidpel.setSelectedItem(null);
cmbidkam.setSelectedItem(null);
txtsewa.setText("");
txtharga.setText("");
txtjmlhbyr.setText("");
txtkembalian.setText("");
txtnama.setText("");
txttype.setText("");
txtbiaya.setText("");
    }
    
   
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
            java.util.logging.Logger.getLogger(chekin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chekin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chekin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chekin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chekin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btncetak1;
    private javax.swing.JButton btnhapus;
    private javax.swing.JComboBox<String> cmbidkam;
    private javax.swing.JComboBox<String> cmbidpel;
    private com.toedter.calendar.JDateChooser datetanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JTextField txtchekin;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjmlhbyr;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtsewa;
    private javax.swing.JTextField txttype;
    // End of variables declaration//GEN-END:variables

}
