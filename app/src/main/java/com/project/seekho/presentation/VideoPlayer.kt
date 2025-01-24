package com.project.seekho.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun VideoPlayer(videoUrl: String) {

    val videoId = getYouTubeVideoId(videoUrl)

    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    AndroidView(
        factory = { ctx ->
            val youTubePlayerView = YouTubePlayerView(ctx).apply {
                lifecycle.addObserver(this)
            }

            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(videoId ?: "", 0f) // Start playing the video
                }
            })

            youTubePlayerView
        },
        modifier = Modifier.fillMaxSize()
    )
}

fun getYouTubeVideoId(url: String): String? {
    val regex = Regex(
        "(?:https?://)?(?:www\\.|m\\.)?(?:youtube\\.com/(?:[^/\\n\\s]+/.+/|(?:v|e(?:mbed)?)?/|.*[?&]v=)|youtu\\.be/)([^\"&?\\n\\s]{11})"
    )
    val match = regex.find(url)
    return match?.groupValues?.get(1)
}
