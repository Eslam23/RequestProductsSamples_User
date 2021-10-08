package com.example.productssamples.Model
import java.io.*



data class DrugsModel  (
    val Drug_Name: String,
    val Drug_Price: String,
    val Drug_Image: String ,
    var Drug_Selected: Int = 0,
) : java.io.Serializable