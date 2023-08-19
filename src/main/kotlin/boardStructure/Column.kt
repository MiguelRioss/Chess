import boardStructure.BOARD_DIM

class Column private constructor(val symbol :Char){

    companion object{
        val values = (0 until BOARD_DIM).map { Column('A' + it) }

        operator fun invoke(symbol: Char): Column {
            return symbol.toColumn()
        }
    }
}

fun Char.toColumnOrNull(): Column?{
    return if (this.uppercaseChar() in 'A' .. 'A' + BOARD_DIM){
        this.toColumn()
    }
    else null
}

fun Char.toColumn(): Column {
    require(this.uppercaseChar() in 'A' .. 'A' + BOARD_DIM){"Invalid row $this"}
    return Column.values.first { it.symbol == this.uppercaseChar()}
}