package com.amazzeo.dangler

import com.amazon.speech.slu.Intent
import com.amazon.speech.speechlet.{
  IntentRequest,
  LaunchRequest,
  Session,
  SessionEndedRequest,
  SessionStartedRequest,
  Speechlet,
  SpeechletRequest
}

import com.amazzeo.dangler.speechutils._

class DanglerSpeechlet extends Speechlet {

  val danglerManager = DanglerManager()

  def logInvocation(name:String, request: SpeechletRequest, session: Session) = {
    println(s"${name} requestID=${request.getRequestId} sessionId=${session.getSessionId}")
  }

  override def onSessionStarted(request: SessionStartedRequest, session: Session): Unit = {
    logInvocation("onSessionStarted", request, session)
  }

  override def onLaunch(request: LaunchRequest, session: Session): SpeechletResponse = {
    logInvocation("onLaunch", request, session)

    val outputSpeech = new PlainTextOutputSpeech("What do you want to know?")

    new SpeechletResponse(outputSpeech)
  }

  override def onIntent(request: IntentRequest, session: Session): SpeechletResponse = {
    logInvocation("onIntent", request, session)

    val intent = request.getIntent

    intent.getName match {
      case "StartDangling" =>
        danglerManager.getStartDanglingIntentResponse(intent)

      case _ =>
        throw new IllegalArgumentException("Unrecognized intent: " + intent.getName())
    }


  }

  override def onSessionEnded(request: SessionEndedRequest, session: Session): Unit = {
    logInvocation("onSessionEnded", request, session)
  }
}
