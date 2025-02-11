package com.example.logix.data

import com.example.logix.R

object LogixActivityData {

    val ActivityData = listOf(
        LogixItem(
            title = R.string.tech,
            description = R.string.tech_news,
            image = R.drawable.tech,
            date = R.string.tech_date
        ),

        LogixItem(
            title = R.string.sports,
            description = R.string.sports_news,
            image = R.drawable.tilak,
            date = R.string.sports_date
        ),

        LogixItem(
            title = R.string.international,
            description = R.string.international_news,
            image = R.drawable.trump,
            date = R.string.international_date
        ),

        LogixItem(
            title = R.string.politics,
            description = R.string.politics_news,
            image = R.drawable.flights,
            date = R.string.politics_date
        ),

        LogixItem(
            title = R.string.latest,
            description = R.string.latest_news,
            image = R.drawable.republic,
            date = R.string.latest_date
        ),

        LogixItem(
            title = R.string.latest,
            description = R.string.cbi_news,
            image = R.drawable.cbi,
            date = R.string.cbi_date
        ),

        LogixItem(
            title = R.string.latest,
            description = R.string.doctor_news,
            image = R.drawable.doctor,
            date = R.string.doctor_date
        )
    )
}