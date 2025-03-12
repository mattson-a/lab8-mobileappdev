package edu.msoe.mattsona

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.msoe.mattsona.databinding.ListItemCarBinding

class CarHolder(
    val binding: ListItemCarBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(car: Car, onSelected: (carId: Int) -> Unit) {
        val detailText = "Year: ${car.modelYear} | Make: ${car.make}"
        binding.carDetails.text = detailText

        binding.carDetails.setOnClickListener {
            onSelected(car.id)
        }
    }
}

class CarListAdapter(
    private val cars: MutableList<Car>,
    private val onCarSelected: (carId: Int) -> Unit
) : RecyclerView.Adapter<CarHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCarBinding.inflate(inflater, parent, false)
        return CarHolder(binding)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val car = cars[position]
        holder.bind(car) { carId ->
            onCarSelected(carId)
        }
    }

    override fun getItemCount() = cars.size
}