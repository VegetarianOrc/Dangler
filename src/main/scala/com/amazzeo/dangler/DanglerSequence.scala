package com.amazzeo.dangler

import com.amazzeo.dangler.speechutils._
import scala.concurrent.duration._
import scala.util.Random

class DanglerSequence(interval: FiniteDuration, duration: FiniteDuration) {
  val INTRO = Seq(
    Node("Starting workout in 3"),
    BreakNodes.XStrongBreakNode(1.second),
    Node("2"),
    BreakNodes.XStrongBreakNode(1.second),
    Node("1")
    )

  val ENDING = Seq(BreakNodes.XStrongBreakNode(1.second), Node("Workout ended."))

  val doc: SsmlDoc = {
    val d = new SsmlDoc()
    d ++ INTRO
    val numIntervals = duration.toMillis / interval.toMillis
    for (i <- 0 to numIntervals.toInt) {
      if ( i < numIntervals) {
        d :+ ColorNodes.getRandom()
        d :+ BreakNodes.XStrongBreakNode(interval)
      }
    }
    d ++ ENDING
    d
  }

  def getOutputSpeech() = SsmlOutputSpeech(doc.toString)

}
