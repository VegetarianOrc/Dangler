package com.amazzeo.dangler

import com.amazzeo.dangler.speechutils._
import scala.concurrent.duration._
import scala.util.Random

class DanglerSequence(interval: FiniteDuration, duration: FiniteDuration) {
  val Ending = "Workout ended."

  val doc: SsmlDoc = {
    val d = new SsmlDoc()
    val numIntervals = duration.toMillis / interval.toMillis
    for (i <- 0 to numIntervals.toInt) {
      Random.nextInt(3) match {
        case 0 => d.addNode(ColorNodes.Red)
        case 1 => d.addNode(ColorNodes.Green)
        case 2 => d.addNode(ColorNodes.Yellow)
      }

      if ( i < numIntervals) {
        d.addNode(BreakNode(XStrongBreak, interval))
      } else {
        d.addNode(BreakNode(XStrongBreak, 1.second))
        d.addNode(PlainTextNode(Ending))
      }
    }
    d
  }

  def getOutputSpeech() = SsmlOutputSpeech(doc.toString)

}
