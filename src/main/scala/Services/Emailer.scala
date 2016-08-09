package Services

import akka.actor.Actor
import Constants._
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.actor.Props


object EmailSystem {
    def main(args: Array[String]): Unit = {
      val system = ActorSystem("EmailSystem", ConfigFactory.load("creator"))
      val actor = system.actorOf(Props[Emailer], name = "Emailer")

      println("Started Email System")
    }
}

class Emailer extends Actor {
  def receive = {
    case SendMail(subject,body,from,to) =>
      println(s"Email Sent with Parameters: $subject $body $from $to")
    case _ =>
      println("Invalid Operation")
  }
}