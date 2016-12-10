package eu.leeuwis.adventofcode2016.december10

fun main(args: Array<String>) {

    val bots : MutableMap<Int, Bot> = mutableMapOf()

    givenInput.split("\n").forEach {instruction ->
        if (instruction.startsWith("value")){
            val valueint = Integer.parseInt(instruction.substringAfter("value ").substringBefore(" goes"))
            val botnr = Integer.parseInt(instruction.substringAfter("bot "))
            val value = Value()
            value.value = valueint

            bots.getOrPut(botnr, defaultValue = {Bot(botnr)}).addChip(value);
        } else if (instruction.startsWith("bot")){
            val botnr = Integer.parseInt(instruction.substringAfter("bot ").substringBefore(" gives low"))
            val lowInstruction = instruction.substringAfter("low to ").substringBefore(" and high")
            val highInstruction = instruction.substringAfter("high to")
            val bot = bots.getOrPut(botnr, defaultValue = {Bot(botnr)})

            if (lowInstruction.contains("bot")){
                val botTonr = Integer.parseInt(lowInstruction.substringAfter("bot "))
                val botTo = bots.getOrPut(botTonr, defaultValue = {Bot(botTonr)})
                val value = Value()
                value.lowValueFromBot = bot

                botTo.addChip(value)
            }

            if (highInstruction.contains("bot")){
                val botTonr = Integer.parseInt(highInstruction.substringAfter("bot "))
                val botTo = bots.getOrPut(botTonr, defaultValue = {Bot(botTonr)})
                val value = Value()
                value.highValueFromBot = bot

                botTo.addChip(value)
            }
        }
    }

    bots.values.forEach{
        if (it.getLowerValue() == 17 && it.getHigherValue() == 61){
            println(it.number)
        }
    }

}

