package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = new URL("https://images.ctfassets.net/hrltx12pl8hq/3MbF54EhWUhsXunc5Keueb/60774fbbff86e6bf6776f1e17a8016b4/04-nature_721703848.jpg?fit=fill&w=480&h=270").openStream();
        Files.copy(in, Paths.get("/home/eug1n1/Win.jpg"), StandardCopyOption.REPLACE_EXISTING);
    }
}
