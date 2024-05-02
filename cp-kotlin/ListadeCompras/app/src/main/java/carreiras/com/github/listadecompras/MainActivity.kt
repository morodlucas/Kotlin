package carreiras.com.github.listadecompras

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val editTextDesc = findViewById<EditText>(R.id.editTextDesc)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextDesc.text.isEmpty()) {
                editTextDesc.error = "Preencha um valor"
                return@setOnClickListener
            }

            val item = ItemModel(
                name = editText.text.toString(),
                desc = editTextDesc.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            editText.text.clear()
            editTextDesc.text.clear()
        }
    }
}
