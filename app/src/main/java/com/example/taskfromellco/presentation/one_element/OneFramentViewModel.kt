package com.example.taskfromellco.presentation.one_element

import android.content.Context
import android.os.Build
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.taskfromellco.R
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.databinding.FragmentOneElementListBinding
import com.example.taskfromellco.utils.gone
import javax.inject.Inject

class OneFramentViewModel @Inject constructor() : ViewModel() {
    fun setupViews(
        articleModel: ArticleModel,
        binding: FragmentOneElementListBinding,
        context: Context
    ) {
        with(binding) {
            with(articleModel) {
                Glide.with(context).load(this.urlToImage).into(imgOne)
                authorOne.text = String.format(context.getString(R.string.author), this.author)
                titleOne.text = String.format(context.getString(R.string.title), this.title)
                descriptionOne.text =
                    String.format(context.getString(R.string.description), this.description)
                dateOne.text = String.format(
                    context.getString(R.string.date_published),
                    this.publishedAt.substring(0, 10)
                )
                with(webViewOne) {
                    webViewClient = WebViewClient()
                    setWebViewClient(object : WebViewClient() {
                        override fun onPageFinished(view: WebView, url: String) {
                            binding.progressLoadedSait.gone()
                        }
                    })
                    loadUrl(articleModel.url)
                    settings.javaScriptEnabled = true
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        settings.safeBrowsingEnabled = true
                    }
                }
            }
        }
    }
}