const val BOARD_DIM = 8

class Row private constructor(val number:Int){
    val index = number - 1

    companion object{
        val values = (1.. BOARD_DIM).map { it -> Row(it) }

        operator fun invoke(number: Int): Row {
            return number.toRow()
        }
    }

}

fun Int.toRowOrNull(): Row?{
    return if (this in 1 .. BOARD_DIM){
        this.toRow()
    }
    else null
}

fun Int.toRow(): Row {
    require(this in 1 .. BOARD_DIM){"Invalid row $this"}
    return Row.values[this-1]
}