package com.backfield.imagegenerator

;

import java.awt.image.BufferedImage;

/**
 * Created by jbackfield on 3/12/15.
 */
class DrawSquare {

  def drawIt(image: BufferedImage, color: Int, x: Int, y: Int, squareSize: Int): Unit = {
    for (squareX <- 0 until squareSize; squareY <- 0 until squareSize) {
      image.setRGB(
        x * squareSize + squareX,
        y * squareSize + squareY,
        color
      )
    }
  }
}
