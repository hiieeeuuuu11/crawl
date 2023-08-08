package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Crawler_Image {

    public List<String> getImageByChap(String chap_url) throws IOException {
        ArrayList<String> list_image = new ArrayList<>();
        Document document = Jsoup.connect(chap_url).get();
        Elements elements = document.getElementsByClass("bbImage");
        for (int j = 0;j<elements.size();j++){
            String url = elements.get(j).absUrl("src");
            list_image.add(url);
        }
        list_image.forEach( image -> System.out.println(image));
        return list_image;
    }

    public void saveImg(String img_src) throws IOException, URISyntaxException {
        URL url1 = new URI(img_src).toURL();
        String[] name = img_src.split("/");
        InputStream inputStream = url1.openStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\JavaIntelliJ\\crawl\\image\\"+name[6]+".png"));

        int data = inputStream.read();
        while (data!=-1){
            out.write(data);
            data = inputStream.read();
        }
        out.close();
        inputStream.close();

    }

    public void saveAllImage(String chap_url) throws IOException {
        List<String> images = getImageByChap(chap_url);
        images.forEach(image -> {
            try {
                saveImg(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
