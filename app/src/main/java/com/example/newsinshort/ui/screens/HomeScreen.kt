package com.example.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsinshort.ui.component.Loader
import com.example.newsinshort.ui.component.NewsRowComponent
import com.example.newsinshort.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState


const val TAG = "Home_Screen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
){

    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){
        100
    }
    
    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
            ) {
        page:Int->
        when(newsRes){
            is ResourceState.Loading -> {
                Log.d(TAG,"Inside_Loading")
                Loader()
            }

            is ResourceState.Success ->{

                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG,"Inside_Success ${response.status} = ${response.totalResults}")
                //ShowNews(response)
                if(response.articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page])
                }
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