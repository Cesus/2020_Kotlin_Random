package spice3

import java.awt.Color

sealed class Spice(val name: String, val spiciness: String = "mild", colour: SpiceColour) : SpiceColour by colour{
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, colour: SpiceColour = YellowSpiceColour): Spice(name, spiciness, colour), Grinder{

    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColour {
    val colour : Color
}

object YellowSpiceColour: SpiceColour {
    override val colour = Color.YELLOW
}

data class SpiceContainer(var spice: Spice) {
    var label = spice.name
}