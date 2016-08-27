package at.froehlich;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DownloadandSaveWebPage {

    public static void main(String[] args) {

        URL url;
        Calendar calendar = Calendar.getInstance();

        try {
            //Genarate a TimeStampe
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            // enter any url to get its content
            url = new URL("http://ref.pascalfroehlich.at/index.html");
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;

            // save it anywhere in local machine for offline use
            String fileName = "C:\\Users\\derGamer\\OneDrive\\Dokumente\\WebPage\\RefWebpage"+ timeStamp +".html";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }

            bw.close();
            br.close();

            System.out.println("Your file is saved in " + fileName
                    + " location.");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

