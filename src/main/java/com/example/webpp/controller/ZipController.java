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
        File filename = new File("src/main/resources/in.txt");
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\I\\IdeaProjects\\WebPP\\src\\main\\resources\\out.zip"));
            FileInputStream fis= new FileInputStream(filename);)
        {
            ZipEntry entry1=new ZipEntry("src/main/resources/in.txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        extracted();
        return "test"  ;
    }

    private static void extracted() {
        File filename1 = new File("C:\\Users\\I\\IdeaProjects\\WebPP\\src\\main\\resources\\out.zip");
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(filename1)))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                System.out.printf("File name: %s \n", name);

                // распаковка
                FileOutputStream fout = new FileOutputStream("new" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
//                    fout.write(c);
                    System.out.println(c);
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
