package com.example.listapp

import android.os.Bundle
import android.provider.Telephony.Mms.Addr
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listapp.ui.theme.ListAppTheme
import androidx.compose.material3.OutlinedTextField as sdugs

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListAppTheme {
                var name by remember {
                    mutableStateOf("")
                }
                var names by remember { mutableStateOf<List<String>>(emptyList()) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { text -> name = text },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Button(onClick = {
                            if (name.isNotBlank()) {
                                names = names + name
                                name =""
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }
                    LazyColumn {
                        items(names) { currentName ->
                            Text(
                                text = currentName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

/**
 @Composable
fun Greeting(name: String) {
    //Set the items into a column
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            //You can also use Size attribute to give the elements a Fixed Size
            .fillMaxSize()
    ){
        Text(
            text = "Hello $name!",
            color = Color.Blue,
            fontSize = 25.sp,
        )
        Text(
            text = "We Outside",
            color = Color.Blue,
            fontSize = 25.sp,
        )
    }
}
 @Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListAppTheme {
        Greeting("Eric")
    }
}*/