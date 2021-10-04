package com.example.productssamples.Adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.productssamples.Model.DrugsModel
import com.example.userrequestsample.R
import java.io.Serializable

class DrugListAdapter(private var drugs: MutableList<DrugsModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /*companion object {
        //var adapter: DrugListAdapter? = null
        fun updateData(newDrugs: DrugsModel , postion : Int){

            drugs.set(postion , newDrugs)
            notifyDataSetChanged()
        //drugs.clear()
       // drugs.addAll(newDrugs)
       // notifyDataSetChanged()
    }


    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.drug_item, parent, false)
        return DrugsViewHolder(view)
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is DrugsViewHolder -> {

                val drug_item: DrugsModel = drugs[position]
                holder.drugName.setText(drug_item.Drug_Name)
                holder.drugPrice.setText(drug_item.Drug_Price)
                Glide
                    .with(holder.drugImg.rootView)
                    .load(drug_item.Drug_Image)
                    .into(holder.drugImg)

                holder.cart.setOnClickListener {
                    holder.cart.isEnabled=false
                    holder.elegantbutton.visibility = 1
                }
            }
        }
    }
    @Override
    override fun getItemCount(): Int {
        return drugs.size
    }

}

class DrugsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var drugImg: ImageView = view.findViewById(R.id.drug_img_id)
    var drugName: TextView = view.findViewById(R.id.drug_name_id)
    var drugPrice: TextView = view.findViewById(R.id.drug_price_id)
    var cart: Button = view.findViewById(R.id.btn_addToCart)
    var elegantbutton: ElegantNumberButton= view.findViewById(R.id.btn_elegantButton)
}