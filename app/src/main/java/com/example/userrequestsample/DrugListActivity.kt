package com.example.userrequestsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productssamples.Adapter.DrugListAdapter
import com.example.productssamples.Model.DrugsModel
import java.util.*

class DrugListActivity : AppCompatActivity() {
    var drugs =  mutableListOf<DrugsModel>()
    var displaydrugs =  mutableListOf<DrugsModel>()
    private lateinit var recycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_list)

        val submit: Button = findViewById(R.id.btn_submit)
        submit.setOnClickListener {
            val i = Intent(this@DrugListActivity,SubmitActivity::class.java)
            startActivity(i)
        }
        drugs = mutableListOf<DrugsModel>().apply {
            add(
                DrugsModel(
                    Drug_Name = "Royal Vit",
                    Drug_Price = "EGP 30",
                    Drug_Image = "https://www.sedico.net/english/products/webpages/RoyalVitG/RoyalVitG.png",
                    3
                )
            )
            add(
                DrugsModel(
                    Drug_Name = "Panadol",
                    Drug_Price = "EGP 12",
                    Drug_Image = "https://i2.wp.com/wikivera.com/wp-content/uploads/2021/03/MGK5158-GSK-Panadol-Tablets-455x455-1.png"
                )
            )
        }
        displaydrugs.addAll(drugs)
        val adapter = DrugListAdapter(displaydrugs , this)
        recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(this,2)
        recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        menu?.findItem(R.id.search)?.let{
            var searchview = it.actionView as SearchView
            searchview.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(text: String?): Boolean {
                    if(text!!.isNotEmpty()){
                        displaydrugs.clear()
                        var search= text.lowercase(Locale.getDefault())
                        for(i in 0 until drugs.size)
                        {
                            if(drugs[i].Drug_Name.lowercase(Locale.getDefault()).contains(search))
                            {
                                displaydrugs.add(drugs[i])
                            }
                            recycler.adapter!!.notifyDataSetChanged()
                        }
                    }
                    else
                    {
                        displaydrugs.clear()
                        displaydrugs.addAll(drugs)
                        recycler.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}