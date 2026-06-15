package com.sample.programs;

import java.io.File;

public class FolderContents {

    public static void listFolderContents(File folder, String indent) {
        if (folder.isDirectory()) {
            System.out.println(indent + "-- " + folder.getName());
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    listFolderContents(file, indent + "  ");
                }
            }
        } else {
            System.out.println(indent + "---- " + folder.getName());
        }
    }

    public static void main(String[] args) {
        // Change the path as per your local system
        String folderPath = "D:\\Interview\\KB Docs";  // For Windows
       
        // String folderPath = "/home/yourusername/Documents";     // For Linux/Mac

        File rootFolder = new File(folderPath);

        if (rootFolder.exists() && rootFolder.isDirectory()) {
            listFolderContents(rootFolder, "");
        } else {
            System.out.println("Invalid folder path: " + folderPath);
        }
    }
}

