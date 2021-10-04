package com.example.userrequestsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productssamples.Adapter.DrugListAdapter
import com.example.productssamples.Model.DrugsModel

private lateinit var recycler: RecyclerView
class DrugListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_list)

        val drugs = mutableListOf<DrugsModel>().apply {
            add(DrugsModel(Drug_Name = "Royal Vit", Drug_Price = "EGP 30",Drug_Image = "https://www.sedico.net/english/products/webpages/RoyalVitG/RoyalVitG.png"))

        }
        var displaydrugs =  mutableListOf<DrugsModel>()
        displaydrugs.addAll(drugs)
        val adapter = DrugListAdapter(displaydrugs , this)

        recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(this,2)
        recycler.adapter = adapter

    }
}