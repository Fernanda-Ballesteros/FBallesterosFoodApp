package com.example.fballesterosfoodapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.example.fballesterosfoodapp.ui.theme.FBallesterosFoodAppTheme
import com.example.fballesterosfoodapp.ui.theme.OrangeFoodApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FBallesterosFoodAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPadding : PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Saludo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            //Icono usuario
            Icon(imageVector = Icons.Default.AccountCircle , contentDescription = "Account Circle", tint = OrangeFoodApp)

            //Texto
            Text(text = "Hola, Fer", fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp))

            Spacer(modifier = Modifier.weight(1f))

            //Icono salir
            Icon(imageVector = Icons.Default.ExitToApp , contentDescription = "Account Circle", tint = OrangeFoodApp)

        } //Fin del saludo

        //Texto nuestras categorias
        Text(
            text = "Nuestras categorias",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 8.dp, start = 12.dp)
        )


        //LazyRow con categorias
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
                ,modifier = Modifier.padding(bottom = 20.dp)
        ) {
            items(categories) { CategoryItem ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        AsyncImage(
                            model = CategoryItem.image,
                            contentDescription = CategoryItem.name,
                            placeholder = painterResource(R.drawable.ic_launcher_background),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(OrangeFoodApp)
                                .size(90.dp)
                                .padding(12.dp)
                        )
                        Text(text = CategoryItem.name, fontSize = 15.sp, fontWeight = FontWeight.Light)
                    }
                }
            }

        //Texto busca los mejores restaurantes
        Text(
            text = "Busca los mejores restaurantes",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 8.dp, start = 12.dp)

        )

        // Lazy Row con restaurantes
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            items(restaurants) { RestaurantItem ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    AsyncImage(
                        model = RestaurantItem.image,
                        contentDescription = RestaurantItem.name,
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(12.dp)
                    )
                    Text(text = RestaurantItem.name, fontSize = 15.sp, fontWeight = FontWeight.Light)
                }
            }
        }// FinaL Lazy Row

        //Texto nuestras mejores comidas
        Text(
            text = "Nuestras mejores comidas",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(6.dp)
        )

        FavFood()
        }// FinaL Lazy Row
    } // Fin del Home Screen




@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7
)

@Composable
fun GreetingPreview() {
    FBallesterosFoodAppTheme {
        HomeScreen(innerPadding = PaddingValues(40.dp))
    }
}