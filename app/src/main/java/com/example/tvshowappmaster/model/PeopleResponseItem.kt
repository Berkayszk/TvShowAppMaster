package com.example.tvshowappmaster.model

data class PeopleResponseItem(
    val _links: LinksX,
    val birthday: String,
    val country: CountryX,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: ImageX,
    val name: String,
    val updated: Int,
    val url: String
)