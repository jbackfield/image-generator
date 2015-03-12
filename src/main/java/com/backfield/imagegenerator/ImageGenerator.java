package com.backfield.imagegenerator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class ImageGenerator {

    public static void main(String[] args) {
        if(args.length == 0) {
            throw new IllegalArgumentException("Expected one argument");
        }
        Arrays.asList(args).forEach((s) -> {
            File file = new File(s + ".png");
            try {
                Random random = new Random();
                random.setSeed(s.hashCode());
                ImageIO.write(ImageDraw.draw(random, 20, 10), "png", file);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
