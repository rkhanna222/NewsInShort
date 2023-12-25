package com.example.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.ui.component.Loader
import com.example.newsinshort.ui.component.ShowNews
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState


const val TAG = "Home_Screen"
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
){

    val newsRes by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        when(newsRes){
            is ResourceState.Loading -> {
                Log.d(TAG,"Inside_Loading")
                Loader()
            }

            is ResourceState.Success ->{

                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG,"Inside_Success ${response.status} = ${response.totalResults}")
                ShowNews(response)
            }

            is ResourceState.Error -> {
                val errorMessage = (newsRes as ResourceState.Error).error
                Log.d(TAG, "Inside_Error: $errorMessage")
                // Handle displaying the error UI here
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}