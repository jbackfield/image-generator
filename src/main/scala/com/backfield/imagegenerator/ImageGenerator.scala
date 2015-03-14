package com.backfield.imagegenerator

import javax.imageio.ImageIO
import java.io.File
import java.util.Random

object ImageGenerator {

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      throw new IllegalArgumentException("Expected one argument")
    }
    args.foreach { s =>
      ImageIO.write(
        ImageDraw.draw(
        {
          val random = new Random(); random.setSeed(s.hashCode); random
        },
        20,
        10
        ),
        "png",
        new File(s"$s.png")
      )
    }

  }

}
