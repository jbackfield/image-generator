package com.backfield.imagegenerator.scala.sep2014

import java.security.SecureRandom

object Randomness {

  val random = {
    val r = new SecureRandom()
    r.setSeed("jbackfield@secureworks.com".getBytes)
    r
  }

  def apply() : SecureRandom = random

}
