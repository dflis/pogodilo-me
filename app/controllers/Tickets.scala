package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.mvc._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import model.Tables._

case class UserTip(user: Int, tournament: Int, matchid: Int, tip: String)

object Tickets extends Controller {

  def list(tId: Int = 1) = DBAction { implicit rs =>
    val query = for {
      ((((bt, btm),m),c1),c2) <- (BetTicket leftJoin BetTicketMatches on (_.id === _.betTicketId)
        leftJoin Match on (_._2.matchId === _.id)
        leftJoin Competitor on (_._2.home === _.id)
        leftJoin Competitor on (_._1._2.visitor === _.id)) if m.tournamentId === tId
    } yield (bt,m,(c1,c2,btm))

    val result = query.list.groupBy(x=>(x._1,x._2)).mapValues(_ map (_._3)).groupBy(_._1._1)
    Ok(views.html.tickets(result))
  }

  val tipForm = Form(
    mapping(
      "user" -> number,
      "tournament" -> number,
      "match" -> number,
      "tip" -> text
    )(UserTip.apply)(UserTip.unapply)
  )

  def tip = Action {
    Ok(views.html.tipForm(tipForm))
  }
}