package eu.leeuwis.adventofcode2016.december11

enum class Moveables(vararg complementingMicrochip: Moveables) {

    Elevator(),
    Microchip_Promethium(),
    Generator_Promethium(Microchip_Promethium),
    Microchip_Elerium(),
    Generator_Elerium(Microchip_Elerium),
    Microchip_Dilithium(),
    Generator_Dilithium(Microchip_Dilithium),
    Microchip_Cobalt(),
    Generator_Cobalt(Microchip_Cobalt),
    Microchip_Curium(),
    Generator_Curium(Microchip_Curium),
    Microchip_Ruthenium(),
    Generator_Ruthenium(Microchip_Ruthenium),
    Microchip_Plutonium(),
    Generator_Plutonium(Microchip_Plutonium);

    val complementingMicrochips = complementingMicrochip

    fun isGenerator(): Boolean {
        return this.complementingMicrochips.size != 0
    }

    fun isMicrochip(): Boolean {
        return this != Elevator && !this.isGenerator()
    }

}