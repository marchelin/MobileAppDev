package org.wit.placemark.console.main

import mu.KotlinLogging
import org.wit.placemark.console.models.PlacemarkJSONStore
import org.wit.placemark.console.models.PlacemarkModel
import org.wit.placemark.console.views.PlacemarkView

private val logger = KotlinLogging.logger {}

val placemarks = PlacemarkJSONStore()
val placemarkView = PlacemarkView()
val placemarkModel = PlacemarkModel("", "", "", 0, 0)

fun main(args: Array<String>) {
    logger.info { "Launching Placemark Console App" }
    //println("Placemark Kotlin App Version 1.0")

    println("Welcome to this entertaining Brain Teaser to exercise your cognitive skills, called...")
    println("WHERE DO WORDS GO ???")

    var input: Int

    do {
        input = placemarkView.menu()
        when(input) {
             1   ->    addPlacemark()
             2   -> updatePlacemark()
             3   -> placemarkView.listPlacemarks(placemarks)
             4   -> searchPlacemark()
            -1   -> println("Exiting App...")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Placemark Console App" }
}

fun spawnNewWord(inputNumber: Int){
    print("Find a word connected with these two word\n")

    val wordPiarsArray: Array<String> = arrayOf(    "LOCK — PIANO",    "SHIP —  CARD",   "TREE —   CAR",
                                                "SCHOOL   —   EYE", "PILLOW  — COURT",  "RIVER — MONEY",
                                                 "BED     — PAPER",   "ARMY  — WATER", "TENNIS — NOISE")

    when (inputNumber) {
        0 -> print(wordPiarsArray[0])
        1 -> print(wordPiarsArray[1])
        2 -> print(wordPiarsArray[2])
        3 -> print(wordPiarsArray[3])
        4 -> print(wordPiarsArray[4])
        5 -> print(wordPiarsArray[5])
        6 -> print(wordPiarsArray[6])
        7 -> print(wordPiarsArray[7])
        8 -> print(wordPiarsArray[8])
        else -> {
            print("rnd is neither 0..8")
        }
    }
}

fun checkWordAnswers(){
    if(placemarkModel.inputOneCounter == 1 && placemarkModel.wordOne   == "Key" ||
                               placemarkModel.wordTwo   == "Key" ||
                               placemarkModel.wordThree == "Key") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 2 && placemarkModel.wordOne   == "Deck" ||
                                    placemarkModel.wordTwo   == "Deck" ||
                                    placemarkModel.wordThree == "Deck") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 3 && placemarkModel.wordOne   == "Trunk" ||
                                    placemarkModel.wordTwo   == "Trunk" ||
                                    placemarkModel.wordThree == "Trunk") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 4 && placemarkModel.wordOne   == "Pupil" ||
                                    placemarkModel.wordTwo   == "Pupil" ||
                                    placemarkModel.wordThree == "Pupil") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 5 && placemarkModel.wordOne   == "Case" ||
                                    placemarkModel.wordTwo   == "Case" ||
                                    placemarkModel.wordThree == "Case") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 6 && placemarkModel.wordOne   == "Bank" ||
                                    placemarkModel.wordTwo   == "Bank" ||
                                    placemarkModel.wordThree == "Bank") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 7 && placemarkModel.wordOne   == "Sheet" ||
                                    placemarkModel.wordTwo   == "Sheet" ||
                                    placemarkModel.wordThree == "Sheet") print("WORDis CORRECT")
    else if(placemarkModel.inputOneCounter == 8 && placemarkModel.wordOne   == "Tank" ||
                                    placemarkModel.wordTwo   == "Tank" ||
                                    placemarkModel.wordThree == "Tank") print("WORD is CORRECT")
    else if(placemarkModel.inputOneCounter == 9 && placemarkModel.wordOne   == "Racquet" ||
                                    placemarkModel.wordTwo   == "Racquet" ||
                                    placemarkModel.wordThree == "Racquet") print("WORD is CORRECT")
    else  print("WORD is INCORRECT")
}

fun addPlacemark(){
    spawnNewWord(0)

    var inputNumber = placemarkModel.inputOneCounter?.inc()
    println("\nYou are in level $inputNumber")

    var aPlacemark = PlacemarkModel("", "", "", 0)

    if (placemarkView.addPlacemarkData(aPlacemark))
        placemarks.create(aPlacemark)
    else
        logger.info("Placemark Not Added")
}

fun updatePlacemark() {

    placemarkView.listPlacemarks(placemarks)
    var searchId = placemarkView.getId()
    val aPlacemark = search(searchId)

    if(aPlacemark != null) {
        if(placemarkView.updatePlacemarkData(aPlacemark)) {
            placemarks.update(aPlacemark)
            placemarkView.showPlacemark(aPlacemark)
            logger.info("Placemark Updated : [ $aPlacemark ]")
        }
        else
            logger.info("Placemark Not Updated")
    }
    else
        println("Placemark Not Updated...")
}

fun searchPlacemark() {
    val aPlacemark = search(placemarkView.getId())!!
    placemarkView.showPlacemark(aPlacemark)
}

fun search(id: Long) : PlacemarkModel? {
    var foundPlacemark = placemarks.findOne(id)
    return foundPlacemark
}