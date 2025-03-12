package edu.msoe.mattsona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.msoe.mattsona.databinding.FragmentCarOverviewBinding

class CarOverviewFragment : Fragment() {
    private var _binding: FragmentCarOverviewBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val viewModel: ApplicationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarOverviewBinding.inflate(inflater, container, false)
        binding.carRecycler.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.carRecycler.adapter = CarListAdapter(viewModel.cars) {carId ->
            findNavController().navigate(CarOverviewFragmentDirections.moveToCarDetail(carId))
        }
    }
}