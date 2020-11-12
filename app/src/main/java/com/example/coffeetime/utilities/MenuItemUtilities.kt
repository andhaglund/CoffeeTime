package com.example.coffeetime.utilities

import android.content.Context
import android.widget.LinearLayout
import com.example.coffeetime.models.Category
import com.example.coffeetime.models.MenuItem
import com.example.coffeetime.models.Product

class MenuItemUtilities {
    companion object {

        /**
         * Creates a list of menuItems, one for each product
         */
        fun createMenuItems(products: List<Product>): List<MenuItem> {
            val menuItems = mutableListOf<MenuItem>()
            for (product in products) {
                menuItems.add(MenuItem(product))
            }
            return menuItems
        }

        /**
         * Creates a product header view for each product category
         * and a menuItem view for each menuItem in menuItems and places them
         * under the correct category.
         */
        fun createMenuItemAndHeaderViews(context: Context, menuItems: List<MenuItem>): LinearLayout {
            val layout = LinearLayout(context)
            layout.orientation = LinearLayout.VERTICAL

            for (category in Category.values().filter { it != Category.ALL }) {
                layout.addView(ProductUtilities.createProductCategoryHeaderView(context, category))

                for (menuItem in menuItems.filter { it.product.category == category }) {
                    layout.addView(menuItem.createView(context))
                }
            }

            return layout
        }
    }
}