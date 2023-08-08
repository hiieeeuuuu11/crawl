package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Hello world!");
        Crawler crawler = new Crawler();
        //crawler.getAllChap("https://kenhsinhvien.vn/forum/conan-reading-room.510/");
        Crawler_Image crawler_image = new Crawler_Image();
        //crawler_image.getImageByChap("https://kenhsinhvien.vn/topic/conan-chap-1115-tieng-viet.881884/");
        ///crawler_image.saveImg("https://cdn.kenhsinhvien.vn/data/2023/06/441379_Conan-1115-00.jpg");
        //crawler_image.saveAllImage("https://kenhsinhvien.vn/topic/conan-chap-1115-tieng-viet.881884/");
        crawler.saveAllImageAllChap("https://kenhsinhvien.vn/forum/conan-reading-room.510/");
    }
}