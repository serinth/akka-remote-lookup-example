import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorIdentity
import akka.actor.Identify
import Constants._

object RemoteLookup {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("LookupSystem", ConfigFactory.load("lookup"))
    val remotePath = "akka.tcp://EmailSystem@127.0.0.1:2552/user/Emailer"
    val actor = system.actorOf(Props(classOf[LookupEmailer], remotePath), "Emailer")
  }
}



class LookupEmailer(path: String) extends Actor {

  context.actorSelection(path) ! Identify(path)

  def receive = {

    case ActorIdentity(`path`, Some(actor)) => {
      actor ! SendMail("MySubject","MyBody","FROMPerson","ToPerson")
      context.system.terminate()
    }

    case ActorIdentity(`path`, None) => println(s"Remote actor not available: $path")

    case _ => println("Not ready yet")
  }

}