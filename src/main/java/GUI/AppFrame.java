package GUI;

import compressor_decompressor.compressor;
import compressor_decompressor.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 120, 200, 30);

        decompressButton = new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(260, 120, 200, 30);

        this.add(compressButton);
        this.add(decompressButton);

        this.setTitle("Compressor And Decompressor");
        this.setSize(500, 500);
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(Color.GREEN);
        this.setLocation(400, 300);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser choos = new JFileChooser();
            int response = choos.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(choos.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser choos = new JFileChooser();
            int response = choos.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(choos.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }

}
