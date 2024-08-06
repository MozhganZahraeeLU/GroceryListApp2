package com.example.grocerylistapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class ItemListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_list, container, false)

        val listView: ListView = view.findViewById(R.id.item_list_view)
        val items = getItemsFromSharedPreferences().toList()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        return view
    }

    private fun getItemsFromSharedPreferences(): Set<String> {
        val sharedPreferences = activity?.getSharedPreferences("GroceryList", Context.MODE_PRIVATE)
        return sharedPreferences?.getStringSet("items", emptySet()) ?: emptySet()
    }
}
