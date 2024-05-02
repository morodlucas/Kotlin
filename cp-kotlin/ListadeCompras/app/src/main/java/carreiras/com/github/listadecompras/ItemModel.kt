package carreiras.com.github.listadecompras

data class ItemModel(val name: String, val desc: String, val onRemove: (ItemModel) -> Unit)
