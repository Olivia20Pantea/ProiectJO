package company.com;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class List_object extends javax.swing.JFrame {


    boolean con;
    static Person P;
    public List_object() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_List = new javax.swing.JTextArea();
        jTextField_Operation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel.setText("List contact");

        jTextArea_List.setEditable(false);
        jTextArea_List.setColumns(20);
        jTextArea_List.setRows(5);
        jTextArea_List.setText(null);
        if(ListLinker.head==null)
        {

        }
        else{
            Person p1=ListLinker.head;
            while(p1!=null)
            {
                jTextArea_List.append("Cod client: "+p1.COD+
                        "\nFirstname: "+p1.first_name+
                        "\nLastname: "+p1.last_name+
                        "\nGender: "+p1.gender+
                        "\nAddress: "+p1.address+"\n\n");
                p1=p1.next;
            }
        }
        jScrollPane2.setViewportView(jTextArea_List);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jButton3.setText("Return");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Enter the code client:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)
                                                .addGap(131, 131, 131)
                                                .addComponent(jButton3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(203, 203, 203)
                                                .addComponent(jLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField_Operation)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Operation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {

        con=false;
        Person p1=ListLinker.head;
        if(jTextField_Operation.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Insert ID to modify!");
        }
        else{
            while(p1!=null){
                if(jTextField_Operation.getText().equals(p1.COD)){
                    con=true;
                    break;
                }
                p1=p1.next;
            }
            if(con){
                System.out.println(p1.COD);
                this.dispose();
                Modify m=new Modify();
                m.setTitle("Modify object");
                m.setup(p1);
                P=p1;

                m.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The codețs client is not presented!!");
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Main m=new Main();
        m.setTitle("Main menu");
        m.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        con=false;
        if(jTextField_Operation.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter ID to delete a object!");
        }
        else
        {
            if(ListLinker.head==null)
            {
                JOptionPane.showMessageDialog(null, "No item is presented to be deleted!");
            }
            else{
                Person hd=ListLinker.head;
                if(ListLinker.head.COD.equals(jTextField_Operation.getText()))
                {
                    ListLinker.head=ListLinker.head.next;
                    JOptionPane.showMessageDialog(null, "The contact has been deleted!");
                    this.dispose();
                    List_object lo=new List_object();
                    lo.setTitle("Object List");
                    lo.setVisible(true);
                }
                else{
                    while(hd!=null)
                    {
                        if(hd.next.COD.equals(jTextField_Operation.getText()))
                        {
                            con=true;
                            break;
                        }
                        hd=hd.next;
                    }
                    if(con)
                    {
                        Person backup=hd.next.next;
                        hd.next=null;
                        hd.next=backup;
                        JOptionPane.showMessageDialog(null, "The contact has been deleted!");
                        this.dispose();
                        List_object lo=new List_object();
                        lo.setTitle("Object List");
                        lo.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The object is not found!");
                    }
                }
            }
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(List_object.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_object.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_object.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_object.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_object().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea_List;
    public static javax.swing.JTextField jTextField_Operation;

}
