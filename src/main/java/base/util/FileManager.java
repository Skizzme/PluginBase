package base.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static Gson builder = new GsonBuilder().setPrettyPrinting().create();

    public static boolean write(File file, String data) {
        try{
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            writer.write(data);

            return true;
        } catch (IOException ignored) { }
        return false;
    }

    public static String readFile(File file) {
        try{
            if (file.exists()) {
                StringBuilder builder = new StringBuilder();
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    builder.append(line);
                }
                return builder.toString();
            }else {
                return null;
            }
        } catch (Exception ignored) { }
        return null;
    }

    public static JsonObject readJsonFile(File file) {
        String data = readFile(file);
        return builder.fromJson(data, JsonObject.class);
    }

    public static void writeJsonFIle(File file, JsonObject json) {
//        JsonWriter writer = new JsonWriter();
    }

}
