package com.backfield.imagegenerator

import java.awt.image.BufferedImage
import java.util.Random

object ImageDraw {

  val baseColor: Int = 0x313A75

  val baseColorPalette: List[Int] = List(0x182157, 0x080F3A, 0x525B92, 0x7C93AF)

  val compliment: Int = 0xAA8A39

  val complimentPalette: List[Int] = List(0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00)

  val drawables: List[(BufferedImage, Int, Int, Int, Int) => Unit] = List(
    new DrawSquare().drawIt,
    DrawUpperRightTriangle.draw,
    DrawUpperLeftTriangle.draw,
    DrawLowerRightTriangle.draw,
    DrawLowerLeftTriangle.draw
  )

  def nextColor(rand: Float): Int = {
    if (rand < 0.1) {
      if (rand < 0.6) {
        compliment
      } else {
        complimentPalette((rand * 4).toInt)
      }
    } else {
      if (rand < 0.6) {
        baseColor
      } else {
        baseColorPalette((rand * 4).toInt)
      }
    }
  }

  def draw(random: Random, squareSize: Int, numberOfSquares: Int): BufferedImage = {
    val image = new BufferedImage(
      squareSize * numberOfSquares,
      squareSize * numberOfSquares,
      BufferedImage.TYPE_INT_RGB
    )
    for (x <- 0 until numberOfSquares) {
      for (y <- 0 until numberOfSquares) {
        ImageDraw.drawables(
          random.nextInt(
            ImageDraw.drawables.size
          )
        )(
            image,
            ImageDraw.nextColor(random.nextFloat()),
            x,
            y,
            squareSize
          )
      }
    }
    image
  }
}
