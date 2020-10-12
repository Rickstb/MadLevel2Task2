package com.example.madlevel2task2

data class Vragenlijst (
    var vragenText: String,
    var vraagCorrect: Boolean
){
    companion object {
        val vragen = arrayOf(
            Vragenlijst("A 'val' and 'var' are the same.", false),
            Vragenlijst("Mobile Application Development grants 12 ECTS.", true),
            Vragenlijst("A Unit in Kotlin corresponds to a void in Java", true),
            Vragenlijst("In Kotlin 'when' replaces the 'switch' operator in Java", true),
        )}
}