package com.backfield.imagegenerator.scala.sep2014

object Color {

  val baseColor = 0x313A75

  val baseColorPalette = List(0x182157, 0x080F3A, 0x525B92, 0x7C93AF)

  val compliment = 0xAA8A39

  val complimentPalette = List(0xFFE7AA, 0xD4B66A, 0x806115, 0x553D00)

  def nextColor : Int = {
    val rand = Randomness().nextFloat()
    val (base, palette) = if(rand < 0.1) {
      (compliment, complimentPalette)
    } else {
      (baseColor, baseColorPalette)
    }
    if(rand < 0.6) {
      base
    } else {
      palette((rand * 4).toInt)
    }
  }

}
