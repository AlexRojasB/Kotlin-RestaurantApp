package com.example.android.restaurantapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.food_ticket.view.*

class FoodAdapter(parentContext: Context, listOfFood: ArrayList<Food>) : BaseAdapter() {
    var ListOfFoods = listOfFood
    var ParentContext: Context? = parentContext

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val convertView = convertView
                ?: LayoutInflater.from(this.ParentContext).inflate(R.layout.food_ticket, parent, false)


        val food = this.ListOfFoods[position]

        val holder = convertView.tag as? ViewHolder ?: ViewHolder(convertView)
        convertView.tag = holder
        convertView.tvName.text = food.Name
        convertView.imgFood.setImageResource(food.ImgFood)
        convertView.setOnClickListener({
            val intent = Intent(this.ParentContext, FoodDetails::class.java)
            intent.putExtra("name", food.Name)
            intent.putExtra("descr", food.Desc)
            intent.putExtra("imgFood", food.ImgFood)
            this.ParentContext!!.startActivity(intent)
        })
        return convertView
    }

    override fun getItem(position: Int): Any {
        return this.ListOfFoods[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.ListOfFoods.size
    }

    inner class ViewHolder(view: View) {
        val tvName: TextView = view.tvName // etc
        val imgAnimal: ImageView = view.imgFood // etc
    }
}