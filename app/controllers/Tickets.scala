package controllers

import play.api._
import play.api.mvc._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import model.Tables._

object Tickets extends Controller {
  def list = DBAction { implicit rs =>
    val query = for {
      ((((bt, btm),m),c1),c2) <- (BetTicket leftJoin BetTicketMatches on (_.id === _.betTicketId) 
      										leftJoin Match on (_._2.matchId === _.id) 
      										leftJoin Competitor on (_._2.home === _.id) 
      										leftJoin Competitor on (_._1._2.visitor === _.id))
    } yield (bt,m,(c1,c2))

    val query2 = for {
      btm <- BetTicketMatches
      bt <- btm.betTicketFk
      m <- btm.matchFk
      c1 <- m.competitorFk1
      c2 <- m.competitorFk2
    } yield (bt,m,(c1,c2))
    
    val d = query.list diff query2.list
    
    val result = query.list.groupBy(_._1).mapValues(_ map (x => (x._2, x._3))).mapValues(_ groupBy (_._1)).mapValues(_.mapValues(_ map (_._2)))
    Ok(result.head.toString + "\n\n" + result.mkString("\n\n") + "\n\n" + d.toString)
  }
}