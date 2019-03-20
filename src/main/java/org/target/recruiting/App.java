package org.target.recruiting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.target.recruiting.avro.files.*;

import java.io.File;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple app to recursively list all files in the passed directory.
 */
public class App {
    public static void main(String[] args) {
        String mountpoint = args[0];
        File root = new File(mountpoint);
        System.out.println("Finding files located under: " + mountpoint);

        if (Files.exists(root.toPath())){

            List<org.target.recruiting.avro.files.File> avroFiles = new LinkedList<>();
            for (File f : getListOfFiles(root)){
                org.target.recruiting.avro.files.File.Builder fileBuilder = org.target.recruiting.avro.files.File.newBuilder();
                fileBuilder.setFilename(f.getPath());
                fileBuilder.setSize(f.length());
                avroFiles.add(fileBuilder.build());
            }

            FileList.Builder fileList = FileList.newBuilder();
            fileList.setFiles(avroFiles);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(fileList.build().toString());
            String prettyJsonString = gson.toJson(je);

            System.out.println(prettyJsonString);
        }
    }

    /**
     * Recursively retrieve the list of files stored under this directory.
     * @param root The root {@link File}to search under. It is assumed that this file exists or an Exception will be thrown.
     * @return A {@link LinkedList} of all the files stored under the given directory.
     */
    protected static List<File> getListOfFiles(File root){ ;
        List<File> files = new LinkedList<>();

        if (Files.isDirectory(root.toPath())){
            for (File f : root.listFiles()){
                files.addAll(getListOfFiles(f));
            }
        } else {
            files.add(root);
        }

        return files;
    }
}
