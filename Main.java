import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";     // Путь к исходному файлу
        String outputFilePath = "output.txt";   // Путь к файлу с обновленным программным кодом

        try (BufferedReader reader = new BufferedReader(new FileReader("commentaryFile"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("uncommentedFile"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Удаление однострочных комментариев
                line = line.replaceAll("//.*", "");

                // Удаление многострочных комментариев
                line = line.replaceAll("/\\*(.|[\\r\\n])*?\\*/", "");

                // Запись обновленной строки в новый файл
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Обновленный программный код записан в файл: " + "uncommentedFile");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
