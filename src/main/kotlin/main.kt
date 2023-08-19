import model.Game
import ui.*

fun main(){
    var game : Game?  = null
    val possibleCommands = getCommands()
    while (true){
        val (name,args) = readCommand()
        val cmd = possibleCommands[name]
        if(cmd == null) println("Invalid command name $name")
        else {
            game = cmd.execute(args,game)
            if (cmd.isToFinish()) break
            else print("here")
        }


    }

}


