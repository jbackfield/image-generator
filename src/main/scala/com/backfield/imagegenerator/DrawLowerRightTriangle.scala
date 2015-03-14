package com.backfield.imagegenerator

;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
object DrawLowerRightTriangle {

  def draw(image: BufferedImage, color: Int, x: Int, y: Int, squareSize: Int): Unit = {
    for (squareX <- 0 until squareSize; squareY <- (squareSize - squareX) until squareSize) {
      image.setRGB(
        x * squareSize + squareX,
        y * squareSize + squareY,
        color
      )
    }
  }
}
