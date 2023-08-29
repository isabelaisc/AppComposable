package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.orangeOfc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fundo branco
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crie nova conta:",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Página 1 de 1",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 20.dp),
            color = Color.Gray
        )
        NameField()
        Spacer(modifier = Modifier.height(13.dp))
        EmailField()
        Spacer(modifier = Modifier.height(13.dp))
        PasswordField()
        Spacer(modifier = Modifier.height(13.dp))
        ConfirmPasswordField()
        Spacer(modifier = Modifier.height(5.dp))
        TextCaracter()
        Spacer(modifier = Modifier.height(13.dp))
        CheckboxSample()
        Spacer(modifier = Modifier.height(13.dp))
        CadButton()
        Spacer(modifier = Modifier.height(20.dp))
        TextLogar()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameField() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nome Completo",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
        )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("" ))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("E-mail",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
        )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(8, 20)))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Senha",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
        )
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordField() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(8, 20)))
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Confirmar senha",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
        )
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
    )
}

@Composable
fun TextCaracter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp) // Reduzir o espaço superior
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Pelo menos 8 caracteres",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
            ),
        )
    }
}

@Composable
fun TextLogar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp) // Reduzir o espaço superior
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Já tenho uma conta",
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Gray,
            ),
        )
    }
}


@Composable
fun CheckboxSample() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .width(180.dp)
            .height(25.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null, // null recommended for accessibility with screenreaders
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.Black, // Change checkmark color
                checkedColor = Color.White, // Set checked color as transparent to keep the checkmark icon
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Mostrar Senha",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}


@Composable
fun CadButton() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // Altura reduzida
            .padding(horizontal = 30.dp), // Espaçamento horizontal reduzido
        containerColor = orangeOfc, // Usando a cor laranja personalizada
        contentColor = Color.White,
        shape = MaterialTheme.shapes.small.copy(CornerSize(10.dp)) // Bordas menos arredondadas
    )

    {
        Text(
            text = "Criar Conta",
            style = TextStyle(
                fontSize = 25.sp,
                color = Color.White,
            ),
        )
    }
}

@Preview
@Composable
fun MyAppPreview() {
    MyApp()
}

@Preview
@Composable
fun UsernameFieldPreview() {
    NameField()
}

@Preview
@Composable
fun EmailFieldPreview() {
    EmailField()
}

@Preview
@Composable
fun PasswordFieldPreview() {
    PasswordField()
}

@Preview
@Composable
fun ConfirmPasswordFieldPreview() {
    ConfirmPasswordField()
}

@Preview
@Composable
fun TextCaracterPreview() {
    TextCaracter()
}

@Preview
@Composable
fun CadButtonPreview() {
    CadButton()
}
