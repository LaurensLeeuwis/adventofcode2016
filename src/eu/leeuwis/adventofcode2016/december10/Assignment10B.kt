package eu.leeuwis.adventofcode2016.december10

fun main(args: Array<String>) {

    val bots : MutableMap<Int, Bot> = mutableMapOf()
    val outputs: MutableMap<Int, Value> = mutableMapOf()

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
            } else if (lowInstruction.contains("output")){
                val output = Integer.parseInt(lowInstruction.substringAfter("output "))

                val value = Value()
                value.lowValueFromBot = bot

                outputs.put(output, value)
            }

            if (highInstruction.contains("bot")){
                val botTonr = Integer.parseInt(highInstruction.substringAfter("bot "))
                val botTo = bots.getOrPut(botTonr, defaultValue = {Bot(botTonr)})
                val value = Value()
                value.highValueFromBot = bot

                botTo.addChip(value)
            } else if (lowInstruction.contains("output")){
                val output = Integer.parseInt(highInstruction.substringAfter("output "))

                val value = Value()
                value.highValueFromBot = bot

                outputs.put(output, value)
            }
        }
    }

    println(outputs.get(0)!!.getValue() * outputs.get(1)!!.getValue() * outputs.get(2)!!.getValue())

}

