package com.ngikut.ngikut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ngikut.layout.component.NgikutLoadingLayout
import com.ngikut.layout.util.NgikutLoadingType
import com.ngikut.layout.util.rememberNgikutLoadingLayoutState
import com.ngikut.ngikut.ui.theme.NgikutJetpackComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NgikutJetpackComponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val loading = remember { mutableStateOf(false) }
                    val pos = remember { mutableStateOf(NgikutLoadingType.FromTop) }
                    val state = rememberNgikutLoadingLayoutState(
                        state = loading.value
                    )

                    NgikutLoadingLayout(
                        state = state,
                        loadingType = pos.value
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(
                                    onClick = {
                                        loading.value = !loading.value
                                        pos.value = NgikutLoadingType.FromTop
                                    }
                                ) {
                                    Text(text = "TOP")
                                }

                                Button(
                                    onClick = {
                                        loading.value = !loading.value
                                        pos.value = NgikutLoadingType.FromBottom
                                    }
                                ) {
                                    Text(text = "BOTTOM")
                                }

                                Button(
                                    onClick = {
                                        loading.value = !loading.value
                                        pos.value = NgikutLoadingType.FromStart
                                    }
                                ) {
                                    Text(text = "START")
                                }

                                Button(
                                    onClick = {
                                        loading.value = !loading.value
                                        pos.value = NgikutLoadingType.FromEnd
                                    }
                                ) {
                                    Text(text = "END")
                                }

                                Button(
                                    onClick = {
                                        state.showSnackbar("SNACKBAR WITHOUT ACTION")
                                    }
                                ) {
                                    Text(text = "SHOW SNACKBAR")
                                }

                                Button(
                                    onClick = {
                                        state.showSnackbarWithAction(
                                            "SNACKBAR WITHOUT ACTION",
                                            actionLabel = "TUTUP",
                                            action = {
                                                state.resetSnackbarData()
                                            }
                                        )
                                    }
                                ) {
                                    Text(text = "SHOW SNACKBAR WITH ACTION")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}