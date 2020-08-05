/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import ServerApp.GamePackage.Character;
import ServerApp.GamePackage.PlayerData;

/**
 *
 * @author Fernando Alvarez
 */
public class MainWindow extends javax.swing.JFrame implements IInput,IOutput {

    public StyledDocument document;//Guardar una referencia de los characters para hacer las cargas de los personajes
    private Color NEGRO = new Color(50, 50, 50);
    private PersonajeLabel[] characterLabels = new PersonajeLabel[5];
    //Tamano imagenes personaje 133x377
    //Tamano imagenes personaje ataque 317x243
    
    public MainWindow(KeyListener listener) {
        initComponents();
        this.setTitle("xd.exe");
        initConsole(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        pnlRank = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaRank = new javax.swing.JTextArea();
        pnlEnemyInfo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaEnemyInfo = new javax.swing.JTextArea();
        pnlMyInfo = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaEnemyInfo1 = new javax.swing.JTextArea();
        pnlAtack = new javax.swing.JPanel();
        pnlAtackedInfo = new javax.swing.JPanel();
        pnlAtackInfo = new javax.swing.JPanel();
        pnlPlayer = new javax.swing.JPanel();
        lblDummy1 = new javax.swing.JLabel();
        pnlCharacter = new javax.swing.JPanel();
        pnlWeapn = new javax.swing.JPanel();
        lblPlayerHpInfo = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOutPut = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setPreferredSize(new java.awt.Dimension(1290, 720));

        pnlRank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAreaRank.setEditable(false);
        txtAreaRank.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaRank.setColumns(10);
        txtAreaRank.setForeground(new java.awt.Color(51, 255, 0));
        txtAreaRank.setRows(10);
        jScrollPane1.setViewportView(txtAreaRank);

        javax.swing.GroupLayout pnlRankLayout = new javax.swing.GroupLayout(pnlRank);
        pnlRank.setLayout(pnlRankLayout);
        pnlRankLayout.setHorizontalGroup(
            pnlRankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        pnlRankLayout.setVerticalGroup(
            pnlRankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        pnlEnemyInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAreaEnemyInfo.setEditable(false);
        txtAreaEnemyInfo.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaEnemyInfo.setColumns(10);
        txtAreaEnemyInfo.setForeground(new java.awt.Color(51, 255, 0));
        txtAreaEnemyInfo.setRows(10);
        jScrollPane3.setViewportView(txtAreaEnemyInfo);

        javax.swing.GroupLayout pnlEnemyInfoLayout = new javax.swing.GroupLayout(pnlEnemyInfo);
        pnlEnemyInfo.setLayout(pnlEnemyInfoLayout);
        pnlEnemyInfoLayout.setHorizontalGroup(
            pnlEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        pnlEnemyInfoLayout.setVerticalGroup(
            pnlEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        pnlMyInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAreaEnemyInfo1.setEditable(false);
        txtAreaEnemyInfo1.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaEnemyInfo1.setColumns(10);
        txtAreaEnemyInfo1.setForeground(new java.awt.Color(51, 255, 0));
        txtAreaEnemyInfo1.setRows(10);
        jScrollPane5.setViewportView(txtAreaEnemyInfo1);

        javax.swing.GroupLayout pnlMyInfoLayout = new javax.swing.GroupLayout(pnlMyInfo);
        pnlMyInfo.setLayout(pnlMyInfoLayout);
        pnlMyInfoLayout.setHorizontalGroup(
            pnlMyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        pnlMyInfoLayout.setVerticalGroup(
            pnlMyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEnemyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(pnlEnemyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(pnlMyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pnlAtackedInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlAtackedInfoLayout = new javax.swing.GroupLayout(pnlAtackedInfo);
        pnlAtackedInfo.setLayout(pnlAtackedInfoLayout);
        pnlAtackedInfoLayout.setHorizontalGroup(
            pnlAtackedInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        pnlAtackedInfoLayout.setVerticalGroup(
            pnlAtackedInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        pnlAtackInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlAtackInfoLayout = new javax.swing.GroupLayout(pnlAtackInfo);
        pnlAtackInfo.setLayout(pnlAtackInfoLayout);
        pnlAtackInfoLayout.setHorizontalGroup(
            pnlAtackInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        pnlAtackInfoLayout.setVerticalGroup(
            pnlAtackInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAtackLayout = new javax.swing.GroupLayout(pnlAtack);
        pnlAtack.setLayout(pnlAtackLayout);
        pnlAtackLayout.setHorizontalGroup(
            pnlAtackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtackLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlAtackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAtackedInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAtackInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlAtackLayout.setVerticalGroup(
            pnlAtackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtackLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(pnlAtackedInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlAtackInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        lblDummy1.setText("Your Team");

        javax.swing.GroupLayout pnlCharacterLayout = new javax.swing.GroupLayout(pnlCharacter);
        pnlCharacter.setLayout(pnlCharacterLayout);
        pnlCharacterLayout.setHorizontalGroup(
            pnlCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCharacterLayout.setVerticalGroup(
            pnlCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        pnlWeapn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlWeapnLayout = new javax.swing.GroupLayout(pnlWeapn);
        pnlWeapn.setLayout(pnlWeapnLayout);
        pnlWeapnLayout.setHorizontalGroup(
            pnlWeapnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlWeapnLayout.setVerticalGroup(
            pnlWeapnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblPlayerHpInfo.setText("jLabel2");

        javax.swing.GroupLayout pnlPlayerLayout = new javax.swing.GroupLayout(pnlPlayer);
        pnlPlayer.setLayout(pnlPlayerLayout);
        pnlPlayerLayout.setHorizontalGroup(
            pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayerLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblPlayerHpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPlayerLayout.createSequentialGroup()
                        .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlWeapn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCharacter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPlayerLayout.createSequentialGroup()
                                .addComponent(lblDummy1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 531, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlPlayerLayout.setVerticalGroup(
            pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDummy1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblPlayerHpInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlWeapn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtInput.setBackground(new java.awt.Color(51, 51, 51));
        txtInput.setForeground(new java.awt.Color(51, 255, 0));

        txtOutPut.setEditable(false);
        txtOutPut.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(txtOutPut);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAtack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtInput))))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlAtack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void initConsole(KeyListener listener){
        this.txtInput.addKeyListener(listener);
        document = this.txtOutPut.getStyledDocument();
    }
    
    public void initData(PlayerData playerData){
        setCharacter(playerData.getCharacter());
        setRanks(playerData.getRank());
        setWeapons(playerData.getCharacter());
        //setAtacked(null);
        //setAtack(null);
        setInfoEnemy(playerData.getHistory());
        setMyInfo(playerData.getEnemyData().getHistory());
        setVisible(true);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblDummy1;
    private javax.swing.JLabel lblPlayerHpInfo;
    private javax.swing.JPanel pnlAtack;
    private javax.swing.JPanel pnlAtackInfo;
    private javax.swing.JPanel pnlAtackedInfo;
    private javax.swing.JPanel pnlCharacter;
    private javax.swing.JPanel pnlEnemyInfo;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMyInfo;
    private javax.swing.JPanel pnlPlayer;
    private javax.swing.JPanel pnlRank;
    private javax.swing.JPanel pnlWeapn;
    private javax.swing.JTextArea txtAreaEnemyInfo;
    private javax.swing.JTextArea txtAreaEnemyInfo1;
    private javax.swing.JTextArea txtAreaRank;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextPane txtOutPut;
    // End of variables declaration//GEN-END:variables

    
    private void print(String message, boolean trace, Color c) {
        Style style = txtOutPut.addStyle("Style", null);
        StyleConstants.setForeground(style, c);
        
        if(trace){
            Throwable t = new Throwable();
            StackTraceElement[] elements = t.getStackTrace();
            String caller = elements[0].getClassName();
            
            message =  caller+"->"+message;
        }
        try {
            document.insertString(document.getLength(), message, style);
        } catch (Exception e) {
        }
            
        }
    
    public void print(String message,boolean trace){
        print(message, trace,Color.GREEN);
    }
    
    public void println(String message,boolean trace){
        print(">"+message+"\n", trace,Color.GREEN);
    }
    
    public void printChatMessage(String message,boolean trace){
        print(message+"\n", trace,Color.YELLOW);
    }
    
    public void printConsoleMessage(String message,boolean trace){
        print(message+"\n", trace,Color.RED);
    }

    public void setCharacter(Character[] characters){
        Dimension dimsension = new Dimension(this.pnlCharacter.getSize().width/5, this.pnlCharacter.getSize().height);
        for (int i = 0; i < 5; i++) {
            Character charac = characters[i];
            PersonajeLabel pl = new PersonajeLabel(charac.getName(), charac.getPath());
            pl.setBounds(dimsension.width*i,0,dimsension.width,dimsension.height);
            pl.setBackground(NEGRO);
            characterLabels[i] = pl;
            pnlCharacter.add(pl);
        }
    }
    
    public void setRanks(String rank){//Usa el archivo o la estructura de jugadores guardados y toma los 10 de mayor puntaje PIDE UN STRING ENVIADO POR UNA FUNCION DE EL PLAYERLOADE
        txtAreaRank.setText(rank);
    }

    public void setWeapons(Character[] characters){//PIDE EL OBJETO CHARACTER SI SOLO ATACA UNO Y EL ARRAY DE DANO RECIBIDO SE USA CON EL COMANDO SELECT
        Dimension dimension = pnlWeapn.getSize();
        int labelHeigth = dimension.height/5;
        for(int j = 0;j<5;j++) {
            WeaponLabel weaponLabel = new WeaponLabel();
            weaponLabel.setLocation(0,0);
            weaponLabel.setSize(pnlWeapn.getSize());
            Character currentChar = characters[j];
            for (int i = 0; i < 5; i++) {
                WeaponInfoLabel wil = new WeaponInfoLabel();
                wil.setBounds(0, labelHeigth * i, dimension.width, labelHeigth);
                wil.createLabels(currentChar.getWeapons()[i].getName(), currentChar.getWeapons()[i].getDamages());
                weaponLabel.labels[i] = wil;
            }
            characterLabels[j].weaponsInfoLabel = weaponLabel;
        }
        pnlWeapn.add(characterLabels[0]);
    }

    //Nombre,Dano recibido
    public void setAtack(/*Character o String[] o IMessage*/){//PIDE EL OBJETO CHARACTER SI SOLO ATACA UNO Y EL ARRAY DE DANO ENVIADO(INDIVIDUAL O A TODOS)
        Dimension dimension = pnlAtackInfo.getSize();
                                              //Character values 123 y el dano
        AtackInfoLabel ail = new AtackInfoLabel("", "", "", "");
        ail.setBounds(0,0,dimension.width,dimension.height);
        pnlAtackInfo.add(ail);
    }
    //Nombre,Dano recibido
    public void setAtacked(){//Recibe el estado del ataque PIDE EL OBJETO CHARACTER SI SOLO ATACA UNO Y EL ARRAY DE DANO RECIBIDO
        AtackedByInfoLabel abl = new AtackedByInfoLabel("", "", "", null);
        Dimension dimension = pnlAtackedInfo.getSize();
        abl.setBounds(0, 0, dimension.width, dimension.height);
        pnlAtackedInfo.add(abl);
    }
    
    public void setInfoEnemy(String data){//Usa el historial del jugador enemigo PIDE EL OBJETO HISTORIAL
        String info = "Enemy\n"+data;
        txtAreaEnemyInfo1.setText(info);
    }
    
    public void setMyInfo(String data){//Usa el historial del jugador actual PIDE EL OBJETO HISTORIAL
        String info = "MyInfo\n"+data;
        txtAreaEnemyInfo.setText(info);
    }

    public void setUsedWeapon(String characterName,String weaponName){
        //If ataque exitoso
        for (PersonajeLabel characterLabel : characterLabels) {
            if (characterLabel.name.getText() == characterName) {
                characterLabel.weaponsInfoLabel.setUsed(weaponName);
            }
        }
    }

    @Override
    public String nextLine() {
        String line = this.txtInput.getText();
        println(line, false);
        this.txtInput.setText("");
        return line;
    }


    @Override
    public void write(String string) {
        printConsoleMessage(string, true);
    }

    private void updateWeaponInfo(PersonajeLabel label){
        pnlWeapn.removeAll();
        pnlWeapn.add(label.weaponsInfoLabel);
        pnlWeapn.validate();
        pnlWeapn.repaint();
    }
    
    public void selectCharacter(String charName){
        for (PersonajeLabel characterLabel : characterLabels) {
            if(characterLabel.name.getText() == charName){
                updateWeaponInfo(characterLabel);
                return;
            }
        }
        println("Personaje no existe", false);
    }
}
