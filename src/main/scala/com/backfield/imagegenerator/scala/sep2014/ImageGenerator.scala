package com.backfield.imagegenerator.scala.sep2014

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object ImageGenerator {

  val squareSize = 20

  val numberOfSquares = 10

  val draw : Map[Symbol, (BufferedImage, Int, Int, Int) => Unit] = Map(
    'SQUARE -> ((image, x, y, color) => {
      for (squareX <- 0 until squareSize; squareY <- 0 until squareSize) {
        image.setRGB(x * squareSize + squareX, y * squareSize + squareY, color)
      }
    }),
    'UPPERLEFTTRIANGLE -> ((image, x, y, color) => {
      for (squareX <- 0 until squareSize; squareY <- 0 until (squareSize - squareX)) {
        image.setRGB(x * squareSize + squareX, y * squareSize + squareY, color)
      }
    }),
    'LOWERLEFTTRIANGLE -> ((image, x, y, color) => {
      for (squareX <- 0 until squareSize; squareY <- squareX until squareSize) {
        image.setRGB(x * squareSize + squareX, y * squareSize + squareY, color)
      }
    }),
    'UPPERRIGHTTRIANGLE -> ((image, x, y, color) => {
      for (squareX <- 0 until squareSize; squareY <- 0 until squareX) {
        image.setRGB(x * squareSize + squareX, y * squareSize + squareY, color)
      }
    }),
    'LOWERRIGHTTRIANGLE -> ((image, x, y, color) => {
      for(squareX <- 0 until squareSize; squareY <- (squareSize - squareX) until squareSize) {
        image.setRGB(x * squareSize + squareX, y * squareSize + squareY, color)
      }
    })
  )

  val drawTypes = draw.keys.toList

  def main(args : Array[String]) : Unit = {
    val image = new BufferedImage(squareSize * numberOfSquares, squareSize * numberOfSquares, BufferedImage.TYPE_INT_RGB)
    for(x <- 0 until numberOfSquares; y <- 0 until numberOfSquares) {
      draw(
        drawTypes(
          Randomness().nextInt(
            drawTypes.size
          )
        )
      )(image, x, y, Color.nextColor)
    }
    val file = new File("test.png")
    ImageIO.write(image, "png", file)
  }

}
