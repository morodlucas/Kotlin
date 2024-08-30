package br.com.fiap.listadecompras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class ItemsViewModel : ViewModel() {

    private var items = mutableListOf<ItemModel>()
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String) {
        val item = ItemModel(
            id = 0,
            name = name,
            onRemove = ::removeItem
        )

        /**
         * Observa as alterações na lista de itens na ViewModel.
         * Quando a lista de itens é alterada, atualiza o ItemsAdapter com a nova lista.
         */
        if (!items.contains(item)) {
            items.add(item)
            itemsLiveData.value = items
        }
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }
}