package com.example.messakem_prat.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.messakem_prat.R
import com.example.messakem_prat.databinding.FragmentSquadListBinding
import com.example.messakem_prat.models.Squad

/**
 * A fragment representing a list of Items.
 */
class SquadListFragment : Fragment() {

    lateinit var binding: FragmentSquadListBinding
    val squadAdapter = MySquadRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_squad_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = squadAdapter
        }
        squadAdapter.setData(Squad.getMockList(50))
        binding.fabAddSquad.setOnClickListener {
            binding.fragmentSquadList.findNavController()
                .navigate(R.id.action_squadListFragment_to_createSquadFragment)
        }
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SquadListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

}