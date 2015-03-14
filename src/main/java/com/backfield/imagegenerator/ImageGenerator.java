package com.backfield.imagegenerator;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ImageGenerator {

    public static interface Invokable<T> {
        public void invoke(T obj);
    }

    public static <T> void forEach(List<T> input, Invokable<T> func) {
        for(T obj : input) {
            func.invoke(obj);
        }
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            throw new IllegalArgumentException("Expected one argument");
        }
        forEach(
                Arrays.asList(args),
                new Invokable<String>() {
                    @Override
                    public void invoke(String s) {
                        File file = new File(s + ".png");
                        try {
                            Random random = new Random();
                            random.setSeed(s.hashCode());
                            ImageIO.write(ImageDraw.draw(random, 20, 10), "png", file);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }

}
