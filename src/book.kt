open class Book(val title: String, val author: String) {

    private var currentPage = 1

    open fun readPage() {
        currentPage ++
    }

}

class eBook(title: String, author: String, val format: String = "Text"): Book(title, author) {

    private var wordsRead: Int = 0

    override fun readPage() {
        wordsRead += 250
    }
}