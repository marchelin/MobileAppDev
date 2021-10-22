package org.wit.placemark.console.main

import mu.KotlinLogging
import org.wit.placemark.console.controllers.PlacemarkController
import org.wit.placemark.console.models.PlacemarkJSONStore
import org.wit.placemark.console.models.PlacemarkModel
import org.wit.placemark.console.views.PlacemarkView
import org.wit.placemark.console.views.rightAnsw

private val logger = KotlinLogging.logger {}

val placemarkController = PlacemarkController()
val placemarks = PlacemarkJSONStore()
val placemarkView = PlacemarkView()
val placemarkModel = PlacemarkModel("", "", "", 0, 1)

var inputNumber = placemarkModel.inputOneCounter

fun main(args: Array<String>) {
    logger.info { "Launching Placemark Console App" }
    //println("Placemark Kotlin App Version 1.0")

    println("Welcome to this entertaining Brain Teaser to exercise your cognitive skills, called...")
    println("WHERE DO WORDS GO ???")

    var input: Int

    do {
        input = placemarkView.menu()
        when(input) {
            1   -> addPlacemark()
            2   -> updatePlacemark()
            3   -> placemarkView.listPlacemarks(placemarks)
            4   -> searchPlacemark()
            5   -> placemarkController.delete()
            6   -> showAnswer()
            7   -> showCurrenScore()
            -1   -> println("Exiting App...")
            else -> println("Invalid Option")
        }

        if(inputNumber < 10 && input == 1){
            inputNumber++
        }

        println()
    } while (input != -1)

    logger.info { "Shutting Down The Console App" }
}

fun spawnNewWord(){
    print("Find a word connected with these two words : ")

    val wordPiarsArray: Array<String> = arrayOf("LOCK — PIANO",    "SHIP — CARD",     "TREE — CAR",
        "SCHOOL — EYE", "PILLOW — COURT",  "RIVER — MONEY",
        "BED — PAPER",   "ARMY — WATER", "TENNIS — NOISE")

    when (inputNumber) {
        1 -> print(wordPiarsArray[0])
        2 -> print(wordPiarsArray[1])
        3 -> print(wordPiarsArray[2])
        4 -> print(wordPiarsArray[3])
        5 -> print(wordPiarsArray[4])
        6 -> print(wordPiarsArray[5])
        7 -> print(wordPiarsArray[6])
        8 -> print(wordPiarsArray[7])
        9 -> print(wordPiarsArray[8])
        else -> {
            print("rnd is neither 0..8")
        }
    }
}

fun addPlacemark(){
    spawnNewWord()
    println("\nYou are in level $inputNumber")

    var aPlacemark = PlacemarkModel("", "", "", 0, 1)

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

fun showAnswer(){
    when (inputNumber) {
        1 -> print("\nKEY is the answer")
        2 -> print("\nDECK is the answer")
        3 -> print("\nTRUNK is the answer")
        4 -> print("\nPUPIL is the answer")
        5 -> print("\nCASE is the answer")
        6 -> print("\nBANK is the answer")
        7 -> print("\nSHEET is the answer")
        8 -> print("\nTANK is the answer")
        9 -> print("\nRACQUET is the answer")
    }
}

fun showCurrenScore(){
    print("\nYour current score is $rightAnsw/9 points")
}