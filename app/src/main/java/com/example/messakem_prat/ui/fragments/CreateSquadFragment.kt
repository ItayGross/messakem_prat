package com.example.messakem_prat.ui.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.messakem_prat.R
import com.example.messakem_prat.databinding.FragmentCreateSquadBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateSquadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateSquadFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCreateSquadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_create_squad, container, false)
        /*bind =
            DataBindingUtil.inflate(inflater, R.layout.fragment_squad_list, container, false)*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgBtnReturn.setOnClickListener() {
            binding.fragmentCreateSquad.findNavController()
                .navigate(R.id.action_createSquadFragment_to_squadListFragment)
        }
        binding.fabCreateSquad.setOnClickListener() {
            /*val unitName = binding.etUnit.toString()
            val squadName = binding.etSquad.toString()
            bind.list.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = squadAdapter
            }
            squadAdapter.setData(Squad.getSquad(unitName, squadName))*/
            binding.fragmentCreateSquad.findNavController()
                .navigate(R.id.action_createSquadFragment_to_squadListFragment)
        }
        binding.etUnit.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                binding.etSquad.requestFocus()
                return@OnKeyListener true
            }
            false
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateSquadFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateSquadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}