package com.example.middleexam
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.middleexam.ui.theme.MiddleExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiddleExamTheme {

            }
        }
    }
}

@Composable
fun Navigator(){
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = "Home"){
        composable("Home"){HomePage(navController)}
        composable("aPage"){APage(navController, UserData.AList)}
        composable("EquipmentPage"){EquipmentPage(navController, UserData.equipmentList)}
        composable("EndPage"){EndPage(navController)}
    }
}

@Composable
fun HomePage(navController: NavController){
    Column{
        Button(onClick = {
            navController.navigate("CommodityPage")
        }){
            Text(text = "CommodityPage")
        }
        Button(onClick = {
            navController.navigate("EquipmentPage")
        }){
            Text(text = "EquipmentPage")
        }
        Button(onClick = {
            navController.navigate("EndPage")
        }){
            Text(text = "EndPage")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevieHost(){
    Navigator()
}