package controllers

import play.api._
import play.api.mvc._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import model.Tables._
import scala.slick.lifted.TableQuery

object Users extends Controller {
  def list = DBAction { implicit rs =>
    val query = for {
      u <- User
    } yield (u)
    Ok(views.html.users(query list))
  }
}