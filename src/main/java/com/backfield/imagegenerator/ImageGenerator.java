package com.backfield.imagegenerator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

public class ImageGenerator {

    @Resource(name = "imageDraw")
    ImageDraw imageDraw;

    public void generateImageForString(String str) {
        imageDraw.setSeed(str.hashCode());
        File file = new File(str + ".png");
        try {
            ImageIO.write(imageDraw.draw(), "png", file);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if(args.length != 0) {
            throw new IllegalArgumentException("Expected one argument");
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        ImageGenerator imageGenerator = (ImageGenerator) applicationContext.getBean("imageGenerator");

        imageGenerator.generateImageForString(args[0]);
    }

}
