package com.parsing.csv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WriterForOut {




    private static final String newLine = System.getProperty("line.separator");

    public synchronized static void writeToFile(List<String> msg, String linkOut)  {


        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy MM dd");//dd/MM/yyyy
        Date nowTime = new Date();

        String link[] = new File("").getAbsolutePath().split("\\\\");
        String linkString = link[0];
        for (int i = 1; i < link.length-1; i++) {
            linkString = linkString + "\\" + link[i];
        }
        linkString = linkString +"\\"+ "Prices "+sdfDate.format(nowTime)+".csv";

      //  System.out.println(linkString);


        String fileName = linkString;
        PrintWriter printWriter = null;
        File file = new File(fileName);
        try {
            if (!file.exists()) file.createNewFile();
            printWriter = new PrintWriter(new FileOutputStream(fileName, true));
            printWriter.write(newLine + msg);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }


}
