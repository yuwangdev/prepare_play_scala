### Create new project and make it usable for intellij 
- $ activator ui   
- on the webui, left hands navigation bar, select "seeds", and then choose java or scala seeds template 
- left hands nav bar, choose anything that i want to do 
- open the intellij, import the project as "SBT" model. 
- edit run configuration, select "SBT tasks", in the task blank, put "run". 
- 同样也可以直接用/bin下的activator ui来运行以及配置
- 运行时，最安全的是运行routes文件

### play文件结构
- app/assets/下面的stylesheet和javascripts，是用来放置LESS和coffeescript的
- conf/application.conf用来配置project，例如数据库接口
- conf/routes用来写routing rule
- public/下面是放置原始的javascript和css，以及image 

### 基本组件
- slick: scala functional relational mapping for SQL 
- JPA/EBean/Anorm for SQL ORM 
- akka: for message streaming, and also writing/reading stream 

### Action 
- implicit keyword with class: 这个class自己带一个argument，但是可以不写所对应的constructor 

```scala
class MyController extends Controller {
	def hello(param:String)=Action { implicit request => Ok("Got request [" + request + "]" + param)
	}
}
```
- 如果改了routes文件，要重新邮件run 
- 在routes里面规定requestMapping的方法，叫做dependency injected router

### Routes
- GET /person/:id mycontroller.person.findOne(id:Long)   // person可以是一个class
- GET /person/:id mycontroller.person.findOne(id:Long=1)   // 当URL中没有id时，默认用1这个数值
- GET /person/all mycontroller.person.findAll()
- GET /person/all mycontroller.person.findAll(page:Int?=1) // /person/all?page=3的效果，page=1是默认值，也就是requestParam的处理方法
- GET /person/*name mycontroller.person.findByName(name:String) // 可以处理/person/{xxx}/{name}以及/person/{name}
- def red = Action {Redirect("http://www.google.ca")}

- 一个标准的findOne：
```scala
def show(id: Long) = Action {   // Person是一个class
  Person.findById(id).map { person =>
    Ok(views.html.Persons.display(person))
  }.getOrElse(NotFound)
}
```
- Many routes can match the same request. If there is a conflict, the first route (in declaration order) is used.
- def hello = Action {Ok(<h1>Hello</h1>).as("text/html")}
- Ok(<message>Hello World!</message>)













