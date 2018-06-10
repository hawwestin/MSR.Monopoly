/*
 * The MIT License
 *
 * Copyright 2018 Michal.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package UI.Windows;

import Core.GameState;
import Core.Icon;
import Core.Player;
import Core.Settings;
import UI.Start;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Michal
 */
public class WelcomeWindow extends javax.swing.JPanel {

    private ArrayList<Player> players = new ArrayList<Player>();
    private final DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>();

    private int _currentPlayerIndex = 0;

    public int getCurrentPlayerIndex() {
        return _currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        if (_currentPlayerIndex > 0 || _currentPlayerIndex < Settings.PlayersLimit) {
            _currentPlayerIndex = currentPlayerIndex;
            JBPrevPlayer.setEnabled(true);
            JBNextPlayer.setEnabled(true);
        }
        if (_currentPlayerIndex == 0) {
            JBPrevPlayer.setEnabled(false);
        }
        if (_currentPlayerIndex == Settings.PlayersLimit) {
            JBNextPlayer.setEnabled(false);
        }

    }

    /**
     * Creates new form WelcomeWindow
     */
    public WelcomeWindow() {
        initComponents();

        Icon.getIconMap().keySet().forEach((String kind) -> cbm.addElement(kind));
        JCBIcon.setModel(cbm);

        JBPrevPlayer.setEnabled(false);
        JBStart.setEnabled(false);

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
        JTFName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JBPrevPlayer = new javax.swing.JButton();
        JBNextPlayer = new javax.swing.JButton();
        JBStart = new javax.swing.JButton();
        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel3 = new javax.swing.JLabel();
        JCBIcon = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Witaj w Monopoly!");

        JTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Nazwa gracza");

        JBPrevPlayer.setText("Zapisz i wczytaj poprzedniego gracza");
        JBPrevPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPrevPlayerActionPerformed(evt);
            }
        });

        JBNextPlayer.setText("Zapisz i wczytaj kolejnego gracza");
        JBNextPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNextPlayerActionPerformed(evt);
            }
        });

        JBStart.setText("Start");
        JBStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBStartActionPerformed(evt);
            }
        });

        jLabel3.setText("Pionek");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBPrevPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBNextPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JBStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(JCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBPrevPlayer)
                    .addComponent(JBNextPlayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBStart)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNameActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_JTFNameActionPerformed

    private void JBStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBStartActionPerformed
        Start.InitGame(players);
        Start.changeGameState(GameState.GAME_STATE);
        //todo przekarz gdzeieś listę utworzonych graczy i ich wyborów... 
    }//GEN-LAST:event_JBStartActionPerformed

    private void JBPrevPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPrevPlayerActionPerformed
        if (players.size() > _currentPlayerIndex) {
            players.get(_currentPlayerIndex).setColor(jColorChooser1.getColor());
            players.get(_currentPlayerIndex).setName(JTFName.getText());
            players.get(_currentPlayerIndex).setPlayerIcon(Icon.getIconMap().get(JCBIcon.getSelectedItem()));
        }
        else if(players.size()==Settings.PlayersLimit)
        {
            setCurrentPlayerIndex(_currentPlayerIndex -= 1);
            players.get(_currentPlayerIndex).setColor(jColorChooser1.getColor());
            players.get(_currentPlayerIndex).setName(JTFName.getText());
        }
        setCurrentPlayerIndex(_currentPlayerIndex -= 1);
        JTFName.setText(players.get(_currentPlayerIndex).toString());
        jColorChooser1.setColor(players.get(_currentPlayerIndex).getColor());
    }//GEN-LAST:event_JBPrevPlayerActionPerformed

    private void JBNextPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNextPlayerActionPerformed
        if (players.size() > _currentPlayerIndex) {
            players.get(_currentPlayerIndex).setColor(jColorChooser1.getColor());
            players.get(_currentPlayerIndex).setName(JTFName.getText());
            players.get(_currentPlayerIndex).setPlayerIcon(Icon.getIconMap().get(JCBIcon.getSelectedItem()));
        }        
        setCurrentPlayerIndex(_currentPlayerIndex += 1);
        if (players.size() < _currentPlayerIndex) {
            players.add(new Player(players.size(),
                    JTFName.getText(),
                    jColorChooser1.getColor(),
                    Icon.getIconMap().get(JCBIcon.getSelectedItem())));
            if (players.size() < Settings.PlayersLimit) {
                JTFName.setText("");
                jColorChooser1.setColor(Color.WHITE);
                JCBIcon.setSelectedIndex(0);
            }
            if (players.size() > 1) {
                JBStart.setEnabled(true);
            }
        } else if (players.size() > _currentPlayerIndex) {
            JTFName.setText(players.get(_currentPlayerIndex).toString());
            jColorChooser1.setColor(players.get(_currentPlayerIndex).getColor());
        } else if (players.size() !=Settings.PlayersLimit){
            JTFName.setText("");
            jColorChooser1.setColor(Color.WHITE);
            JCBIcon.setSelectedIndex(0);
        }


    }//GEN-LAST:event_JBNextPlayerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBNextPlayer;
    private javax.swing.JButton JBPrevPlayer;
    private javax.swing.JButton JBStart;
    private javax.swing.JComboBox<String> JCBIcon;
    private javax.swing.JTextField JTFName;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
