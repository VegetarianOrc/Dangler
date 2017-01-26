package com.amazzeo.dangler.speechutils

import com.amazon.speech.ui.{PlainTextOutputSpeech => PTOS, SsmlOutputSpeech => SOS}

case class PlainTextOutputSpeech(text: String) extends PTOS {
  setText(text)
}

case class SsmlOutputSpeech(ssml: String) extends SOS {
  setSsml(ssml)
}
