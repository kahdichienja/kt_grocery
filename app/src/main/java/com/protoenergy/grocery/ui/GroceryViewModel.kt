package com.protoenergy.grocery.ui

import com.protoenergy.grocery.model.GroceryItems
import com.protoenergy.grocery.repository.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) {

    // In coroutines thread insert item in insert function.
    fun insert(item: GroceryItems) = GlobalScope.launch { repository.insert(item) }
    // In coroutines thread delete item in delete function.
    fun delete(item: GroceryItems) = GlobalScope.launch { repository.delete(item) }

    //Here we initialized allGroceryItems function with repository
    fun allGroceryItems() = repository.allGroceryItems()
}