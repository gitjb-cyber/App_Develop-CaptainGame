package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    // CaptainGame 은 배의 방향을 정하고 보물을 찾으면
    // 기억하여 값을 +1 증가
    @Composable
    fun CaptainGame() {
        // val 은 변할 수 없지만 변수 안에 넣는 것을 바꾸는 것이 아니라
        // 변수가 내재적으로 무엇인지를 변화시키는 remember states 는 바꿀 수 있음
        // Ex) 변수 안에 상자를 집어 넣는것. 상자는 변하지 않지만, 상자 안의 내용물은 변화 가능
        // val treasuresFound = remember { mutableStateOf(0) }
        var treasuresFound by remember { mutableStateOf(0) } // 찾은 보물을 기억(값은 가변적인 상태)
        val direction = remember { mutableStateOf("North(북쪽)") } // 배가 향하는 방향(북쪽으로 기억)
        val stormOrTreasure = remember { mutableStateOf("") }

        Column { // 아이템을 쌓을 목적
            // Int 형의 treasuresFound 의 값에 접근하기 위해 변수이름.value(값)
            Text(text = "Treasures Found(찾은 보물): ${treasuresFound}")
            Text(text = "Current Direction(현재 방향): ${direction.value}")
            Text(text = "Result(결과) : ${stormOrTreasure.value}")

            // 버튼을 클릭하면 방향은 바뀌지만, 보물을 찾는건 Random(50%)
            Button(onClick = { // 버튼을 클릭하면 나오는 행동
                direction.value = "East(동쪽)" // 방향 값을 동쪽으로 바꿈
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "We Found a Treasure!(보물을 찾았다!)"
                } else {
                    stormOrTreasure.value = "Storm Ahead!(폭풍이 온다!)"
                }
            }) {
                Text("Sail East(동쪽으로 항해!)")
            }

            Button(onClick = { // 버튼을 클릭하면 나오는 행동
                direction.value = "West(서쪽)" // 방향 값을 서쪽으로 바꿈
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "We Found a Treasure!(보물을 찾았다!)"
                } else {
                    stormOrTreasure.value = "Storm Ahead!(폭풍이 온다!)"
                }
            }) {
                Text("Sail West(서쪽으로 항해!)")
            }

            Button(onClick = { // 버튼을 클릭하면 나오는 행동
                direction.value = "North(북쪽)" // 방향 값을 북쪽으로 바꿈
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "We Found a Treasure!(보물을 찾았다!)"
                } else {
                    stormOrTreasure.value = "Storm Ahead!(폭풍이 온다!)"
                }
            }) {
                Text("Sail North(북쪽으로 항해!)")
            }

            Button(onClick = { // 버튼을 클릭하면 나오는 행동
                direction.value = "South(남쪽)" // 방향 값을 남쪽으로 바꿈
                if (Random.nextBoolean()) {
                    treasuresFound += 1
                    stormOrTreasure.value = "We Found a Treasure!(보물을 찾았다!)"
                } else {
                    stormOrTreasure.value = "Storm Ahead!(폭풍이 온다!)"
                }
            }) {
                Text("Sail South(남쪽으로 항해!)")
            }
        }
    }
}
