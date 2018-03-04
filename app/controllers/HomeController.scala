package controllers

import javax.inject._

import kamon.Kamon
import kamon.context.Key
import play.api._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {
  val key = Key.broadcastString("request-id")
  val logger = Logger("HomeController")

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action.async { implicit request: Request[AnyContent] =>
    val requestID = Kamon.currentContext().get(key).getOrElse("no-request-id")
    logger.info("RequestID in the action: " + requestID)

    Future {
      logger.info("Logging in the Future Body")

    } map { _ =>
      logger.info("Logging in the map")

    } flatMap { _ =>
      logger.info("Logging in the flatMap")
      Future.successful(Ok(views.html.index()))
    }
  }
}
