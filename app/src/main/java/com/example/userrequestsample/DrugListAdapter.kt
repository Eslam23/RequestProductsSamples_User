package com.example.productssamples.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.productssamples.Model.DrugsModel
import com.example.userrequestsample.R

var sumOfCounts:Int = 0
class DrugListAdapter (private var drugs: MutableList<DrugsModel> ,private val context: Context) :
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
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.drug_item, parent, false)
        return DrugsViewHolder(view)
    }

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
                    holder.elegantbutton.isVisible=true
                }

                val elegantButton = holder.elegantbutton
                //var view:ElegantNumberButton
                elegantButton.setOnValueChangeListener { view, oldValue, newValue ->
                    //elcode msh mazbot
                    sumOfCounts += (newValue-oldValue)

                    drugs[position].Drug_Selected = elegantButton.number.toInt()
                    Toast.makeText(context, "old value "+ oldValue, Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "new value "+ newValue, Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "number "+ elegantButton.number, Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "count " + sumOfCounts, Toast.LENGTH_SHORT).show()
                    if(sumOfCounts > 3 ){
                        elegantButton.setNumber("0")
                    }
                }
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
    var cart: Button = view.findViewById(R.id.btn_addToCart)
    var elegantbutton: ElegantNumberButton= view.findViewById(R.id.btn_elegantButton)
}