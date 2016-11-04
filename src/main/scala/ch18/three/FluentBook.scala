package ch18.three

import scala.collection.mutable.ArrayBuffer

/*
3. Complete the fluent interface in Section 18.1, “Singleton Types,” on page 246 so that one can
call
book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
 */
object FluentBook extends App {

  object Title

  object Author

  class Document {
    private var title: String = _
    private var author: String = _
    private var currentPropertyTarget: Any = _

    def set(currentProperty: Title.type): this.type = {
      currentPropertyTarget = currentProperty
      this
    }

    def set(currentProperty: Author.type): this.type = {
      currentPropertyTarget = currentProperty
      this
    }

    def to(propertyValue: String): this.type = {
      if (currentPropertyTarget == Title) title = propertyValue else author = propertyValue
      this
    }

    override def toString = {
      "Document:" + "title=" + title + ", author=" + author
    }

  }

  class Book extends Document {
    private val chapters = ArrayBuffer[String]()

    def addChapter(chapter: String): this.type = {
      chapters.append(chapter)
      this
    }

    override def toString = {
      "Book:" + "chapters=" + chapters + super.toString
    }
  }

  private val book: Book = new Book()
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann" addChapter "Introduction"
  println(book)
}
