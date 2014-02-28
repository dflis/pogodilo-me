package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Algorithm.ddl ++ AlgorithmParamSet.ddl ++ BetTicket.ddl ++ BetTicketMatches.ddl ++ Competitor.ddl ++ Match.ddl ++ MatchUserVotes.ddl ++ Tournament.ddl ++ TournamentAlgorithmParam.ddl ++ TournamentCompetitors.ddl ++ TournamentPhase.ddl ++ TournamentUsers.ddl ++ User.ddl
  
  /** Entity class storing rows of table Algorithm
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param implName Database column impl_name  */
  case class AlgorithmRow(id: Int, implName: String)
  /** GetResult implicit for fetching AlgorithmRow objects using plain SQL queries */
  implicit def GetResultAlgorithmRow(implicit e0: GR[Int], e1: GR[String]): GR[AlgorithmRow] = GR{
    prs => import prs._
    AlgorithmRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table algorithm. Objects of this class serve as prototypes for rows in queries. */
  class Algorithm(tag: Tag) extends Table[AlgorithmRow](tag, "algorithm") {
    def * = (id, implName) <> (AlgorithmRow.tupled, AlgorithmRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, implName.?).shaped.<>({r=>import r._; _1.map(_=> AlgorithmRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column impl_name  */
    val implName: Column[String] = column[String]("impl_name")
  }
  /** Collection-like TableQuery object for table Algorithm */
  lazy val Algorithm = new TableQuery(tag => new Algorithm(tag))
  
  /** Entity class storing rows of table AlgorithmParamSet
   *  @param id Database column id AutoInc
   *  @param algorithmId Database column algorithm_id 
   *  @param paramName Database column param_name  */
  case class AlgorithmParamSetRow(id: Int, algorithmId: Int, paramName: Int)
  /** GetResult implicit for fetching AlgorithmParamSetRow objects using plain SQL queries */
  implicit def GetResultAlgorithmParamSetRow(implicit e0: GR[Int]): GR[AlgorithmParamSetRow] = GR{
    prs => import prs._
    AlgorithmParamSetRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table algorithm_param_set. Objects of this class serve as prototypes for rows in queries. */
  class AlgorithmParamSet(tag: Tag) extends Table[AlgorithmParamSetRow](tag, "algorithm_param_set") {
    def * = (id, algorithmId, paramName) <> (AlgorithmParamSetRow.tupled, AlgorithmParamSetRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, algorithmId.?, paramName.?).shaped.<>({r=>import r._; _1.map(_=> AlgorithmParamSetRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc */
    val id: Column[Int] = column[Int]("id", O.AutoInc)
    /** Database column algorithm_id  */
    val algorithmId: Column[Int] = column[Int]("algorithm_id")
    /** Database column param_name  */
    val paramName: Column[Int] = column[Int]("param_name")
    
    /** Primary key of AlgorithmParamSet (database name algorithm_param_set_PK) */
    val pk = primaryKey("algorithm_param_set_PK", (id, algorithmId))
    
    /** Foreign key referencing Algorithm (database name fk_algorithm_param_algorithm1) */
    lazy val algorithmFk = foreignKey("fk_algorithm_param_algorithm1", algorithmId, Algorithm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AlgorithmParamSet */
  lazy val AlgorithmParamSet = new TableQuery(tag => new AlgorithmParamSet(tag))
  
  /** Entity class storing rows of table BetTicket
   *  @param id Database column id AutoInc
   *  @param tournamentPhaseId Database column tournament_phase_id 
   *  @param displayName Database column display_name 
   *  @param state Database column state 
   *  @param betsDue Database column bets_due 
   *  @param paidTime Database column paid_time  */
  case class BetTicketRow(id: Int, tournamentPhaseId: Int, displayName: String, state: String, betsDue: java.sql.Timestamp, paidTime: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching BetTicketRow objects using plain SQL queries */
  implicit def GetResultBetTicketRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[java.sql.Timestamp]]): GR[BetTicketRow] = GR{
    prs => import prs._
    BetTicketRow.tupled((<<[Int], <<[Int], <<[String], <<[String], <<[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table bet_ticket. Objects of this class serve as prototypes for rows in queries. */
  class BetTicket(tag: Tag) extends Table[BetTicketRow](tag, "bet_ticket") {
    def * = (id, tournamentPhaseId, displayName, state, betsDue, paidTime) <> (BetTicketRow.tupled, BetTicketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, tournamentPhaseId.?, displayName.?, state.?, betsDue.?, paidTime).shaped.<>({r=>import r._; _1.map(_=> BetTicketRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc */
    val id: Column[Int] = column[Int]("id", O.AutoInc)
    /** Database column tournament_phase_id  */
    val tournamentPhaseId: Column[Int] = column[Int]("tournament_phase_id")
    /** Database column display_name  */
    val displayName: Column[String] = column[String]("display_name")
    /** Database column state  */
    val state: Column[String] = column[String]("state")
    /** Database column bets_due  */
    val betsDue: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("bets_due")
    /** Database column paid_time  */
    val paidTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("paid_time")
    
    /** Primary key of BetTicket (database name bet_ticket_PK) */
    val pk = primaryKey("bet_ticket_PK", (id, tournamentPhaseId))
    
    /** Foreign key referencing TournamentPhase (database name fk_bet_ticket_tournament_phase1) */
    lazy val tournamentPhaseFk = foreignKey("fk_bet_ticket_tournament_phase1", tournamentPhaseId, TournamentPhase)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BetTicket */
  lazy val BetTicket = new TableQuery(tag => new BetTicket(tag))
  
  /** Entity class storing rows of table BetTicketMatches
   *  @param betTicketId Database column bet_ticket_id 
   *  @param matchId Database column match_id 
   *  @param betType Database column bet_type 
   *  @param coefficient Database column coefficient  */
  case class BetTicketMatchesRow(betTicketId: Int, matchId: Int, betType: Option[String], coefficient: Option[Double])
  /** GetResult implicit for fetching BetTicketMatchesRow objects using plain SQL queries */
  implicit def GetResultBetTicketMatchesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Double]]): GR[BetTicketMatchesRow] = GR{
    prs => import prs._
    BetTicketMatchesRow.tupled((<<[Int], <<[Int], <<?[String], <<?[Double]))
  }
  /** Table description of table bet_ticket_matches. Objects of this class serve as prototypes for rows in queries. */
  class BetTicketMatches(tag: Tag) extends Table[BetTicketMatchesRow](tag, "bet_ticket_matches") {
    def * = (betTicketId, matchId, betType, coefficient) <> (BetTicketMatchesRow.tupled, BetTicketMatchesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (betTicketId.?, matchId.?, betType, coefficient).shaped.<>({r=>import r._; _1.map(_=> BetTicketMatchesRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column bet_ticket_id  */
    val betTicketId: Column[Int] = column[Int]("bet_ticket_id")
    /** Database column match_id  */
    val matchId: Column[Int] = column[Int]("match_id")
    /** Database column bet_type  */
    val betType: Column[Option[String]] = column[Option[String]]("bet_type")
    /** Database column coefficient  */
    val coefficient: Column[Option[Double]] = column[Option[Double]]("coefficient")
    
    /** Primary key of BetTicketMatches (database name bet_ticket_matches_PK) */
    val pk = primaryKey("bet_ticket_matches_PK", (betTicketId, matchId))
    
    /** Foreign key referencing BetTicket (database name fk_bet_ticket_has_match_bet_ticket1) */
    lazy val betTicketFk = foreignKey("fk_bet_ticket_has_match_bet_ticket1", betTicketId, BetTicket)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Match (database name fk_bet_ticket_has_match_match1) */
    lazy val matchFk = foreignKey("fk_bet_ticket_has_match_match1", matchId, Match)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table BetTicketMatches */
  lazy val BetTicketMatches = new TableQuery(tag => new BetTicketMatches(tag))
  
  /** Entity class storing rows of table Competitor
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param displayName Database column display_name 
   *  @param shortName Database column short_name  */
  case class CompetitorRow(id: Int, displayName: Option[String], shortName: Option[String])
  /** GetResult implicit for fetching CompetitorRow objects using plain SQL queries */
  implicit def GetResultCompetitorRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[CompetitorRow] = GR{
    prs => import prs._
    CompetitorRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table competitor. Objects of this class serve as prototypes for rows in queries. */
  class Competitor(tag: Tag) extends Table[CompetitorRow](tag, "competitor") {
    def * = (id, displayName, shortName) <> (CompetitorRow.tupled, CompetitorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, displayName, shortName).shaped.<>({r=>import r._; _1.map(_=> CompetitorRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column display_name  */
    val displayName: Column[Option[String]] = column[Option[String]]("display_name")
    /** Database column short_name  */
    val shortName: Column[Option[String]] = column[Option[String]]("short_name")
  }
  /** Collection-like TableQuery object for table Competitor */
  lazy val Competitor = new TableQuery(tag => new Competitor(tag))
  
  /** Entity class storing rows of table Match
   *  @param id Database column id AutoInc
   *  @param tournamentId Database column tournament_id 
   *  @param displayName Database column display_name 
   *  @param scheduled Database column scheduled 
   *  @param home Database column home 
   *  @param visitor Database column visitor 
   *  @param scoreHome Database column score_home 
   *  @param scoreVisitor Database column score_visitor  */
  case class MatchRow(id: Int, tournamentId: Int, displayName: String, scheduled: java.sql.Timestamp, home: Int, visitor: Int, scoreHome: Option[Int], scoreVisitor: Option[Int])
  /** GetResult implicit for fetching MatchRow objects using plain SQL queries */
  implicit def GetResultMatchRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]]): GR[MatchRow] = GR{
    prs => import prs._
    MatchRow.tupled((<<[Int], <<[Int], <<[String], <<[java.sql.Timestamp], <<[Int], <<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table match. Objects of this class serve as prototypes for rows in queries. */
  class Match(tag: Tag) extends Table[MatchRow](tag, "match") {
    def * = (id, tournamentId, displayName, scheduled, home, visitor, scoreHome, scoreVisitor) <> (MatchRow.tupled, MatchRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, tournamentId.?, displayName.?, scheduled.?, home.?, visitor.?, scoreHome, scoreVisitor).shaped.<>({r=>import r._; _1.map(_=> MatchRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc */
    val id: Column[Int] = column[Int]("id", O.AutoInc)
    /** Database column tournament_id  */
    val tournamentId: Column[Int] = column[Int]("tournament_id")
    /** Database column display_name  */
    val displayName: Column[String] = column[String]("display_name")
    /** Database column scheduled  */
    val scheduled: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("scheduled")
    /** Database column home  */
    val home: Column[Int] = column[Int]("home")
    /** Database column visitor  */
    val visitor: Column[Int] = column[Int]("visitor")
    /** Database column score_home  */
    val scoreHome: Column[Option[Int]] = column[Option[Int]]("score_home")
    /** Database column score_visitor  */
    val scoreVisitor: Column[Option[Int]] = column[Option[Int]]("score_visitor")
    
    /** Primary key of Match (database name match_PK) */
    val pk = primaryKey("match_PK", (id, tournamentId, home, visitor))
    
    /** Foreign key referencing Competitor (database name fk_match_competitor) */
    lazy val competitorFk1 = foreignKey("fk_match_competitor", home, Competitor)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Competitor (database name fk_match_competitor1) */
    lazy val competitorFk2 = foreignKey("fk_match_competitor1", visitor, Competitor)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Tournament (database name fk_match_tournament1) */
    lazy val tournamentFk = foreignKey("fk_match_tournament1", tournamentId, Tournament)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Match */
  lazy val Match = new TableQuery(tag => new Match(tag))
  
  /** Entity class storing rows of table MatchUserVotes
   *  @param matchId Database column match_id 
   *  @param userId Database column user_id 
   *  @param scoreHome Database column score_home 
   *  @param scoreVisitor Database column score_visitor 
   *  @param voteTime Database column vote_time  */
  case class MatchUserVotesRow(matchId: Int, userId: Int, scoreHome: Int, scoreVisitor: Int, voteTime: java.sql.Timestamp)
  /** GetResult implicit for fetching MatchUserVotesRow objects using plain SQL queries */
  implicit def GetResultMatchUserVotesRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp]): GR[MatchUserVotesRow] = GR{
    prs => import prs._
    MatchUserVotesRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp]))
  }
  /** Table description of table match_user_votes. Objects of this class serve as prototypes for rows in queries. */
  class MatchUserVotes(tag: Tag) extends Table[MatchUserVotesRow](tag, "match_user_votes") {
    def * = (matchId, userId, scoreHome, scoreVisitor, voteTime) <> (MatchUserVotesRow.tupled, MatchUserVotesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (matchId.?, userId.?, scoreHome.?, scoreVisitor.?, voteTime.?).shaped.<>({r=>import r._; _1.map(_=> MatchUserVotesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column match_id  */
    val matchId: Column[Int] = column[Int]("match_id")
    /** Database column user_id  */
    val userId: Column[Int] = column[Int]("user_id")
    /** Database column score_home  */
    val scoreHome: Column[Int] = column[Int]("score_home")
    /** Database column score_visitor  */
    val scoreVisitor: Column[Int] = column[Int]("score_visitor")
    /** Database column vote_time  */
    val voteTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("vote_time")
    
    /** Primary key of MatchUserVotes (database name match_user_votes_PK) */
    val pk = primaryKey("match_user_votes_PK", (matchId, userId))
    
    /** Foreign key referencing Match (database name fk_match_has_user_match1) */
    lazy val matchFk = foreignKey("fk_match_has_user_match1", matchId, Match)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing User (database name fk_match_has_user_user1) */
    lazy val userFk = foreignKey("fk_match_has_user_user1", userId, User)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table MatchUserVotes */
  lazy val MatchUserVotes = new TableQuery(tag => new MatchUserVotes(tag))
  
  /** Entity class storing rows of table Tournament
   *  @param id Database column id AutoInc
   *  @param displayName Database column display_name 
   *  @param start Database column start 
   *  @param end Database column end 
   *  @param budget Database column budget 
   *  @param algorithmId Database column algorithm_id  */
  case class TournamentRow(id: Int, displayName: String, start: java.sql.Timestamp, end: java.sql.Timestamp, budget: Option[scala.math.BigDecimal], algorithmId: Int)
  /** GetResult implicit for fetching TournamentRow objects using plain SQL queries */
  implicit def GetResultTournamentRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[scala.math.BigDecimal]]): GR[TournamentRow] = GR{
    prs => import prs._
    TournamentRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[scala.math.BigDecimal], <<[Int]))
  }
  /** Table description of table tournament. Objects of this class serve as prototypes for rows in queries. */
  class Tournament(tag: Tag) extends Table[TournamentRow](tag, "tournament") {
    def * = (id, displayName, start, end, budget, algorithmId) <> (TournamentRow.tupled, TournamentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, displayName.?, start.?, end.?, budget, algorithmId.?).shaped.<>({r=>import r._; _1.map(_=> TournamentRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc */
    val id: Column[Int] = column[Int]("id", O.AutoInc)
    /** Database column display_name  */
    val displayName: Column[String] = column[String]("display_name")
    /** Database column start  */
    val start: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("start")
    /** Database column end  */
    val end: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("end")
    /** Database column budget  */
    val budget: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("budget")
    /** Database column algorithm_id  */
    val algorithmId: Column[Int] = column[Int]("algorithm_id")
    
    /** Primary key of Tournament (database name tournament_PK) */
    val pk = primaryKey("tournament_PK", (id, algorithmId))
    
    /** Foreign key referencing Algorithm (database name fk_tournament_algorithm1) */
    lazy val algorithmFk = foreignKey("fk_tournament_algorithm1", algorithmId, Algorithm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Tournament */
  lazy val Tournament = new TableQuery(tag => new Tournament(tag))
  
  /** Entity class storing rows of table TournamentAlgorithmParam
   *  @param tournamentId Database column tournament_id 
   *  @param algorithmId Database column algorithm_id 
   *  @param algorithmParamSetId Database column algorithm_param_set_id 
   *  @param paramValue Database column param_value  */
  case class TournamentAlgorithmParamRow(tournamentId: Int, algorithmId: Int, algorithmParamSetId: Int, paramValue: Option[String])
  /** GetResult implicit for fetching TournamentAlgorithmParamRow objects using plain SQL queries */
  implicit def GetResultTournamentAlgorithmParamRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[TournamentAlgorithmParamRow] = GR{
    prs => import prs._
    TournamentAlgorithmParamRow.tupled((<<[Int], <<[Int], <<[Int], <<?[String]))
  }
  /** Table description of table tournament_algorithm_param. Objects of this class serve as prototypes for rows in queries. */
  class TournamentAlgorithmParam(tag: Tag) extends Table[TournamentAlgorithmParamRow](tag, "tournament_algorithm_param") {
    def * = (tournamentId, algorithmId, algorithmParamSetId, paramValue) <> (TournamentAlgorithmParamRow.tupled, TournamentAlgorithmParamRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tournamentId.?, algorithmId.?, algorithmParamSetId.?, paramValue).shaped.<>({r=>import r._; _1.map(_=> TournamentAlgorithmParamRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column tournament_id  */
    val tournamentId: Column[Int] = column[Int]("tournament_id")
    /** Database column algorithm_id  */
    val algorithmId: Column[Int] = column[Int]("algorithm_id")
    /** Database column algorithm_param_set_id  */
    val algorithmParamSetId: Column[Int] = column[Int]("algorithm_param_set_id")
    /** Database column param_value  */
    val paramValue: Column[Option[String]] = column[Option[String]]("param_value")
    
    /** Primary key of TournamentAlgorithmParam (database name tournament_algorithm_param_PK) */
    val pk = primaryKey("tournament_algorithm_param_PK", (tournamentId, algorithmId, algorithmParamSetId))
    
    /** Foreign key referencing Algorithm (database name fk_tournament_has_algorithm_param_algorithm1) */
    lazy val algorithmFk = foreignKey("fk_tournament_has_algorithm_param_algorithm1", algorithmId, Algorithm)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing AlgorithmParamSet (database name fk_tournament_has_algorithm_param_algorithm_param1) */
    lazy val algorithmParamSetFk = foreignKey("fk_tournament_has_algorithm_param_algorithm_param1", algorithmParamSetId, AlgorithmParamSet)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Tournament (database name fk_tournament_has_algorithm_param_tournament1) */
    lazy val tournamentFk = foreignKey("fk_tournament_has_algorithm_param_tournament1", tournamentId, Tournament)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TournamentAlgorithmParam */
  lazy val TournamentAlgorithmParam = new TableQuery(tag => new TournamentAlgorithmParam(tag))
  
  /** Entity class storing rows of table TournamentCompetitors
   *  @param tournamentId Database column tournament_id 
   *  @param competitorId Database column competitor_id 
   *  @param out Database column out 
   *  @param outDate Database column out_date  */
  case class TournamentCompetitorsRow(tournamentId: Int, competitorId: Int, out: Option[Boolean], outDate: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching TournamentCompetitorsRow objects using plain SQL queries */
  implicit def GetResultTournamentCompetitorsRow(implicit e0: GR[Int], e1: GR[Option[Boolean]], e2: GR[Option[java.sql.Timestamp]]): GR[TournamentCompetitorsRow] = GR{
    prs => import prs._
    TournamentCompetitorsRow.tupled((<<[Int], <<[Int], <<?[Boolean], <<?[java.sql.Timestamp]))
  }
  /** Table description of table tournament_competitors. Objects of this class serve as prototypes for rows in queries. */
  class TournamentCompetitors(tag: Tag) extends Table[TournamentCompetitorsRow](tag, "tournament_competitors") {
    def * = (tournamentId, competitorId, out, outDate) <> (TournamentCompetitorsRow.tupled, TournamentCompetitorsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tournamentId.?, competitorId.?, out, outDate).shaped.<>({r=>import r._; _1.map(_=> TournamentCompetitorsRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column tournament_id  */
    val tournamentId: Column[Int] = column[Int]("tournament_id")
    /** Database column competitor_id  */
    val competitorId: Column[Int] = column[Int]("competitor_id")
    /** Database column out  */
    val out: Column[Option[Boolean]] = column[Option[Boolean]]("out")
    /** Database column out_date  */
    val outDate: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("out_date")
    
    /** Primary key of TournamentCompetitors (database name tournament_competitors_PK) */
    val pk = primaryKey("tournament_competitors_PK", (tournamentId, competitorId))
    
    /** Foreign key referencing Competitor (database name fk_tournament_has_competitor_competitor1) */
    lazy val competitorFk = foreignKey("fk_tournament_has_competitor_competitor1", competitorId, Competitor)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Tournament (database name fk_tournament_has_competitor_tournament1) */
    lazy val tournamentFk = foreignKey("fk_tournament_has_competitor_tournament1", tournamentId, Tournament)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TournamentCompetitors */
  lazy val TournamentCompetitors = new TableQuery(tag => new TournamentCompetitors(tag))
  
  /** Entity class storing rows of table TournamentPhase
   *  @param id Database column id AutoInc
   *  @param tournamentId Database column tournament_id 
   *  @param displayName Database column display_name 
   *  @param budgetPecentage Database column budget_pecentage  */
  case class TournamentPhaseRow(id: Int, tournamentId: Int, displayName: Option[String], budgetPecentage: Option[Double])
  /** GetResult implicit for fetching TournamentPhaseRow objects using plain SQL queries */
  implicit def GetResultTournamentPhaseRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Double]]): GR[TournamentPhaseRow] = GR{
    prs => import prs._
    TournamentPhaseRow.tupled((<<[Int], <<[Int], <<?[String], <<?[Double]))
  }
  /** Table description of table tournament_phase. Objects of this class serve as prototypes for rows in queries. */
  class TournamentPhase(tag: Tag) extends Table[TournamentPhaseRow](tag, "tournament_phase") {
    def * = (id, tournamentId, displayName, budgetPecentage) <> (TournamentPhaseRow.tupled, TournamentPhaseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, tournamentId.?, displayName, budgetPecentage).shaped.<>({r=>import r._; _1.map(_=> TournamentPhaseRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc */
    val id: Column[Int] = column[Int]("id", O.AutoInc)
    /** Database column tournament_id  */
    val tournamentId: Column[Int] = column[Int]("tournament_id")
    /** Database column display_name  */
    val displayName: Column[Option[String]] = column[Option[String]]("display_name")
    /** Database column budget_pecentage  */
    val budgetPecentage: Column[Option[Double]] = column[Option[Double]]("budget_pecentage")
    
    /** Primary key of TournamentPhase (database name tournament_phase_PK) */
    val pk = primaryKey("tournament_phase_PK", (id, tournamentId))
    
    /** Foreign key referencing Tournament (database name fk_tournament_phase_tournament1) */
    lazy val tournamentFk = foreignKey("fk_tournament_phase_tournament1", tournamentId, Tournament)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TournamentPhase */
  lazy val TournamentPhase = new TableQuery(tag => new TournamentPhase(tag))
  
  /** Entity class storing rows of table TournamentUsers
   *  @param tournamentId Database column tournament_id 
   *  @param userId Database column user_id 
   *  @param moderator Database column moderator  */
  case class TournamentUsersRow(tournamentId: Int, userId: Int, moderator: Option[Boolean])
  /** GetResult implicit for fetching TournamentUsersRow objects using plain SQL queries */
  implicit def GetResultTournamentUsersRow(implicit e0: GR[Int], e1: GR[Option[Boolean]]): GR[TournamentUsersRow] = GR{
    prs => import prs._
    TournamentUsersRow.tupled((<<[Int], <<[Int], <<?[Boolean]))
  }
  /** Table description of table tournament_users. Objects of this class serve as prototypes for rows in queries. */
  class TournamentUsers(tag: Tag) extends Table[TournamentUsersRow](tag, "tournament_users") {
    def * = (tournamentId, userId, moderator) <> (TournamentUsersRow.tupled, TournamentUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tournamentId.?, userId.?, moderator).shaped.<>({r=>import r._; _1.map(_=> TournamentUsersRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column tournament_id  */
    val tournamentId: Column[Int] = column[Int]("tournament_id")
    /** Database column user_id  */
    val userId: Column[Int] = column[Int]("user_id")
    /** Database column moderator  */
    val moderator: Column[Option[Boolean]] = column[Option[Boolean]]("moderator")
    
    /** Primary key of TournamentUsers (database name tournament_users_PK) */
    val pk = primaryKey("tournament_users_PK", (tournamentId, userId))
    
    /** Foreign key referencing Tournament (database name fk_tournament_has_user_tournament1) */
    lazy val tournamentFk = foreignKey("fk_tournament_has_user_tournament1", tournamentId, Tournament)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing User (database name fk_tournament_has_user_user1) */
    lazy val userFk = foreignKey("fk_tournament_has_user_user1", userId, User)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table TournamentUsers */
  lazy val TournamentUsers = new TableQuery(tag => new TournamentUsers(tag))
  
  /** Entity class storing rows of table User
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param displayName Database column display_name 
   *  @param email Database column email 
   *  @param picture Database column picture 
   *  @param googleId Database column google_id 
   *  @param role Database column role  */
  case class UserRow(id: Int, displayName: Option[String], email: Option[String], picture: Option[String], googleId: Option[String], role: Option[String])
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(tag: Tag) extends Table[UserRow](tag, "user") {
    def * = (id, displayName, email, picture, googleId, role) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, displayName, email, picture, googleId, role).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column display_name  */
    val displayName: Column[Option[String]] = column[Option[String]]("display_name")
    /** Database column email  */
    val email: Column[Option[String]] = column[Option[String]]("email")
    /** Database column picture  */
    val picture: Column[Option[String]] = column[Option[String]]("picture")
    /** Database column google_id  */
    val googleId: Column[Option[String]] = column[Option[String]]("google_id")
    /** Database column role  */
    val role: Column[Option[String]] = column[Option[String]]("role")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}