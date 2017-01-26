package com.amazzeo.dangler.speechutils

import scala.concurrent.duration._

trait Node

case class BreakNode( strength: BreakStrength, time: FiniteDuration) extends Node {
  override def toString() = s"""<break strength="${strength}" time="${time.toMillis}ms"/>"""
}

object ColorNodes {
  sealed trait ColorNode extends Node
  case object Red extends ColorNode {
    override def toString() = "red"
  }

  case object Green extends ColorNode {
    override def toString() = "green"
  }

  case object Yellow extends ColorNode {
    override def toString() = "yellow"
  }
}

case class PlainTextNode(text: String) extends Node {
  override def toString() = text
}

class SsmlDoc {
  private var children: Seq[Node] = Seq()

  def addNode(n: Node) = {
    children = children :+ n
  }

  override def toString() = s"<speak>${children.map(_.toString).mkString}</speak>"

}
