package com.example.productssamples.Adapter


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.plusAssign
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.productssamples.Model.DrugsModel
import com.example.userrequestsample.R


var sumOfAllCountsTemp:Int = 0
var sumOfAllCounts:Int = 0
var Counter:Int = 0
var sumOfOneItemCounts:Int = 0
class DrugListAdapter(private var drugs: MutableList<DrugsModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.drug_item, parent, false)
        return DrugsViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
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
                    it.isEnabled=false
                    //holder.elegantbutton.visibility = 1
                    holder.cart.visibility = View.GONE
                    holder.counter_constraint.isVisible=true

                }
                holder.plus_btn.setOnClickListener {
                    if(Counter >= 3)
                    {
                        Toast.makeText(context, "you exceed the maximum samples \n " +
                                "you must choose only 3 items", Toast.LENGTH_SHORT).show()
                        holder.plus_btn.isClickable = false
                    }
                    else
                    {
                        holder.plus_btn.isClickable = true
                        Counter++
                        holder.counter_tv.setText(Counter.toString())
                    }

                }
                holder.minus_btn.setOnClickListener {
                    if(Counter == 0)
                    {
                         holder.minus_btn.isClickable = false

                    }
                    else
                    {
                        holder.minus_btn.isClickable = true
                        Counter--
                        holder.counter_tv.setText(Counter.toString())
                    }

                }
                //sumOfAllCounts+=Counter

               // var elegantButton = holder.elegantbutton
                //var view:ElegantNumberButton
                /*elegantButton.setOnValueChangeListener { view, oldValue, newValue ->
                    if(sumOfAllCounts > 3 )
                    {
                        *//*Toast.makeText(context, "you exceed the maximum samples \n you must choose only 3 items", Toast.LENGTH_SHORT).show()
                        //elegantButton.setNumber("0")
                        holder.elegantbutton.isClickable = false
                        holder.elegantbutton.isEnabled = false
                        elegantButton.isClickable = false
                        elegantButton.isEnabled = false*//*
                      //  elegantButton.isContextClickable = false
                    }
                    else
                    {
                        //elcode msh mazbot
                        //sumOfOneItemCounts += (newValue-oldValue)
                        sumOfAllCountsTemp = elegantButton.number.toInt()
                        elegantButton
                        drugs[position].Drug_Selected = elegantButton.number.toInt()

                        // Toast.makeText(context, "old value "+ oldValue, Toast.LENGTH_SHORT).show()
                        // Toast.makeText(context, "new value "+ newValue, Toast.LENGTH_SHORT).show()
                        //Toast.makeText(context, "number "+ elegantButton.number, Toast.LENGTH_SHORT).show()
                         Toast.makeText(context, "count " + sumOfAllCountsTemp, Toast.LENGTH_SHORT).show()
                        *//*if(elegantButton.number.toInt() > 3 ){
                            elegantButton.setNumber("0")
                            Toast.makeText(context, "you exceed the maximum samples \n you must choose only 3 items", Toast.LENGTH_SHORT).show()
                        }*//*
                    }

                    sumOfAllCounts+= sumOfAllCountsTemp
                }*/
                //sumOfAllCounts+= sumOfAllCountsTemp
                /*sumOfCounts += elegantButton.number.toInt()
                Toast.makeText(context, "number "+ elegantButton.number, Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "child count " + elegantButton.childCount, Toast.LENGTH_SHORT).show()
            })*/
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
    var counter_tv: TextView = view.findViewById(R.id.counter_tv_id)
    var plus_btn: ImageView = view.findViewById(R.id.counter_plus_id)
    var minus_btn: ImageView = view.findViewById(R.id.counter_minus_id)

    var cart: Button = view.findViewById(R.id.btn_addToCart)
    var counter_constraint: ConstraintLayout= view.findViewById(R.id.counter_constraint_id)
    //var elegantbutton: ElegantNumberButton= view.findViewById(R.id.btn_elegantButton)
}