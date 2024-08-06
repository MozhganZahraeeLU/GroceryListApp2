package com.example.grocerylistapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_item, container, false)

        val addItemButton: Button = view.findViewById(R.id.add_item_button)
        val itemEditText: EditText = view.findViewById(R.id.item_edit_text)

        addItemButton.setOnClickListener {
            val itemName = itemEditText.text.toString()
            if (itemName.isNotEmpty()) {
                saveItemToSharedPreferences(itemName)
                Toast.makeText(context, "Item added: $itemName", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please enter an item name", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun saveItemToSharedPreferences(item: String) {
        val sharedPreferences = activity?.getSharedPreferences("GroceryList", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val items = getItemsFromSharedPreferences().toMutableList()
        items.add(item)
        editor?.putStringSet("items", items.toSet())
        editor?.apply()
    }

    private fun getItemsFromSharedPreferences(): Set<String> {
        val sharedPreferences = activity?.getSharedPreferences("GroceryList", Context.MODE_PRIVATE)
        return sharedPreferences?.getStringSet("items", emptySet()) ?: emptySet()
    }
}
