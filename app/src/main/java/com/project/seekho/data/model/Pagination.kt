package com.project.seekho.data.model

data class Pagination(
    val current_page: Int?,
    val has_next_page: Boolean?,
    val items: com.project.seekho.data.model.Items?,
    val last_visible_page: Int?
)