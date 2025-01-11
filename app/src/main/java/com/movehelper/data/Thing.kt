package com.movehelper.data

import androidx.room.Entity

@Entity
data class Thing(
	val name: String,
	val description: String?
)
