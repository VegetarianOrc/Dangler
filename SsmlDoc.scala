package com.amazzeo.dangler.speechutils

import scala.duration._

case class BreakStrength(str: String)
case object NoBreak extends BreakStrength("none")
case object XWeakBreak extends BreakStrength("x-weak")
case object WeakBreak extends BreakStrength("weak")
case object MediumBreak extends BreakStrength("medium")
case object StrongBreak extends BreakStrength("strong")
case object XStrongBreak extends BreakStrength("x-strong")

case class BreakNode( strength: BreakStrength, time: FitineDuration) {
  def mkString() = s"<break strength=${strength.str} time=${time.toMillis}ms/>"
}
