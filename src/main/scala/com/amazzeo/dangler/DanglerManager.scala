package com.amazzeo.dangler

import com.amazzeo.dangler.speechutils._
import com.amazon.speech.slu.Intent
import scala.concurrent.duration._

object DanglerManager {
  val SLOT_INTERVAL = "interval"
  val SLOT_DURATION = "duration"
  def apply(): DanglerManager = new DanglerManager()
}

class DanglerManager() {
  import DanglerManager._

  implicit def iso8601DurationToFiniteDuration(str:String): FiniteDuration = {
    val jd = java.time.Duration.parse(str)
    Duration.create(jd.toMillis, "ms")
  }

  def getStartDanglingIntentResponse(intent: Intent):SpeechletResponse = {

    val interval:FiniteDuration = intent.getSlot(SLOT_INTERVAL).getValue()
    val duration:FiniteDuration = intent.getSlot(SLOT_DURATION).getValue()

    val sequence = new DanglerSequence(interval, duration)

    SpeechletResponse(sequence.getOutputSpeech)


  }
}
