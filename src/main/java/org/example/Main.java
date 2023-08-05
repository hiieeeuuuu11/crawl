package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Crawler crawler = new Crawler();
        crawler.getAllChap("https://kenhsinhvien.vn/forum/conan-reading-room.510/");
    }
}