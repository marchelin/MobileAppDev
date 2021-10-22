package org.wit.placemark.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class PlacemarkMemStore : PlacemarkStore {
    val placemarks = ArrayList<PlacemarkModel>()

    override fun findAll(): List<PlacemarkModel> {
        return placemarks
    }

    override fun findOne(id: Long) : PlacemarkModel? {
        var foundPlacemark: PlacemarkModel? = placemarks.find { p -> p.id == id }
        return foundPlacemark
    }

    override fun create(placemark: PlacemarkModel) {
        placemarks.add(placemark)
        logAll()
    }

    override fun update(placemark: PlacemarkModel) {
        var foundPlacemark = findOne(placemark.id!!)
        if (foundPlacemark != null) {
            foundPlacemark.wordOne   = placemark.wordOne
            foundPlacemark.wordTwo   = placemark.wordTwo
            foundPlacemark.wordThree = placemark.wordThree
        }
    }

    override fun delete(placemark: PlacemarkModel) {
        placemarks.remove(placemark)
    }

    internal fun logAll() {
        placemarks.forEach { logger.info("${it}") }
    }
}