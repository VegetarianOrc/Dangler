package com.amazzeo.dangler;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import com.amazzeo.dangler.DanglerSpeechlet;


public class DanglerSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
  private static final Set<String> supportedApplicationIds = new HashSet<String>();

  public DanglerSpeechletRequestStreamHandler() {
    super(new DanglerSpeechlet(), supportedApplicationIds);
  }
}
