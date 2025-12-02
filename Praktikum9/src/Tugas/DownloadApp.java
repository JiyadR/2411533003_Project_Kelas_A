package Tugas;

class DownloadTask implements Runnable {
    private String fileName;

    public DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int i = 10; i <= 100; i += 10) {
            System.out.println(fileName + " progress: " + i + "%");
            try {
                Thread.sleep(500); // simulasi waktu download
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fileName + " selesai diunduh!");
    }
}

public class DownloadApp {
    public static void main(String[] args) throws InterruptedException {
        // Membuat thread dengan lambda expression
        Thread t1 = new Thread(() -> new DownloadTask("File-1").run());
        Thread t2 = new Thread(() -> new DownloadTask("File-2").run());
        Thread t3 = new Thread(() -> new DownloadTask("File-3").run());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("\nDownloading...");

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Semua file selesai diunduh!");
    }
}
