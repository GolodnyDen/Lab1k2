package Lab4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "C:/Users/User/Desktop/Lab1k2/Lab4/source.txt"; 
        String destinationFilePath = "./destination.txt"; 

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(sourceFilePath);
            File destinationFile = new File(destinationFilePath);

            if (!sourceFile.exists()) {
                throw new IOException("The source file does not exist: " + sourceFilePath);
            }

            // Создание потоков для чтения и записи
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFile);

            // Чтение и запись данных
            byte[] buffer = new byte[1024]; // Буфер для чтения данных
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("The copy was completed successfully.");

        } catch (IOException e) {
            System.out.println("Error when working with files: " + e.getMessage());
            ErrorLogger.logException(e); // Логирование ошибки
        } finally {
            // Закрытие потоков
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
                ErrorLogger.logException(e); // Логирование ошибки закрытия потока
            }
        }
    }
}
