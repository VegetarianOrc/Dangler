package com.amazzeo.dangler.speechutils

import scala.concurrent.duration._
import scala.util.Random

object Node {
  def apply(text:String) = new Node(text)
}

class Node(text:String) {
  override def toString() = text
}

object BreakNodes {
  class BreakNode( strength: BreakStrength, time: FiniteDuration) extends Node(s"""<break strength="${strength}" time="${time.toMillis}ms"/>""")

  case object NoBreakNode extends BreakNode(NoBreak,0.seconds)
  case class XWeakBreakNode(duration: FiniteDuration) extends BreakNode(XWeakBreak, duration)
  case class WeakBreakNode(duration: FiniteDuration) extends BreakNode(WeakBreak, duration)
  case class MediumBreakNode(duration: FiniteDuration) extends BreakNode(MediumBreak, duration)
  case class StrongBreakNode(duration: FiniteDuration) extends BreakNode(StrongBreak, duration)
  case class XStrongBreakNode(duration: FiniteDuration) extends BreakNode(XStrongBreak, duration)
}



object ColorNodes {
  case object Red extends Node("red")

  case object Green extends Node("green")

  case object Yellow extends Node("yellow")

  private val values = Array(Red, Green, Yellow)

  def getRandom(): Node = {
    values(Random.nextInt(3))
  }
}


object SsmlDoc {
  def apply(children: Seq[Node] = Seq.empty[Node]) = new SsmlDoc(children)
}

class SsmlDoc(var children:Seq[Node] = Seq.empty[Node]) {

  def ++(s: Seq[Node]) = {
    children = (children ++ s)
  }

  def :+(n: Node) = {
    children = children :+ n
  }

  override def toString() = s"<speak>${children.map(_.toString).mkString}</speak>"

}
