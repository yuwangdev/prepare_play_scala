package controllers

import javax.inject._

import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {
    Ok(views.html.index("Your new application is okay!"))
  }

  def hello = Action {
    Ok(<h1>Hello</h1>).as("text/html")
  }

  def xml = Action {
    Ok(<message>HelloXml</message>)
  }

  def red = Action {
    Redirect("http://www.google.ca")
  }

  def person(id:Int) = Action {
    Ok((new Person(24, "james")).toString.concat(id.toString))
  }
}


class Person(id: Int, name: String) {

  val this.id = id
  val this.name = name


}
