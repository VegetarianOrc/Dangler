package com.amazzeo.dangler.speechutils

sealed trait BreakStrength

case object NoBreak extends BreakStrength {
  override def toString() = "none"
}
case object XWeakBreak extends BreakStrength {
  override def toString() = "x-weak"
}
case object WeakBreak extends BreakStrength {
  override def toString() = "weak"
}
case object MediumBreak extends BreakStrength {
  override def toString() = "medium"
}
case object StrongBreak extends BreakStrength {
  override def toString() = "strong"
}
case object XStrongBreak extends BreakStrength {
  override def toString() = "x-strong"
}
