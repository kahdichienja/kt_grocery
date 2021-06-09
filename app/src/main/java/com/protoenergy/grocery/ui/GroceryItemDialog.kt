package com.protoenergy.grocery.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.protoenergy.grocery.R
import com.protoenergy.grocery.model.GroceryItems
import kotlinx.android.synthetic.main.grocerydialog.*

class GroceryItemDialog(context: Context, var dialogListener: DialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.grocerydialog)

        tvSave.setOnClickListener {
            val name = etItemName.text.toString()
            val quantity = etItemQuantity.text.toString().toInt()
            val price = etItemPrice.text.toString().toInt()

            if(name.isEmpty()) Toast.makeText(context, "Enter Item Name", Toast.LENGTH_SHORT).show()

            val  item = GroceryItems(name, quantity, price)
            dialogListener.onAddButtonClicked(item)


        }
        tvCancel.setOnClickListener{cancel()}

    }
}