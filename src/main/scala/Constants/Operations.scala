package Constants

abstract class EmailOperation
case class SendMail(subject:String,body:String,from:String,to:String) extends EmailOperation