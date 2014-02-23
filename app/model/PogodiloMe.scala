package model

import scala.slick.lifted.Tag
import play.api.db.slick.Config.driver.simple._

case class User(id: Option[Int] = None, display_name: Option[String] = None, email: Option[String] = None, picture: Option[String] = None, google_id: Option[String] = None, role: Option[String] = None)

class Users(tag: Tag) extends Table[User](tag, "user"){
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def display_name = column[String]("display_name", O.Nullable)
	def email = column[String]("email", O.Nullable)
	def picture = column[String]("picture", O.Nullable)
	def google_id = column[String]("google_id", O.Nullable)
	def role = column[String]("role", O.Nullable)
	
	def * = (id.?, display_name.?, email.?, picture.?, google_id.?, role.?) <> (User.tupled, User.unapply _)
}
