package org.target.recruiting;

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
            for (File f : getListOfFiles(root)){
                System.out.println(f.getPath());
            }
        }
    }

    /**
     * Recursively retrieve the list of files stored under this directory.
     * @param root The root {@link File}to search under. It is assumed that this file exists or an Exception will be thrown.
     * @return A {@link LinkedList} of all the files stored under the given directory.
     */
    private static List<File> getListOfFiles(File root){ ;
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
