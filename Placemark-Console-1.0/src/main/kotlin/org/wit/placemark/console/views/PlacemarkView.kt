package org.wit.placemark.console.views

import org.wit.placemark.console.main.inputNumber

import org.wit.placemark.console.main.placemarkView
import org.wit.placemark.console.models.PlacemarkJSONStore
import org.wit.placemark.console.models.PlacemarkModel

var rightAnsw = 0

class PlacemarkView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("\nSelect one of the options below:")

        println(" 1. GUESS a new word")
        println(" 2. UPDATE my answers")
        println(" 3. LIST all my answers")
        println(" 4. SEARCH my answers")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!

        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listPlacemarks(placemarks: PlacemarkJSONStore) {
        println("LIST all my answers")
        println()
        placemarks.logAll()
        println()
    }

    fun showPlacemark(placemark : PlacemarkModel) {
        if(placemark != null)
            println("Placemark Details [ $placemark ]")
        else
            println("Placemark Not Found...")
    }

    fun addPlacemarkData(placemark : PlacemarkModel) : Boolean {

        println()
        print("1st attempt ---> Type a WORD: ")
        placemark.wordOne = readLine()!!
        print("2nd attempt ---> Type a WORD: ")
        placemark.wordTwo = readLine()!!
        print("3rd attempt ---> Type a WORD: ")
        placemark.wordThree = readLine()!!
        print("Type an id: ")
        placemark.id = readLine()!!.toLong()

        when (inputNumber) {
            1 -> placemarkView.checkWord_Lvl_1(placemark)
            2 -> placemarkView.checkWord_Lvl_2(placemark)
            3 -> placemarkView.checkWord_Lvl_3(placemark)
            4 -> placemarkView.checkWord_Lvl_4(placemark)
            5 -> placemarkView.checkWord_Lvl_5(placemark)
            6 -> placemarkView.checkWord_Lvl_6(placemark)
            7 -> placemarkView.checkWord_Lvl_7(placemark)
            8 -> placemarkView.checkWord_Lvl_8(placemark)
            9 -> placemarkView.checkWord_Lvl_9(placemark)
        }

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }

    fun updatePlacemarkData(placemark : PlacemarkModel) : Boolean {

        var tempWordOne: String?
        var tempwordTwo: String?
        var tempWordThree: String?
        var tempId: Long?

        if (placemark != null) {
            print("[ERROR] Please enter again your 1st word for [ " + placemark.wordOne   + " ] : ")
            tempWordOne = readLine()!!
            print("[ERROR] Please enter again your 2nd word for [ " + placemark.wordTwo   + " ] : ")
            tempwordTwo = readLine()!!
            print("[ERROR] Please enter again your 3rd word for [ " + placemark.wordThree + " ] : ")
            tempWordThree = readLine()!!
            print("[ERROR] Please try enter a different id for [ "  + placemark.id        + " ] : ")
            tempId = readLine()!!.toLong()

            if (!tempWordOne.isNullOrEmpty() && !tempwordTwo.isNullOrEmpty() && !tempWordThree.isNullOrEmpty()) {
                placemark.wordOne   = tempWordOne
                placemark.wordTwo   = tempwordTwo
                placemark.wordThree = tempWordThree
                placemark.id        = tempId
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }

    // 1
    fun checkWord_Lvl_1(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "KEY" || placemark.wordTwo == "KEY" || placemark.wordThree == "KEY" ||
            placemark.wordOne == "Key" || placemark.wordTwo == "Key" || placemark.wordThree == "Key" ||
            placemark.wordOne == "key" || placemark.wordTwo == "key" || placemark.wordThree == "key") {

            rightAnsw++
            print("\nYou are right, KEY is the answer")
        }
        else print("You are wrong, KEY was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 2
    fun checkWord_Lvl_2(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "DECK" || placemark.wordTwo == "DECK" || placemark.wordThree == "DECK" ||
            placemark.wordOne == "Deck" || placemark.wordTwo == "Deck" || placemark.wordThree == "Deck" ||
            placemark.wordOne == "deck" || placemark.wordTwo == "deck" || placemark.wordThree == "deck") {

            rightAnsw++
            print("\nYou are right, DECK is the answer")
        }
        else print("You are wrong, DECK was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 3
    fun checkWord_Lvl_3(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "TRUNK" || placemark.wordTwo == "TRUNK" || placemark.wordThree == "TRUNK" ||
            placemark.wordOne == "Trunk" || placemark.wordTwo == "Trunk" || placemark.wordThree == "Trunk" ||
            placemark.wordOne == "trunk" || placemark.wordTwo == "trunk" || placemark.wordThree == "trunk") {

            rightAnsw++
            print("\nYou are right, TRUNK is the answer")
        }
        else print("You are wrong, TRUNK was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 4
    fun checkWord_Lvl_4(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "PUPIL" || placemark.wordTwo == "PUPIL" || placemark.wordThree == "PUPIL" ||
            placemark.wordOne == "Pupil" || placemark.wordTwo == "Pupil" || placemark.wordThree == "Pupil" ||
            placemark.wordOne == "pupil" || placemark.wordTwo == "pupil" || placemark.wordThree == "pupil") {

            rightAnsw++
            print("\nYou are right, PUPIL is the answer")
        }
        else print("You are wrong, PUPIL was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 5
    fun checkWord_Lvl_5(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "CASE" || placemark.wordTwo == "CASE" || placemark.wordThree == "CASE" ||
            placemark.wordOne == "Case" || placemark.wordTwo == "Case" || placemark.wordThree == "Case" ||
            placemark.wordOne == "case" || placemark.wordTwo == "case" || placemark.wordThree == "case") {

            rightAnsw++
            print("\nYou are right, CASE is the answer")
        }
        else print("You are wrong, CASE was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 6
    fun checkWord_Lvl_6(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "BANK" || placemark.wordTwo == "BANK" || placemark.wordThree == "BANK" ||
            placemark.wordOne == "Bank" || placemark.wordTwo == "Bank" || placemark.wordThree == "Bank" ||
            placemark.wordOne == "bank" || placemark.wordTwo == "bank" || placemark.wordThree == "bank") {

            rightAnsw++
            print("\nYou are right, BANK is the answer")
        }
        else print("You are wrong, BANK was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 7
    fun checkWord_Lvl_7(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "SHEET" || placemark.wordTwo == "SHEET" || placemark.wordThree == "SHEET" ||
            placemark.wordOne == "Sheet" || placemark.wordTwo == "Sheet" || placemark.wordThree == "Sheet" ||
            placemark.wordOne == "sheet" || placemark.wordTwo == "sheet" || placemark.wordThree == "sheet") {

            rightAnsw++
            print("\nYou are right, SHEET is the answer")
        }
        else print("You are wrong, SHEET was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 8
    fun checkWord_Lvl_8(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "TANK" || placemark.wordTwo == "TANK" || placemark.wordThree == "TANK" ||
            placemark.wordOne == "Tank" || placemark.wordTwo == "Tank" || placemark.wordThree == "Tank" ||
            placemark.wordOne == "tank" || placemark.wordTwo == "tank" || placemark.wordThree == "tank") {

            rightAnsw++
            print("\nYou are right, TANK is the answer")
        }
        else print("You are wrong, TANK was the answer\n")

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
    // 9
    fun checkWord_Lvl_9(placemark : PlacemarkModel) : Boolean{
        if( placemark.wordOne == "RACQUET" || placemark.wordTwo == "RACQUET" || placemark.wordThree == "RACQUET" ||
            placemark.wordOne == "Racquet" || placemark.wordTwo == "Racquet" || placemark.wordThree == "Racquet" ||
            placemark.wordOne == "racquet" || placemark.wordTwo == "racquet" || placemark.wordThree == "racquet") {

            rightAnsw++
            print("\nYou are right, RACQUET is the answer")
        }
        else print("You are wrong, RACQUET was the answer\n")

        print("\nThis is the end of the game, you guessed $rightAnsw right words")
        inputNumber = 0

        return placemark.wordOne.isNotEmpty() && placemark.wordTwo.isNotEmpty() && placemark.wordThree.isNotEmpty()
    }
}