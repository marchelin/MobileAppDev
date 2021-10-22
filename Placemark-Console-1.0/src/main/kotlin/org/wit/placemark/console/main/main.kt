package org.wit.placemark.console.main

import mu.KotlinLogging
import org.wit.placemark.console.models.PlacemarkJSONStore
import org.wit.placemark.console.models.PlacemarkModel
import org.wit.placemark.console.views.PlacemarkView

private val logger = KotlinLogging.logger {}

val placemarks = PlacemarkJSONStore()
val placemarkView = PlacemarkView()
val placemarkModel = PlacemarkModel("", "", "", 0, 1)

fun main(args: Array<String>) {
    logger.info { "Launching Placemark Console App" }
    //println("Placemark Kotlin App Version 1.0")

    println("Welcome to this entertaining Brain Teaser to exercise your cognitive skills, called...")
    println("WHERE DO WORDS GO ???")

    var inputNumber = placemarkModel.inputOneCounter
    var input: Int

    do {
        input = placemarkView.menu()
        when(input) {
             1   -> addPlacemark(inputNumber, placemarkModel) // ERRRRRRRRRRRRRRRRRRRRRRRRRRRRROOOOOOOOOR
             2   -> updatePlacemark()
             3   -> placemarkView.listPlacemarks(placemarks)
             4   -> searchPlacemark()
            -1   -> println("Exiting App...")
            else -> println("Invalid Option")
        }

        if(inputNumber != 10 && input == 1){
            inputNumber++
        }
        else
        {
            print("GAME IS OVER")
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

fun addPlacemark(inputNumber : Int, placemark : PlacemarkModel){
    spawnNewWord(0)

    println("\nYou are in level $inputNumber")

    var aPlacemark = PlacemarkModel("", "", "", 0, 1)



    if (placemarkView.addPlacemarkData(aPlacemark))
        placemarks.create(aPlacemark)
    else
        logger.info("Placemark Not Added")

    // Funciona
    when (inputNumber) {
        1 -> checkWord_Lvl_1(placemark)
        2 -> checkWord_Lvl_2(placemark)
        3 -> checkWord_Lvl_3(placemark)
        4 -> checkWord_Lvl_4(placemark)
        5 -> checkWord_Lvl_5(placemark)
        6 -> checkWord_Lvl_6(placemark)
        7 -> checkWord_Lvl_7(placemark)
        8 -> checkWord_Lvl_8(placemark)
        8 -> checkWord_Lvl_9(placemark)
    }
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


// 1
fun checkWord_Lvl_1(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "KEY" || placemark.wordTwo == "KEY" || placemark.wordThree == "KEY" ||
        placemark.wordOne == "Key" || placemark.wordTwo == "Key" || placemark.wordThree == "Key" ||
        placemark.wordOne == "key" || placemark.wordTwo == "key" || placemark.wordThree == "key") {

        print("KEY is the right answer")
    }
    else {
        print("ZORRRRITA") // funciona
    }

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 2
fun checkWord_Lvl_2(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "DECK" || placemark.wordTwo == "DECK" || placemark.wordThree == "DECK" ||
        placemark.wordOne == "Deck" || placemark.wordTwo == "Deck" || placemark.wordThree == "Deck" ||
        placemark.wordOne == "deck" || placemark.wordTwo == "deck" || placemark.wordThree == "deck")
        print("DECK is the right answer") else print("ZORRRRITA 2222222222") // funciona

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 3
fun checkWord_Lvl_3(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "TRUNK" || placemark.wordTwo == "TRUNK" || placemark.wordThree == "TRUNK" ||
        placemark.wordOne == "Trunk" || placemark.wordTwo == "Trunk" || placemark.wordThree == "Trunk" ||
        placemark.wordOne == "trunk" || placemark.wordTwo == "trunk" || placemark.wordThree == "trunk")
        print("TRUNK is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 4
fun checkWord_Lvl_4(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "PUPIL" || placemark.wordTwo == "PUPIL" || placemark.wordThree == "PUPIL" ||
        placemark.wordOne == "Pupil" || placemark.wordTwo == "Pupil" || placemark.wordThree == "Pupil" ||
        placemark.wordOne == "pupil" || placemark.wordTwo == "pupil" || placemark.wordThree == "pupil")
        print("PUPIL is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 5
fun checkWord_Lvl_5(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "CASE" || placemark.wordTwo == "CASE" || placemark.wordThree == "CASE" ||
        placemark.wordOne == "Case" || placemark.wordTwo == "Case" || placemark.wordThree == "Case" ||
        placemark.wordOne == "case" || placemark.wordTwo == "case" || placemark.wordThree == "case")
        print("CASE is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 6
fun checkWord_Lvl_6(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "BANK" || placemark.wordTwo == "BANK" || placemark.wordThree == "BANK" ||
        placemark.wordOne == "Bank" || placemark.wordTwo == "Bank" || placemark.wordThree == "Bank" ||
        placemark.wordOne == "bank" || placemark.wordTwo == "bank" || placemark.wordThree == "bank")
        print("BANK is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 7
fun checkWord_Lvl_7(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "SHEET" || placemark.wordTwo == "SHEET" || placemark.wordThree == "SHEET" ||
        placemark.wordOne == "Sheet" || placemark.wordTwo == "Sheet" || placemark.wordThree == "Sheet" ||
        placemark.wordOne == "sheet" || placemark.wordTwo == "sheet" || placemark.wordThree == "sheet")
        print("SHEET is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 8
fun checkWord_Lvl_8(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "TANK" || placemark.wordTwo == "TANK" || placemark.wordThree == "TANK" ||
        placemark.wordOne == "Tank" || placemark.wordTwo == "Tank" || placemark.wordThree == "Tank" ||
        placemark.wordOne == "tank" || placemark.wordTwo == "tank" || placemark.wordThree == "tank")
        print("TANK is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}
// 9
fun checkWord_Lvl_9(placemark : PlacemarkModel) : Boolean{
    if( placemark.wordOne == "RACQUET" || placemark.wordTwo == "RACQUET" || placemark.wordThree == "RACQUET" ||
        placemark.wordOne == "Racquet" || placemark.wordTwo == "Racquet" || placemark.wordThree == "Racquet" ||
        placemark.wordOne == "racquet" || placemark.wordTwo == "racquet" || placemark.wordThree == "racquet")
        print("RACQUET is the right answer") else print("Your word is not the right answer")

    return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
}