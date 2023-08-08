package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crawler {

    public List<Chap> getAllChap(String url) throws IOException {
        ArrayList<Chap> list_chap = new ArrayList<>();
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByClass("structItem-title");
        for (int i=0 ;i<elements.size();i++){
            Elements elements1= elements.get(i).getElementsByTag("a");
            for (int j = 0;j<elements1.size();j++){
                String url1 = elements1.get(j).absUrl("href");
                list_chap.add(new Chap(url1));
            }
        }
        //list_chap.forEach(chap -> System.out.println(chap.getUrl()));
        return list_chap;
    }


    public void saveAllImageAllChap(String url) throws IOException {
        Crawler_Image crawler_image = new Crawler_Image();
        List<String> strings = getAllChap(url).stream()
                .map(Chap::getUrl).toList();
        strings.forEach(s -> {
            try {
                crawler_image.saveAllImage(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
