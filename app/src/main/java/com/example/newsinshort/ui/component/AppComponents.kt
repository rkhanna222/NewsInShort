package com.example.newsinshort.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsinshort.R
import com.example.newsinshort.data.entity.Articles
import com.example.newsinshort.data.entity.NewsResponse
import com.example.newsinshort.ui.theme.Purple40


@Composable
fun Loader(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        CircularProgressIndicator(
            modifier =
            Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Color.Black

        )
    }
}

@Composable
fun ShowNews(response: NewsResponse){
    
    LazyColumn {
        items(response.articles){
            article -> NormalText(textValue = article.title ?: "NA")
        }
    }
    
}

@Composable
fun NormalText(textValue: String){

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .wrapContentHeight(),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40

        )
    )

}

@Composable
fun HeadingTextComponent(textValue: String){

    Text(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .wrapContentHeight(),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium

        )
    )

}

@Composable
fun NewsRowComponent(page: Int, articles: Articles) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .height(
                    240.dp
                ),
            model = articles.urlToImage,
            contentDescription = "Some issue",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.place_holder),
            error = painterResource(id = R.drawable.place_holder)
            )
        
        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = articles.title?:"")

        Spacer(modifier = Modifier.size(10.dp))

        NormalText(textValue = articles.content?:"")
    }



}

@Preview
@Composable
fun NewsRowComponentPreview(){
    val articles = Articles(
        author = "Mr X",
        title =  "Hello world is grat location",
        description = null,
        url = null,
        source = null,
        urlToImage = null,
        publishedAt = null,
        content = null
)


    NewsRowComponent(page = 0, articles =articles )
}