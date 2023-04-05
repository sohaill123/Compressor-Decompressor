package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import comp_decomp.compressor;
import comp_decomp.decompressor;


public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        compressButton=new JButton("select the file to compress");
        decompressButton=new JButton("select the file to decompressor");
        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(300,300);
        this.setLocation(500,200);
        this.getContentPane().setBackground(Color.BLUE);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);

                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decompressor.method(file);

                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}