package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

//QUE LLEVARA MI IMAGEN
@Composable
fun GreetingWithFullBackgroundImage(
    name: String,
    profession: String,
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        //IMAGEN DE FONDO COMPLETO
        Image(
            painter = painterResource(R.drawable.headshot),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        //DEGRADADO EN EL FONDO NEGRO A TRANSPARENTE
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 900f
                    )
                )
        )

        //ALINEACION DE COLUMNA
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp, vertical = 0.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            //FONDO TRANSPARENTE DE PROFESION
            Surface(
                color = Color(90, 90, 90),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                //TEXTO PROFESION
                Text(
                    text = profession.uppercase(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }

            //TEXTO NOMBRE
            Text(
                text = name,
                fontSize = 40.sp,
                lineHeight = 44.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Start
            )

            //SEPARADOR
            Spacer(modifier = Modifier.height(5.dp))

            //SUBTITULO
            Text(
                text = "PASIÓN POR LA PROGRAMACIÓN",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray,
                letterSpacing = 2.sp
            )

            //SEPARADOR
            Spacer(modifier = Modifier.height(8.dp))

            //ALINEACION DE FILAS PARA LAS SKILLS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                skills.forEach { skill ->
                    SkillTag(skill)
                }
            }

            //SEPARADOR PARA ABAJO
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

//FUNCION PARA LA LISTA DE LAS HABILIDADES SKILL
@Composable
fun SkillTag(skill: String) {
    //FONDO DE LAS SKILLS
    Surface(
        color = Color.White.copy(alpha = 0.1f),
        shape = RoundedCornerShape(50.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.2f))
    ) {
        //TEXTO DE CADA SKILL
        Text(
            text = skill,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

//TEXTO FINAL
@Preview(showBackground = true)
@Composable
fun PresentationCardPreview() {
    PresentationCardTheme {
        GreetingWithFullBackgroundImage(
            name = "Leonardo Zaid\nMoreno Jimenez",
            profession = "Ing. en TIC",
            skills = listOf("Java", "C++", "Python", "SQL", "HTML")
        )
    }
}