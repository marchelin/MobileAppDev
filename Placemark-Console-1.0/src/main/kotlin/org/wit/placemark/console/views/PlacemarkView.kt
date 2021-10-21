package org.wit.placemark.console.views

import org.wit.placemark.console.main.main
import org.wit.placemark.console.main.placemarkModel
import org.wit.placemark.console.main.placemarkView
import org.wit.placemark.console.main.placemarks
import org.wit.placemark.console.models.PlacemarkJSONStore
import org.wit.placemark.console.models.PlacemarkMemStore
import org.wit.placemark.console.models.PlacemarkModel

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
        //print("Type an id: ")
        //placemark.id = readLine()!!.toLong()

        if(placemarkModel.inputOneCounter == 0 && placemarkModel.wordOne   == "Key" ||  placemarkModel.wordTwo   == "Key" ||  placemarkModel.wordThree == "Key")
            print("WORD is CORRECT")
        else if(placemarkModel.inputOneCounter == 1 && placemarkModel.wordOne   == "Key" ||  placemarkModel.wordTwo   == "Key" ||  placemarkModel.wordThree == "Key")
            print("WORD is CORRECT")
        else
        {
            print("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOLE")
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
}
