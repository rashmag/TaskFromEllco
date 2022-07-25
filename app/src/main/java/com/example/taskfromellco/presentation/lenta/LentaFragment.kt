package com.example.taskfromellco.presentation.lenta

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.data.remote_db.ApiClient
import com.example.taskfromellco.data.remote_db.RestService
import com.example.taskfromellco.data.remote_db.Source
import com.example.taskfromellco.databinding.FragmentLentaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.lang.StringBuilder
import kotlin.concurrent.thread

class LentaFragment : Fragment() {

    private var _binding: FragmentLentaBinding? = null

    private val binding get() = _binding!!

    private val viewModel by lazy{
        ViewModelProvider(this).get(LentaViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLentaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        thread {
            ApiClient.getClient().getHeadlines("ru", 1, ApiClient.API_KEY).enqueue(object :
                Callback<List<Source>> {
                override fun onResponse(
                    call: Call<List<Source>>,
                    response: Response<List<Source>>
                ) {
                    val responseBody = response.body()!!

                    val stringBuilder = StringBuilder()
                    for (myData in responseBody) {
                        stringBuilder.append(myData.id)
                        stringBuilder.append("\n")
                    }
                    Log.d("test1","$stringBuilder")
                }

                override fun onFailure(call: Call<List<Source>>, t: Throwable) {
                    Log.d("test1","$call")
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}