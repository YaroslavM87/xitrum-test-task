package app

import xitrum.Server
import scala.language.postfixOps

object Boot {

  def main(args: Array[String]): Unit = {

        Server.start()
        Server.stopAtShutdown()
  }

}