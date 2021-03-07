package com.lkroll.testing

import org.scalajs.dom
import dom.{ document, window }

object MainApp {

  def main(args: Array[String]): Unit = {
    println("Starting 'application-part'...");

    val p = document.createElement("p");
    val text = document.createTextNode(s"Hello at version ${TestJSCode.version}");
    p.appendChild(text);
    document.body.appendChild(p);
  }

}
