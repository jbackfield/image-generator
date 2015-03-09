package com.backfield.imagegenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageGenerator {

    @Resource(name = "imageDraw")
    ImageDraw imageDraw;

    @Value("${file.name}")
    String fileName;

    public void generateImageForString(String str) {
        imageDraw.setSeed(str.hashCode());
        File file = new File(fileName);
        try {
            ImageIO.write(imageDraw.draw(), "png", file);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            throw new IllegalArgumentException("Expected email as argument");
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        ImageGenerator imageGenerator = (ImageGenerator) applicationContext.getBean("imageGenerator");

        imageGenerator.generateImageForString(args[0]);
    }

}
