package com.example.productssamples.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productssamples.Model.DrugsModel
import com.example.productssamples.R


var sumOfCounts: Int = 0

class DrugListAdapter(private var drugs: MutableList<DrugsModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var s = sumOfCounts.let {
        for (i in 0 until drugs.size) {
            sumOfCounts += drugs[i].Drug_Selected
        }
    }

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
                    it.visibility = View.INVISIBLE
                    holder.counterLayout.visibility = View.VISIBLE
                }

                if (sumOfCounts == 0) {
                    var counter: Int = 0
                    holder.plus.setOnClickListener {
                        if (sumOfCounts < 3) {
                            counter++
                            sumOfCounts += 1
                            holder.counter.text = counter.toString()
                        } else
                            it.isClickable = false
                    }
                    holder.minus.setOnClickListener {
                        if (counter != 0 && sumOfCounts <= 3) {
                            holder.plus.isClickable = true
                            counter--
                            sumOfCounts -= 1
                            holder.counter.text = counter.toString()
                        } else {
                            holder.counterLayout.visibility = View.INVISIBLE
                            holder.cart.visibility = View.VISIBLE
                        }
                    }
                } else {
                    var counter = drugs[position].Drug_Selected
                    if (counter > 0) {

                        holder.cart.visibility = View.INVISIBLE
                        holder.counterLayout.visibility = View.VISIBLE
                        holder.counter.text = drugs[position].Drug_Selected.toString()
                    }
                    holder.plus.setOnClickListener {
                        if (sumOfCounts < 3) {
                            counter++
                            sumOfCounts += 1
                            holder.counter.text = counter.toString()
                        }

                    }
                    holder.minus.setOnClickListener {
                        if (counter > 0 && sumOfCounts <= 3) {
                            holder.plus.isClickable = true
                            counter--
                            sumOfCounts -= 1
                            holder.counter.text = counter.toString()
                        } else if (counter == 0) {
                            holder.counterLayout.visibility = View.INVISIBLE
                            holder.cart.visibility = View.VISIBLE
                        }
                    }
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
    var counterLayout: LinearLayout = view.findViewById(R.id.counter_layout)
    var plus: Button = view.findViewById(R.id.btn_plus)
    var minus: Button = view.findViewById(R.id.btn_minus)
    var counter: TextView = view.findViewById(R.id.tv_counter)
}