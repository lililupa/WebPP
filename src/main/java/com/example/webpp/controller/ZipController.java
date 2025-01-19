package com.example.webpp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Controller
public class ZipController {
    @GetMapping ("/zip")
    public String controller(){
        zipWrite();

        zipRead();
        return "test"  ;
    }

    private static void zipWrite() {
        File filename = new File("src/main/resources/in.txt");
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("src/main/resources/out.zip"));
            FileInputStream fis= new FileInputStream(filename);)
        {
            ZipEntry entry1=new ZipEntry("src/main/resources/in.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    private static void zipRead() {
        File filename1 = new File("src/main/resources/out.zip");
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(filename1)))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName();
                System.out.printf("File name: %s \n", name);

                FileOutputStream fout = new FileOutputStream("src/main/resources/out.txt");
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
