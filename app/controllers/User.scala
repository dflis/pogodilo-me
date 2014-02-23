package controllers

import play.api._
import play.api.mvc._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import model._
import scala.slick.lifted.TableQuery

object User extends Controller {
  val users = TableQuery[Users]
  def list = DBAction { implicit rs =>
    val query = for {
      u <- users
    } yield (u)
    Ok(views.html.users(query.list))
  }
}