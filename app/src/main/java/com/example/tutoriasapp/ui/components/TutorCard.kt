package com.example.tutoriasapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutoriasapp.R


@Composable
fun TutorCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row(
            Modifier
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(top = 9.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(90.dp)
                )
            }
            Column(Modifier.padding(8.dp)) {
                Row() {
                    Text(
                        modifier = Modifier.widthIn(2.dp),
                        text = "Alejandro Ruiz",
                        textAlign = TextAlign.Start
                    )
                    Spacer(Modifier.weight(1f))
                    Badge {
                        Text("Fisica")
                    }
                }
                Spacer(modifier.padding(4.dp))
                Text(text = "Facultad de ciencias")
                Spacer(modifier.padding(6.dp))
                Row() {
                    Badge {
                        Text("Fisica")
                    }
                    Spacer(modifier.padding(2.dp))
                    Badge {
                        Text("Fisica")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "$4.500")
                    Spacer(modifier.weight(1f))
                    Button(
                        modifier = Modifier.height(30.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                        shape = RoundedCornerShape(5.dp),
                        onClick = {}) {
                        Text("Reservar")
                    }
                }

            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TutorCardPreview() {
    TutorCard()
}