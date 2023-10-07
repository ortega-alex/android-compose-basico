package com.dev.hellowcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.hellowcompose.ui.theme.HellowComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // DefaultPreview() // introducion
            // Columns() // columnas
            // LazyColumns() // lazy columnas y filas
            ViewContainer() // Scaffold
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toobar() },
        content = { Content() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Suscribete", Toast.LENGTH_SHORT).show()
    }) {
        Text("X")
    }
}

@Composable
fun Toobar() {
    TopAppBar(
        title = { Text(text = "AristiDevs Profile", color = colorResource(id = R.color.white)) },
        backgroundColor = colorResource(id = R.color.backgroud)
    )
}

@Composable
fun Content() {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn( // misma funcionalidad que Column pero mientras se realiza scroll se van cargando los items
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.aris),
                contentDescription = "logo AristiDev",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "AristiDev",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(text = "Suscribete", color = Color.White)
            Text(text = "Hola", color = Color.White)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Text(text = "Stack", color = Color.White)
                    Text(text = "Java ", color = Color.White)
                    Text(text = "Kotlin", color = Color.White)
                }
            }
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun LazyColumns() {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn( // misma funcionalidad que Column pero mientras se realiza scroll se van cargando los items
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.aris),
                contentDescription = "logo AristiDev",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "AristiDev",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(text = "Suscribete", color = Color.White)
            Text(text = "Hola", color = Color.White)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Text(text = "Stack", color = Color.White)
                    Text(text = "Java ", color = Color.White)
                    Text(text = "Kotlin", color = Color.White)
                }
            }
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun Columns() {
    Column( // permite ordenar como si fuese unb linear layout pero sin scroll
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Image(
            painter = painterResource(id = R.drawable.aris),
            contentDescription = "logo AristiDev",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
        Text(
            text = "AristiDev",
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(text = "Suscribete")
        Text(text = "Hola")
    }
}

// @Preview(showBackground = true) // permite visualizar un previo, solo funciona sin parametros
@Composable
fun DefaultPreview() {
    HellowComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

