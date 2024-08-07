package com.example.vietnam_history

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vietnam_history.data.Datasource
import com.example.vietnam_history.model.Event
import com.example.vietnam_history.ui.theme.Vietnam_historyTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vietnam_historyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HistoryApp()
                }
            }
        }
    }
}

@Composable
fun HistoryApp() {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(Datasource().loadEvents()) { event ->

                var isExpanded by remember { mutableStateOf(false) }

                EventCard(
                    event = event,
                    expanded = isExpanded,
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}


@Composable
fun EventCard(
    event: Event,
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Card(modifier = modifier.clickable{ onClick() }) {

        Column (
            modifier = Modifier.animateContentSize(
            animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ){
            Image(
                painter = painterResource(event.imageResourceId),
                contentDescription = stringResource(event.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(event.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            if (expanded) {
                EventInfo(
                    event.descriptionResourceId,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}


@Composable
fun EventInfo(
    @StringRes Info: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(Info),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Vietnam_historyTheme {
        HistoryApp()
    }
}