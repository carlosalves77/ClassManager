package com.carlos.classmanager.cammon.utils

import com.carlos.classmanager.domain.model.Multimedia

class ListOfMultimedia {

    val customStyle = "body { margin: 0; padding: 0; }"

    val listMultimediaOne = listOf(
        Multimedia("Social Scince", "PDF", "Social Science"),
        Multimedia("", "", "Social Science", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jMMUgnf2E9c?si=hZr4DqH46TXoUJhT\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"),
        Multimedia("Social Scince", "ZIP", "Social Science", "\"<iframe width=\\\"100%\\\" height=\\\"100%\\\" src=\\\"https://www.youtube.com/embed/A7ry4cx6HfY?si=jHnwkQiJ92XzPjQ9\\\" title=\\\"YouTube video player\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\\\" allowfullscreen></iframe>\"")
    )
}