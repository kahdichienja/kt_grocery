package com.protoenergy.grocery.ui

import com.protoenergy.grocery.model.GroceryItems

interface DialogListener {
    // Create a function to add items
    // in GroceryItems on clicking
    fun onAddButtonClicked(item: GroceryItems)
}