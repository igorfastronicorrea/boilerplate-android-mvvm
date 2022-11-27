package com.example.boilerplateandroid.presentation.nearby_sportman_list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.boilerplateandroid.databinding.ActivityNearbyMeBinding
import com.example.boilerplateandroid.presentation.sportman_detail.SportsmanDetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NearbyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearbyMeBinding

    private val viewModel : NearbyViewModel by viewModel()

    private lateinit var adapter: NearbyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNearbyMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observerNearbyMeList()
        setupRecyclerView()
    }

    private fun observerNearbyMeList(){
        viewModel.nearbyMe.observe(this){
            when(it){
                is NearbyViewModel.NearbyMeListUIState.Success -> {
                    Log.i("TAG", "success nearby list")
                    Log.i("TAG", it.data[0].name)

                    adapter.submitList(it.data)
                }
            }
        }
    }

    private fun setupRecyclerView(){
        adapter = NearbyAdapter {
            Log.i(TAG, "on click $it")
            val intent = Intent(applicationContext, SportsmanDetailsActivity::class.java)
            intent.putExtra("ID_SPORTSMAN", it.id)
            startActivity(intent)
        }
        binding.rvSportmans.adapter = adapter
        binding.rvSportmans.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        const val TAG = "NearbyActivity"
    }
}