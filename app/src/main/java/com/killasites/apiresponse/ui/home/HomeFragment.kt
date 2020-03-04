package com.killasites.apiresponse.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.killasites.apiresponse.ApiActivity
import com.killasites.apiresponse.R
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var bottomSheet = BottomSheetBehavior.from(bottom_sheet_layout)

        btnBottomSheet.setOnClickListener {
            if (bottomSheet.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                bottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }

        class BottomSheetFragment : BottomSheetDialogFragment() {
            override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                      savedInstanceState: Bundle?): View =
                inflater.inflate(R.layout.bottom_sheet2, container, false)

        }

        btnBottomSheetDialogFragment.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(fragmentManager, bottomSheetFragment.tag)
        }

        btnBottomSheetDialog.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet2, null)
            val dialog = BottomSheetDialog(requireActivity())
            dialog.setContentView(view)
            dialog.show()
        }

        btnOpenAPI.setOnClickListener {
            val intent = Intent(context, ApiActivity ::class.java)
            startActivity(intent)
        }
        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })


    }



}