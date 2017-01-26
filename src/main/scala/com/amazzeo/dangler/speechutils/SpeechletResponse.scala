package com.amazzeo.dangler.speechutils


import com.amazon.speech.speechlet.{SpeechletResponse => SR}
import com.amazon.speech.ui.{Card, OutputSpeech, Reprompt}

case class SpeechletResponse(
  outputSpeech: OutputSpeech = null,
  card: Card = null,
  reprompt: Reprompt = null,
  shouldEndSession: Boolean = true
) extends SR {
  setOutputSpeech(outputSpeech)
  setCard(card)
  setReprompt(reprompt)
  setShouldEndSession(shouldEndSession)
}
