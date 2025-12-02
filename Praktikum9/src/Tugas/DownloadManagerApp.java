package Tugas;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

public class DownloadManagerApp {
    private static JProgressBar progressBar1, progressBar2, progressBar3;
    private static JButton downloadButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Download Manager App");
        frame.setLayout(null);

        progressBar1 = new JProgressBar(0, 100);
        progressBar1.setStringPainted(true);
        progressBar1.setBounds(50, 60, 300, 30); 

        progressBar2 = new JProgressBar(0, 100);
        progressBar2.setStringPainted(true);
        progressBar2.setBounds(50, 120, 300, 30);  

        progressBar3 = new JProgressBar(0, 100);
        progressBar3.setStringPainted(true);
        progressBar3.setBounds(50, 180, 300, 30); 

        // Membuat tombol download
        downloadButton = new JButton("Downloading");
        downloadButton.setBounds(150, 230, 120, 30); 
        downloadButton.addActionListener(e -> startDownloads());

        
        JLabel label1 = new JLabel("File 1");
        label1.setBounds(50, 40, 100, 20); 
        frame.add(label1);
        frame.add(progressBar1);

        JLabel label2 = new JLabel("File 2");
        label2.setBounds(50, 100, 100, 20); 
        frame.add(label2);
        frame.add(progressBar2);

        JLabel label3 = new JLabel("File 3");
        label3.setBounds(50, 160, 100, 20); 
        frame.add(label3);
        frame.add(progressBar3);

        frame.add(downloadButton);

      
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // Center the window
    }

    public static void startDownloads() {
        new Thread(() -> simulateDownload(progressBar1, "File 1", 500)).start();
        new Thread(() -> simulateDownload(progressBar2, "File 2", 800)).start();
        new Thread(() -> simulateDownload(progressBar3, "File 3", 300)).start();
    }

    public static void simulateDownload(JProgressBar progressBar, String fileName, int sleepTime) {
        for (int i = 10; i <= 100; i += 10) {
            try {
                Thread.sleep(sleepTime);  
                final int progress = i; 
                SwingUtilities.invokeLater(() -> progressBar.setValue(progress)); 
                System.out.println(fileName + " progress: " + i + "%");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fileName + " selesai diunduh!");
    }
}
