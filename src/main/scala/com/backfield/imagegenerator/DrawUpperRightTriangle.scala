package com.backfield.imagegenerator

;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
object DrawUpperRightTriangle {

  def draw(image: BufferedImage, color: Int, x: Int, y: Int, squareSize: Int) {
    for (squareX <- 0 until squareSize; squareY <- 0 until squareX) {
      image.setRGB(
        x * squareSize + squareX,
        y * squareSize + squareY,
        color
      )
    }
  }
}
