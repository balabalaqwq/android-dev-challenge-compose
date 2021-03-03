/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cats Nest",
                    )
                },
                backgroundColor = Color.Transparent, elevation = 0.dp
            )
        }
    ) {

        val catList = mutableListOf<Cat>()
        catList.add(
            Cat(
                "Iwe",
                R.drawable.iwe,
                description = "girl, 2, like: ball、watch TV",
                isAdopted = false
            )
        )
        catList.add(
            Cat(
                "Kis",
                R.drawable.kis,
                description = "girl, 1, like: rua、watch TV",
                isAdopted = false
            )
        )
        catList.add(
            Cat(
                "Oer",
                R.drawable.oer,
                description = "boy, 1, like: ball、watch TV",
                isAdopted = false
            )
        )
        catList.add(
            Cat(
                "Pex",
                R.drawable.pex,
                description = "boy, 3, like: ball、watch TV",
                isAdopted = false
            )
        )
        catList.add(
            Cat(
                "Ses",
                R.drawable.ses,
                description = "girl, 2, like: ball、watch TV",
                isAdopted = false
            )
        )
        LazyColumn {
            items(
                catList,
                (
                    {
                        it.toString()
                    }
                    ),
                itemContent = {
                    CatItem(it)
                }
            )
        }
    }
}

@Composable
fun CatItem(cat: Cat) {
    val image = painterResource(id = cat.picture)
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .requiredHeight(220.dp)
            .clickable {
                val intent = Intent(context, CatDetailActivity::class.java)
                intent.putExtra("cat", cat)
                context.startActivity(intent)
            }
    ) {
        Image(
            painter = image,
            contentDescription = cat.name,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                color = Color.Transparent,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Adopted:" + cat.isAdopted.toString(),
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
